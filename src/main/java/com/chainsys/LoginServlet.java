package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.service.LoginService;

@Service
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		LoginService login = new LoginService();
		Login log = new Login();
		log.setUserName(uname);
		log.setPassword(pword);
		System.out.println("Welcome" + uname);
		Login log1 = null;

		try {
			log1 = login.findByUsernameAndPassword(log);
		} catch (ServiceException | ValidationException e) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER_ID", e.getMessage());
			response.sendRedirect("Login.jsp");
		}
		System.out.println("Login :" + log1);
		PrintWriter out = response.getWriter();
		out.println(log1);
		if (log1 == null) {
			response.sendRedirect("Login.jsp?error=Login Failed");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER_ID", log1.getUserName());
			response.sendRedirect("report.jsp");
		}
	}
}
