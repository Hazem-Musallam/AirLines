package net.simpleLearn.hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.simpleLearn.hibernate.dao.UserDao;
import net.simpleLearn.hibernate.model.User;

/**
 * @author hazem.musallamau
 */

@WebServlet("/change-password")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("change-password.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("passwordNew");
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("user");

		User user = userDao.getUser(userName);
		user.setPassword(password);
		userDao.update(user);
		request.getSession(false).setAttribute("msg", "Password Changed");
		response.sendRedirect("admin-panel.jsp");

	}
}
