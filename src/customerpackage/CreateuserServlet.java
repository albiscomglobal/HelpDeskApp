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
 * Servlet implementation class CreateuserServlet
 */
@WebServlet("/CreateuserServlet")
public class CreateuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateuserServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 
		String name = request.getParameter("name"); 
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String addresss = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		 
		
		 
		try(Connection con= DBConnection.getConnection()){
	        
  
 PreparedStatement ps=con.prepareStatement("insert into user (name,phone,email,address,username,password,role) values (?,?,?,?,?,?,?)");
 ps.setString(1,name);
 ps.setString(2,phone);
 ps.setString(3,email);
 ps.setString(4,addresss);
 ps.setString(5,username);
 ps.setString(6,password);
 ps.setString(7,role);

  
  
 int i = ps.executeUpdate();
 
 if(i>0);
 


 		 
 		 
 RequestDispatcher 
     rd = request.getRequestDispatcher("/Createduserssuccessfully.jsp");
 rd.include(request, response);
 
 }
catch (Exception e ) {
     e.printStackTrace();
	   
 } 

	}
}
    

