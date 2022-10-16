package customerpackage;
import java.util.HashMap;

import customerpackage.Users;
public class LoginService {
	HashMap<String, String> Users = new HashMap<String, String>();
	 
	 


	public LoginService (){
		Users.put("awoye", "awoye");
		Users.put("administrator", "administrator");
		Users.put("role", "role");
		 

	 
		

	}
	public  Users getuserDetails(){
		Users Users = new Users();
		Users.setUsername(Users.getUsername());
		Users.setUsername("username");
		Users.setAdministrator(Users.getAdministrator());
		Users.setAdministrator("administrator"); 
 
	    return Users;
	    
	    
	}
	 
	 }
		 
		


 
