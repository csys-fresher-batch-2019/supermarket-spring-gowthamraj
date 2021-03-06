package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.service.LoginService;

@WebServlet("/LoginRegister")
@Service
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO v=DAOFactory.getLoginDAO();
		String uname = request.getParameter("username");
		String pword = request.getParameter("pwd");
		LoginService log = new LoginService();
		//UserValidation v = new UserValidation();
		Login log1 = new Login();
		log1.setUserName(uname);
		log1.setPassword(pword);
		boolean inserted = false;
		PrintWriter out = response.getWriter();
		boolean alreadyRegistered = false;
		try {
			alreadyRegistered = v.isUsernameExists(log1.getUserName());
			System.out.println(alreadyRegistered);
			if (alreadyRegistered) {

				System.out.println("already");

			} else {
				log.save(log1);
				inserted = true;

			}

		
		out.println(inserted);

		if (alreadyRegistered) {
			request.setAttribute("errmessage", "username Already Exist");
			RequestDispatcher dispatcher = request.getRequestDispatcher("NewUserRegistration.jsp");
			dispatcher.forward(request, response);
		} else if (inserted) {
			request.setAttribute("Success", "registration succesfull");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}

	
	}
	catch (Exception e) {
		request.setAttribute("errmessage", e.getMessage());
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewUserRegistration.jsp");
		dispatcher.forward(request, response);
		inserted = false;
	}

	}
}
