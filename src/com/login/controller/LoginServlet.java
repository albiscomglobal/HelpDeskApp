	package com.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import com.login.bean.LoginBean;
import com.login.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			 String userName = request.getParameter("username");
			 String password = request.getParameter("password");
			 
			 LoginBean loginBean = new LoginBean();
			 
			 loginBean.setUserName(userName);
			 loginBean.setPassword(password);
			 
			 LoginDao loginDao = new LoginDao();
			 
			 try
			 {
			 String userValidate = loginDao.authenticateUser(loginBean);
			 
			 if(userValidate.equals("Admin_Role"))
			 
			 {
			 System.out.println("Admin's Home");
			 
			 HttpSession session = request.getSession( ); //Creating a session
			 session.setAttribute("Admin", userName); //setting session attribute
			 request.setAttribute("userName", userName);
			  
				
			 request.getRequestDispatcher("/index.jsp").forward(request, response);
			 }
			 else if(userValidate.equals("Admin_Role"))
			 {
			 System.out.println("AdminHomePage Home");
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("Admin", userName);
			 request.setAttribute("userName", userName);
			 session.getAttribute("userName"); 
			 
			 
			 
			/* if(username.equals("studyeasy") && password.equals("Love")) {
					//Invalidating session if any
					request.getSession().invalidate();
					HttpSession newSession = request.getSession(true);
				    newSession.setMaxInactiveInterval(300);
				    newSession.setAttribute("username", username);
				    response.sendRedirect("memberArea.jsp");*/
				
			 ///AdminHomePage.jsp to be changed
			 request.getRequestDispatcher("/AdminHomePage.jsp").forward(request, response);
			 }
			 else if(userValidate.equals("Admin_Role"))
			 {
			 System.out.println("Admin's Home");
			 
			 HttpSession session = request.getSession(true);
		     request.getSession().invalidate();
			 session.setMaxInactiveInterval(300);
			 session.setAttribute("Admin", userName);
			 request.setAttribute("userName", userName);
			 
		
			 
			 request.getRequestDispatcher("/AdminHomePage.jsp").forward(request, response);
			 }
			 else if(userValidate.equals("MedicalLab_Role"))
			 {
				 System.out.println("Medical Laboratory Home");
				 
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(300);
				 session.setAttribute("MedicalLab", userName);
				 request.setAttribute("userName", userName);
				 
				 request.getRequestDispatcher("/MedicalLabPage.jsp").forward(request, response);
				 }
			 
			 else if(userValidate.equals("Radiology_Role"))
			 {
				 System.out.println("Radiology Home");
				 
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(300);
				 session.setAttribute("Radiology", userName);
				 request.setAttribute("userName", userName);
				 
				 request.getRequestDispatcher("/RadiologyPage.jsp").forward(request, response);
				 }
			 
			 else if(userValidate.equals("Account_Role"))
			 {
				 System.out.println("Account Home");
				 
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(300);
				 session.setAttribute("Account", userName);
				 request.setAttribute("userName", userName);
				 
				 request.getRequestDispatcher("/Account.jsp").forward(request, response);
				 }
			 
			 
			 else if(userValidate.equals("Reception_Role"))
			 {
				 System.out.println("Reception Home");
				 
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(300);
				 session.setAttribute("Reception", userName);
				 request.setAttribute("userName", userName);
				 
				 request.getRequestDispatcher("/reception.jsp").forward(request, response);
				 }
			 
			 else if(userValidate.equals("wellness_Role"))
			 {
				 System.out.println("wellness Home");
				 
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(300);
				 session.setAttribute("wellness", userName);
				 request.setAttribute("userName", userName);
				 
				 request.getRequestDispatcher("/WellnessPage.jsp").forward(request, response);
				 }
			 
			 
			 else if(userValidate.equals("superadmin_Role"))
			 {
				 System.out.println("super Home");
				 
				 HttpSession session = request.getSession();
				 session.setMaxInactiveInterval(300);
				 session.setAttribute("super", userName);
				 request.setAttribute("userName", userName);
				 
				 request.getRequestDispatcher("/SuperAdminHomePage.jsp").forward(request, response);
				 }
			 
			 else
			 {
			 System.out.println("Error message = "+userValidate);
			 request.setAttribute("errMessage", userValidate);
			 request.setAttribute("loginError","Incorrect password");    
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
			 }
			 }
			 catch (IOException e1)
			 {
			 e1.printStackTrace();
			 }
			 catch (Exception e2)
			 {
			 e2.printStackTrace();
			 }
			} //End of doPost()
			
}
}