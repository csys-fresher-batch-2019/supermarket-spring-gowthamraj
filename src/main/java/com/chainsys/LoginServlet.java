package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.supermarketapp.dao.impl.LoginImple;
import com.chainsys.supermarketapp.model.Login;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		LoginImple login = new LoginImple();
		Login log = new Login();
		log.setUsername(uname);
		log.setPassword(pword);
		System.out.println("Welcome" + uname);
		Login log1 = null;
		try {
			log1 = login.check(log);
			
		} catch (Exception e) {
			
		}
		
		PrintWriter out = response.getWriter();
		out.println(log1);
		if ( log1 ==null) {
			response.sendRedirect("Login.jsp?error=Login Failed");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER_ID", log1.getUsername());
			response.sendRedirect("report.jsp");
		}
	}
}

