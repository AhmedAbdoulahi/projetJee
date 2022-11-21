package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse ;
import javax.inject.Inject ;

import ma.fstt.dao.CommandeRepositoryImpl;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
public class ControllerServletCommande {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject private CommandeRepositoryImpl cli ;
	public void init() {
 
		CommandeRepositoryImpl cli = new CommandeRepositoryImpl();
 
    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
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
	       
	       List<Commande> listCommande = cli.findAll();
	       request.setAttribute("listcommande", listCommande);
	       RequestDispatcher dispatcher = request.getRequestDispatcher("listcommande.jsp");
	       dispatcher.forward(request, response);
	   }
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("FormulaireCommande.jsp");
	        dispatcher.forward(request, response);
	    }
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Commande exist = cli.findById((long) id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("FormulaireCommande.jsp");
	        request.setAttribute("commande", exist);
	        dispatcher.forward(request, response);
	 
	    }
	    private void insert(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ParseException {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	        Date date_cmd = formatter.parse( request.getParameter("date_cmd") );
	        int client = Integer.parseInt(request.getParameter("client")) ;
	        String produit = request.getParameter("produit");
	        String qte_cmd = request.getParameter("qte_cmd");
	 
	        Commande c = new Commande(date_cmd, client);
	        cli.ajouterCommande(c) ;
	        response.sendRedirect("listcommande");
	    }
	    private void update(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException {
	        int id = Integer.parseInt(request.getParameter("id"));
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	        Date date_cmd = formatter.parse( request.getParameter("date_cmd") );
	        int client = Integer.parseInt(request.getParameter("client")) ;
		    String produit = request.getParameter("produit");
	        String qte_cmd = request.getParameter("qte_cmd");
	        Commande c = new Commande(date_cmd, client );
	        cli.ajouterCommande(c) ;
	        response.sendRedirect("listcommande");
	    }
	 
	    private void delete(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        
	        Commande exist = cli.findById((long) id);
	        cli.supprimer(exist);
	        response.sendRedirect("listcommande");
	 
	    }
	 
	 
	
}
