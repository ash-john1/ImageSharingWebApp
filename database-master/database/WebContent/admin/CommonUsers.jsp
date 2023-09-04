<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Common Users</title>
</head>
<body>
 	<div style = "background-color: lightblue;" >

	 	<h2 >      
	    		<a style="margin-right: 20px;"  href="/database-master_database/feed">Feed </a>
	    		 
		       	<a style="margin-right: 20px;" href="/database-master_database/userProfile">User Profile</a>
		         
		        <a  style="margin-right: 20px;" href="/database-master_database/community">Community</a>
		          
	            <c:if test="${sessionScope.currentUser.email.equals('root')}">
	           
			    	 <a  style="margin-right: 20px;" href="/database-master_database/admin">Administration</a>
			    	 
			    </c:if>                    
	 	</h2>
     	
     
     	<div align="center">
     		<h1>Common Users</h1>
     	 </div>
 	 	 
 	</div>
 	      
 	      
 	       
                                 
    <div align="center">
   	 

	    <form action="getCommonUsers" method="post">
	     <label "email1">Choose a user:</label>
			  <select name="email1" id="email1">
			  <c:forEach var="user" items="${userList}" varStatus="loop">
						 <option value="${user.email}">${user.firstName}  ${user.lastName} </option>
				</c:forEach>
			  </select>
			  
		   <label "email2">Choose a user:</label>
			  <select name="email2" id="email2">
			  <c:forEach var="user" items="${userList}" varStatus="loop">
						 <option value="${user.email}">${user.firstName}  ${user.lastName} </option>
				</c:forEach>
			  </select>
	  <br><br>
	  <input type="submit" value="Submit">
	</form>
	
	<br>
	
	
	 <c:if test="${user1 != null}">
            		<p>Common users between ${user1} and ${user2} <p>
    </c:if>       
	
	<c:forEach var="user" items="${commonUserList}" varStatus="loop">
				<h3>${user.firstName}  ${user.lastName} </h3><br>
    </c:forEach>
	

    </div>   
    
    
</body>
</html>