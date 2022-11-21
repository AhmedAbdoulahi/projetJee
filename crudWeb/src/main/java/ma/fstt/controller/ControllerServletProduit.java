package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ProduitRepositoryImpl;
import ma.fstt.entities.Produit;

@WebServlet("/ListProduit")
public class ControllerServletProduit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject private ProduitRepositoryImpl pro ;
	public void init() {
 
		ProduitRepositoryImpl pro = new ProduitRepositoryImpl();
 
    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        try {
	            switch (action) {
	            case "/new":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insert(request, response);
	                break;
	            case "/delete":
	                delete(request, response);
	                break;
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                update(request, response);
	                break;
	            default:
	                list(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	    private void list(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
	       
	       List<Produit> listProduit = pro.findAll();
	       request.setAttribute("listclient", listProduit);
	       RequestDispatcher dispatcher = request.getRequestDispatcher("listproduit.jsp");
	       dispatcher.forward(request, response);
	   }
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("FormulaireProduit.jsp");
	        dispatcher.forward(request, response);
	    }
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Produit exist = pro.findById((long) id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("FormulaireProduit.jsp");
	        request.setAttribute("produit", exist);
	        dispatcher.forward(request, response);
	 
	    }
	    private void insert(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	        String libelle = request.getParameter("libelle");
	        double prix =Double.parseDouble( request.getParameter("prix"));
	        double qte_stock =Double.parseDouble( request.getParameter("adresse"));
	 
	        Produit p = new Produit(libelle, prix, qte_stock);
	        pro.ajouterProduit(p) ;
	        response.sendRedirect("listproduit");
	    }
	    private void update(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String libelle = request.getParameter("libelle");
	        double prix =Double.parseDouble( request.getParameter("prix"));
	        double qte_stock =Double.parseDouble( request.getParameter("adresse"));
	 
	        Produit p = new Produit(libelle, prix, qte_stock);
	        pro.update(p); ;
	        response.sendRedirect("listproduit");
	    }
	 
	    private void delete(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        
Produit exist = pro.findById((long) id);
	        pro.supprimer(exist);
	        response.sendRedirect("listclient");
	 
	    }
	 
	 
	
}
