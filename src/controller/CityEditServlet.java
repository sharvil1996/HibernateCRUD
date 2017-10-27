package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CityBean;
import dao.CityDAO;

public class CityEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cityId = Integer.parseInt(request.getParameter("cityId"));

		CityBean bean = new CityDAO().getBYPK(cityId);

		if (bean != null) {
			request.setAttribute("cityBean", bean);
			request.getRequestDispatcher("cityEdit.jsp").forward(request, response);
		}
	}

}
