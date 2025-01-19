package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Enquiry;

@WebServlet(name = "deleteenq", urlPatterns = { "/deleteenq" })
public class DeleteEnq extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(request.getParameter("userid"));
			Enquiry reg = new Enquiry(session);
			String status = reg.deleteEnquiryList(id);
			if (status.equals("success")) {
				request.setAttribute("status", "Successfully Deleted");
				request.getRequestDispatcher("enquiryList.jsp").forward(request, response);
			}
			if (status.equals("failure")) {
				request.setAttribute("status", "Deletion failure");
				request.getRequestDispatcher("enquiryList.jsp").forward(request, response);
				response.sendRedirect("enquiryList.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
