package fr.gtm.contacts.contacts_web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.contacts.entities.Civilite;
import fr.gtm.contacts.entities.Contact;
import fr.gtm.contacts.service.ContactService;

@WebServlet("/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactService dto = (ContactService) getServletContext().getAttribute("contactservice");
		String page ="/";
		Contact c = new Contact();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String civilite = request.getParameter("civilite");
		Long id = Long.parseLong(request.getParameter("id"));
		c.setId(id);
		c.setCivilite(Civilite.valueOf(civilite));
		c.setNom(nom);
		c.setPrenom(prenom);
		dto.updateContact(c);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
