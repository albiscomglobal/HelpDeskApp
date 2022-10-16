package customerpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerpackage.DBConnection;

/**
 * Servlet implementation class Bookappointment
 */
@WebServlet("/Bookappointment")
public class Bookappointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookappointment() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
	 
		String employeenumber = request.getParameter("employeenumber");
		String employeenames = request.getParameter("employeenames");
		String phonenumber = request.getParameter("phonenumber");
		String charge_to = request.getParameter("charge_to");
		String message = request.getParameter("message");
		String priority = request.getParameter("priority");
		 
		 
		 
 try(Connection con= DBConnection.getConnection()){
	        
	        
  
 PreparedStatement ps=con.prepareStatement("insert into customer(employeenumber,employeenames,phonenumber,charge_to,message,priority) values (?,?,?,?,?,?)");
 
;
 ps.setString(1,(employeenumber));
 ps.setString(2,employeenames);
 ps.setString(3,phonenumber);
 ps.setString(4,charge_to);
 ps.setString(5,message);
 ps.setString(6,priority);
 
  
 int i = ps.executeUpdate(); 
 
 if(i>0);
 


 		 
 		 
 RequestDispatcher 
     rd = request.getRequestDispatcher("/Appointmentsubmitted.jsp");
 rd.include(request, response);
 
 }
catch (Exception e ) {
     e.printStackTrace();
	   
 } 
}}
