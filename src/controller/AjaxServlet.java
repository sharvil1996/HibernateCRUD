package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDAO;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mname = request.getParameter("method");
		String output = "";
		if (mname.equals("deleteCity")) {
			output = new CityDAO().deleteCity(Integer.parseInt(request.getParameter("cityId")));
		}
		else if(mname.equals("updateCity")){
			output = new CityDAO().updateCity(Integer.parseInt(request.getParameter("cityId")),request.getParameter("cityName"));
		}
		response.setContentType("text");
		response.getWriter().write(output);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
