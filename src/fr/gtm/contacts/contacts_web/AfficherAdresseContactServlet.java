package fr.gtm.contacts.contacts_web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.contacts.dao.ContactDao;
import fr.gtm.contacts.dto.ContactDto;
import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.service.ContactService;


@WebServlet("/AfficherAdresseContactServlet")
public class AfficherAdresseContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ContactService dto = (ContactService) getServletContext().getAttribute("contactservice");
		String page ="/show-adresse.jsp";
		Long id = Long.parseLong(request.getParameter("id"));
		List<Adresse> adresses = dto.getAdressesByContactId(id);
		request.setAttribute("adresses", adresses);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
