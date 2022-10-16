package customerpackage;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	
	private static String url;
    private static Connection conn;
     public static Connection getConnection(){
     try{

       Class.forName("com.mysql.jdbc.Driver");
       url = "jdbc:mysql://localhost:3306/customermanagement?zeroDateTimeBehaviour=convertToNull";    

     conn = DriverManager.getConnection(url,"root","password");
     }   catch (Exception e) {
            System.out.println(e);
        } 
     return conn;
     }
}


