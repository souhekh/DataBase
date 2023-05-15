package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Bean.ContactBean;


/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	            // Établir la connexion à la base de données Oracle
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "votre_utilisateur", "votre_mot_de_passe");
	            
	            // Créer une instruction SQL pour récupérer les données de la table "contact"
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * FROM contact");
	            
	            // Créer une liste de contacts
	            List<ContactBean> contacts = new ArrayList<>();
	            
	            // Parcourir les résultats de la requête et créer des objets ContactBean
	            while (rs.next()) {
	                String nom = rs.getString("nom");
	                String email = rs.getString("email");
	                
	                ContactBean contact = new ContactBean(nom, email);
	                contacts.add(contact);
	            }
	            
	            // Transmettre la liste à la page JSP
	            request.setAttribute("contacts", contacts);
	            request.getRequestDispatcher("contacts.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Fermer les ressources
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
