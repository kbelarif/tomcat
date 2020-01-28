package fr.gtm.contacts.contacts_web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts.dto.ContactDto;
import fr.gtm.contacts.service.ContactService;

@WebServlet("/SupprimerContact")
public class SupprimerContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactService dto = (ContactService) getServletContext().getAttribute("contactservice");
		String page ="/";
		Long id = Long.parseLong(request.getParameter("id"));
		ContactDto c = dto.findByContactId(id);
		dto.remove(c);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
