package fr.gtm.contacts.contacts_web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.contacts.dto.ContactDto;
import fr.gtm.contacts.service.ContactService;


@WebServlet("/AllContactsServlet")
public class AllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ApplicationListener.class.getName());

    public AllContactsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactService service =(ContactService) getServletContext().getAttribute("contactservice");
		String page ="/show-contacts.jsp";
		List<ContactDto> contacts = service.getAllContactsDto();
		request.setAttribute("contacts", contacts);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
