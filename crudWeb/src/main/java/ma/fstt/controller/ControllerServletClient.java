package ma.fstt.controller;

import ma.fstt.dao.ClientRepositoryImpl;
import ma.fstt.entities.Client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServletClient extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject private ClientRepositoryImpl cli ;
	public void init() {
 
        ClientRepositoryImpl cli = new ClientRepositoryImpl();
 
    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        try {
	            switch (action) {
	            case "/ListClient":
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
	       
	       List<Client> listClient = cli.findAll();
	       request.setAttribute("listclient", listClient);
	       RequestDispatcher dispatcher = request.getRequestDispatcher("listclient.jsp");
	       dispatcher.forward(request, response);
	   }
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("FormulaireClient.jsp");
	        dispatcher.forward(request, response);
	    }
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Client exist = cli.findById((long) id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("FormulaireClient.jsp");
	        request.setAttribute("client", exist);
	        dispatcher.forward(request, response);
	 
	    }
	    private void insert(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String adresse = request.getParameter("adresse");
	        String tel = request.getParameter("tel");
	 
	        Client c = new Client(nom, prenom, adresse,tel);
	        cli.ajouterClient(c) ;
	        response.sendRedirect("listclient");
	    }
	    private void update(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String adresse = request.getParameter("adresse");
	        String tel = request.getParameter("tel");	 
	        Client c = new Client(nom, prenom, adresse,tel);
	        cli.ajouterClient(c) ;
	        response.sendRedirect("listclient");
	    }
	 
	    private void delete(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        
	        Client exist = cli.findById((long) id);
	        cli.supprimer(exist);
	        response.sendRedirect("listclient");
	 
	    }
	 
	 
}
