<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Customer Management System </title>
      <!-- Meta tags -->
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <meta name="keywords"/>
      <script>
         addEventListener("load", function () { setTimeout(hideURLbar, 0); }, false); function hideURLbar() { window.scrollTo(0, 1); }
      </script>
      <!-- Meta tags -->
      <!--stylesheets-->
  <link href="style2.css" rel='stylesheet' type='text/css' media="all">
       
      <link rel="stylesheet" href="/customermanagement/BootStrap/css/bootstrap.css">    
<link rel="stylesheet" href="/customermanagement/BootStrap/css/bootstrap-theme.min.css">
<script src="/customermanagement/BootStrap/js/bootstrap.min.js"></script>
      
      <!--//style sheet end here-->
      <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700" rel="stylesheet">
</head>
<body>
   <div id="login" >
      <div class="mid-class">
         <div class="art-right-w3ls">
            <h2>Sign In</h2>
             <form action="<%= request.getContextPath()%>/LoginServlet" method="post">
               
               <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                           <p>Invalid username and password.</p>
                        </div>
                     </c:if>
                     
                     <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                           <p>You have been logged out successfully.</p>
                        </div>
                     </c:if>
                     
                     <c:if test="${not empty loginError}">
                        <div class="alert alert-danger">
                           <h5><center>Wrong Username and Password!</center> </h5>
                        </div>
                     </c:if>
                     
               
               <div class="main">
                  <div class="form-left-to-w3l">
                     <input type="text" name="username" placeholder="Username" required="">
                  </div>
                  <div class="form-left-to-w3l ">
                     <input type="password" name="password" placeholder="Password" required="">
                     <div class="clear"></div>
                  </div>
               </div>
               <!-- <div class="left-side-forget"> -->
                  <!-- <input type="checkbox" class="checked"> -->
                  <!-- <span class="remenber-me">Remember me </span> -->
               <!-- </div> -->
               <!-- <div class="right-side-forget"> -->
                  <!-- <a href="#" class="for">Forgot password...?</a> -->
               <!-- </div> -->
               <!-- <div class="clear"></div> -->
               <div class="btnn">
                  <button type="submit">Sign In</button>
               </div>
            </form>
            <!-- popup-->
            <div id="content1" class="popup-effect">
               <div class="popup">
                  <!--login form-->
                  <div class="letter-w3ls">
                     <form action="#" method="post">
                        <div class="form-left-to-w3l">
                           <input type="text" name="name" placeholder="Username" required="">
                        </div>
                        <div class="form-left-to-w3l">
                           <input type="text" name="name" placeholder="Phone" required="">
                        </div>
                        <div class="form-left-to-w3l">
                           <input type="email" name="email" placeholder="Email" required="">
                        </div>
                        <div class="form-left-to-w3l">
                           <input type="password" name="password" placeholder="Password" required="">
                        </div>
                        <div class="form-left-to-w3l margin-zero">
                           <input type="password" name="password" placeholder="Confirm Password" required="">
                        </div>
                        <div class="btnn">
                           <button type="submit">Sign Up</button>
                           <br>
                        </div>
                     
                     <div class="clear"></div>
                  </div>
                  <!--//login form-->
                  <a class="close" href="#">&times;</a>
               </div>
            </div>
            <!-- //popup -->
         </div>
         <div class="art-left-w3ls">
            <img src="/customermanagement/Images/chams.jpg">
         </div>
      </div>
      <footer class="bottem-wthree-footer">
         <p>
            © 2019 Chams Plc Osogbo by Woye Ahmed.
         </p>
      </footer>
      </div>
   </body>
</html>