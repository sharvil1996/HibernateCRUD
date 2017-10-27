package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CityBean;
import dao.CityDAO;

public class CityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CityDAO dao = new CityDAO();
		ArrayList<CityBean> bean = (ArrayList<CityBean>) dao.listCity();
		request.setAttribute("cityBean", bean);
		request.getRequestDispatcher("city.jsp").forward(request, response);
	}

}
