package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		int userCity = Integer.parseInt(request.getParameter("cityName"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		if (new UserDAO().updateUser(userId, userName, userCity)) {
			System.out.println("Success");
			response.sendRedirect("UserListServlet");
		}

	}

}
