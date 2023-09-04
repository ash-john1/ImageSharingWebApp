import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/UserDAO")
public class UserDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public UserDAO() throws SQLException {
		
    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
 
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    public void dropTable() throws SQLException {
    	connect_func();   
    	statement = connect.createStatement();
    	
    	String sql1 = "DROP TABLE IF EXISTS Users"; 
    	statement.executeUpdate(sql1);
    	 if (statement != null) {
 	        statement.close();
 	     }
    	
    }
    public int createTable() throws SQLException {
    	connect_func();   
    	statement = connect.createStatement();
    	String sql2 = "CREATE TABLE IF NOT EXISTS Users(" + 
    			"	email VARCHAR(100) NOT NULL," + 
    			"	password VARCHAR(20)," + 
    			"	firstName VARCHAR(20),\r\n" + 
    			"	lastName VARCHAR(20),\r\n" + 
    			"	gender CHAR(1),\r\n" + 
    			"	birthday DATE ,\r\n" + 
    			"	numOfFollowers INT,\r\n" + 
    			"	numOfFollowings INT,\r\n" + 
    			"	PRIMARY KEY(email))" ;
    	
    	 int rowsInserted = statement.executeUpdate(sql2);
    	 if (statement != null) {
    	        statement.close();
    	 }
        return rowsInserted;
    }
    
    public boolean fillTable() throws SQLException {
    	connect_func();  
    	statement = connect.createStatement();
    	
    	
    	String sql0 = "INSERT INTO Users(email, password) VALUES('root', 'pass1234')"; 
    	String sql1 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('jhalpert@email.com', 'pass',  'Jim', 'Halpert' , 'M', '1980-1-11', 446, 345)";  
    	String sql2 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('mscott@email.com', 'pass',  'Michael', 'Scott' , 'M', '1970-2-10' , 234, 23456)"; 
    	String sql3 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('dschrute@email.com', 'pass',  'Dwight', 'Schrute' , 'M', '1967-5-19', 56, 1)";
    	String sql4 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('pbeesly@email.com', 'pass',  'Pam', 'Beesly' , 'F', '1979-11-11', 84, 346)";
    	String sql5 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('cbratton@email.com', 'pass',  'Creed', 'Bratton' , 'M', '2008-11-17', 2436, 234)"; 
    	String sql6 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('kmalone@email.com', 'pass',  'Kevin', 'Malone' , 'M', '2008-6-11', 2467, 4765)";
    	String sql7 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('amartin@email.com', 'pass',  'Angela', 'Martin' , 'F', '1967-8-6', 245, 753)";
    	String sql8 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('abernard@email.com', 'pass',  'Andy', 'Bernard' , 'M', '2008-11-2', 433, 345)"; 
    	String sql9 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('shudson@email.com', 'pass',  'Stanley', 'Hudson' , 'M', '1979-5-11', 77, 45)";
    	String sql10 = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES('kkapoor@email.com', 'pass',  'Kelly', 'Kapoor' , 'M', '1967-4-9', 958, 646)";

    	
    	boolean rowInserted0 = statement.executeUpdate(sql0) > 0;
    	boolean rowInserted1 = statement.executeUpdate(sql1) > 0;
    	boolean rowInserted2 =statement.executeUpdate(sql2) > 0;
    	boolean rowInserted3 =statement.executeUpdate(sql3) > 0;
    	boolean rowInserted4 =statement.executeUpdate(sql4) > 0;
    	boolean rowInserted5 =statement.executeUpdate(sql5) > 0;
    	boolean rowInserted6 =statement.executeUpdate(sql6) > 0;
    	boolean rowInserted7 =statement.executeUpdate(sql7) > 0;
    	boolean rowInserted8 =statement.executeUpdate(sql8) > 0;
    	boolean rowInserted9 =statement.executeUpdate(sql9) > 0;
    	boolean rowInserted10 =statement.executeUpdate(sql10) > 0;
    	
    	 return ( rowInserted0 && rowInserted1 && rowInserted2 && rowInserted3 && rowInserted4 && rowInserted5 
    			 && rowInserted6 && rowInserted7 && rowInserted8 && rowInserted9 && rowInserted10 ); 
    }
    
    public boolean insert(User user) throws SQLException {
    	
    	connect_func();
		String sql = "INSERT INTO Users(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOfFollowings) VALUES(?, ?, ?, ?, ?, ?, ?, ?)"; 
    	
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, user.email);
		preparedStatement.setString(2, user.password);
		preparedStatement.setString(3, user.firstName);
		preparedStatement.setString(4, user.lastName);
		preparedStatement.setString(5, user.gender);
		preparedStatement.setString(6, user.birthday);
		preparedStatement.setInt(7, user.numOfFollowers);
		preparedStatement.setInt(8, user.numOfFollowings);
		
		
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowInserted;
    }  
    
    
    public boolean updateNumFollowers(String email, int followerCount) throws SQLException {
    	
    	connect_func();
		String sql = "UPDATE Users\r\n" + 
				"SET numOfFollowers = ?\r\n" + 
				"WHERE email = ?"; 
		
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, followerCount);
			preparedStatement.setString(2, email);
		
		
		
		
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;
    }  
    
    public boolean updateNumFollowings(String email, int followingCount) throws SQLException {
    	
    	connect_func();
		String sql = "UPDATE Users\r\n" + 
				"SET numOfFollowings = ?\r\n" + 
				"WHERE email = ?"; 
		
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, followingCount);
			preparedStatement.setString(2, email);
		
		
		
		
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;
    }  
 
 
    
    public User getUserByEmail(String inputEmail) throws SQLException {
    	connect_func();
    	statement = connect.createStatement();
        String sql = "SELECT * FROM Users WHERE email = ?";
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, inputEmail);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null; 
        if (resultSet.next()) {
        		 
              String email = resultSet.getString("email");
              String password = resultSet.getString("password");
              String firstName = resultSet.getString("firstName"); 
              String lastName = resultSet.getString("lastName");
              String gender = resultSet.getString("gender");
              String birthday = resultSet.getString("birthday"); 
              user = new User(email, password, firstName, lastName, gender, birthday); 
        }

        return user; 

    }       

    public List<User> getAllUsers() throws SQLException{
		List<User> users = new ArrayList<User>();
		
		connect_func();
		
		String sql = "SELECT firstName, lastName, email\r\n" + 
				"FROM Users\r\n" + 
				"WHERE email != 'root'\r\n" + 
				"ORDER BY lastName ASC, firstName ASC "; 

		preparedStatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
        
        while (resultSet.next()) {

       
        	String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName"); 
            String lastName = resultSet.getString("lastName");

            User user = new User(email, firstName, lastName); 
            users.add(user);
        }      
        
		disconnect();
		return users;
	}
    
    
    public List<User> searchUser(String searchFirstName, String searchLastName) throws SQLException{
		List<User> users = new ArrayList<User>();
		
		connect_func();
		
		
		String sql = "SELECT firstName, lastName, email\r\n" + 
				"FROM Users\r\n" + 
				"WHERE ((firstName LIKE '%" + searchFirstName + "%' and  lastName LIKE '%" + searchLastName + "%') or\r\n" + 
				"       (firstName LIKE '%" + searchLastName + "%' and lastName LIKE '%" + searchFirstName + "%')) and" +
				"       email != 'root'\r\n" + 
				"ORDER BY lastName ASC, firstName ASC "; 
		
		preparedStatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
        
        while (resultSet.next()) {

       
        	String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName"); 
            String lastName = resultSet.getString("lastName");

            User user = new User(email, firstName, lastName); 
            users.add(user);
        }      
        
		disconnect();
		return users;
	}
    
    /*
     * [Popular users]: users that  are followed by at least 5 followers.    
     */
    
    public List<User> getPopularUsers() throws SQLException{
		List<User> users = new ArrayList<User>();
		
		connect_func();
		
		String sql = "select *\r\n" + 
				"from Users \r\n" + 
				"where email in (\r\n" + 
				"	select followingEmail\r\n" + 
				"	from follows\r\n" + 
				"	group by followingEmail\r\n" + 
				"	having count(*) >= 5\r\n" + 
				")"; 
		
	
		preparedStatement = connect.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
        
        while (resultSet.next()) {
        	 String email = resultSet.getString("email");
             String password = resultSet.getString("password");
             String firstName = resultSet.getString("firstName"); 
             String lastName = resultSet.getString("lastName");
             String gender = resultSet.getString("gender");
             String birthday = resultSet.getString("birthday"); 
             
             User user = new User(email, password, firstName, lastName, gender, birthday); 
             users.add(user);
        }      
        
		disconnect();
		return users;
	}
    
	/*
	 * Returns an int representing the maximum number of postings
	 * returns -1 if no posts found
	 */
	
	private int getMaxPostCount() throws SQLException{
		
		connect_func(); 
    	
    	String sql = "select count(*) as maxPostCount\r\n" + 
    			"	from images\r\n" + 
    			"	group by postUser\r\n" + 
    			"	order by count(*) desc \r\n" + 
    			"	limit 1 "; 
		
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		int maxPostCount = -1; 
        while (resultSet.next()) {
             maxPostCount = resultSet.getInt("maxPostCount"); 
        }      
        disconnect();
        preparedStatement.close();
        return maxPostCount;	
	}
	
	/*
	 * [Top users]: List users that have the most number of postings.  List the top user if there is no tie,
	 *  list all the tied top users if there is a tie. 
	 */
	
	 public List<User> getTopUsers() throws SQLException{
			List<User> users = new ArrayList<User>();
			
			connect_func();
			
			int maxPostCount  = this.getMaxPostCount(); 
			if(maxPostCount == -1) {
				return users; 
			}
			
			connect_func();
			String sql = "select U.*\r\n" + 
					"	from images I , Users U\r\n" + 
					"    where I.postUser = U.email\r\n" + 
					"	group by I.postUser\r\n" + 
					"	having count(*) = ?"; 
			
		
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, maxPostCount);
			ResultSet resultSet = preparedStatement.executeQuery();
			
	        
	        while (resultSet.next()) {
	        	 String email = resultSet.getString("email");
	             String password = resultSet.getString("password");
	             String firstName = resultSet.getString("firstName"); 
	             String lastName = resultSet.getString("lastName");
	             String gender = resultSet.getString("gender");
	             String birthday = resultSet.getString("birthday"); 
	             int numOfFollowers = resultSet.getInt("numOfFollowers"); 
	             int numOFFollowings = resultSet.getInt("numOfFollowings"); 
	             
	             User user = new User(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOFFollowings); 
	             users.add(user);
	        }      
	        
			disconnect();
			return users;
		}
	 
	 
	 /*
		 * 6.	[Common users] Given two users, X, and Y, which are specified by the user with 
		 * two dropdown menu lists, list the common users that both X and Y have followed.
		 */
		
		 public List<User> getCommonUsers(String email1, String otherEmail) throws SQLException{
				List<User> users = new ArrayList<User>();
				
				connect_func();
				
				int maxPostCount  = this.getMaxPostCount(); 
				if(maxPostCount == -1) {
					return users; 
				}
				
				connect_func();
				String sql = "select *\r\n" + 
						"from users \r\n" + 
						"where email in (\r\n" + 
						"	select followingEmail\r\n" + 
						"	from follows\r\n" + 
						"	where followerEmail = ?\r\n" + 
						"\r\n" + 
						") and email in (\r\n" + 
						"	select followingEmail\r\n" + 
						"	from follows\r\n" + 
						"	where followerEmail = ?\r\n" + 
						")"; 
				
			
				preparedStatement = connect.prepareStatement(sql);
				preparedStatement.setString(1, email1);
				preparedStatement.setString(2, otherEmail);
				ResultSet resultSet = preparedStatement.executeQuery();
				
		        
		        while (resultSet.next()) {
		        	 String email = resultSet.getString("email");
		             String password = resultSet.getString("password");
		             String firstName = resultSet.getString("firstName"); 
		             String lastName = resultSet.getString("lastName");
		             String gender = resultSet.getString("gender");
		             String birthday = resultSet.getString("birthday"); 
		             int numOfFollowers = resultSet.getInt("numOfFollowers"); 
		             int numOFFollowings = resultSet.getInt("numOfFollowings"); 
		             
		             User user = new User(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOFFollowings); 
		             users.add(user);
		        }      
		        
				disconnect();
				return users;
			}
		 
		 
		 
		 
		 /*
			 * 8.	[Positive users] List those users that give each image a like. 
			 */
			
			 public List<User> getPositiveUsers() throws SQLException{
					List<User> users = new ArrayList<User>();
					
					connect_func();
					
					int maxPostCount  = this.getMaxPostCount(); 
					if(maxPostCount == -1) {
						return users; 
					}
					
					connect_func();
					String sql = "select *\r\n" + 
							"from users U\r\n" + 
							"where email in (\r\n" + 
							"	select email\r\n" + 
							"	from likes\r\n" + 
							"	where email = U.email\r\n" + 
							"	having count(*) = (\r\n" + 
							"		select count(*)\r\n" + 
							"		from images\r\n" + 
							"	)\r\n" + 
							")"; 
					
				
					preparedStatement = connect.prepareStatement(sql);
					ResultSet resultSet = preparedStatement.executeQuery();
					
			        
			        while (resultSet.next()) {
			        	 String email = resultSet.getString("email");
			             String password = resultSet.getString("password");
			             String firstName = resultSet.getString("firstName"); 
			             String lastName = resultSet.getString("lastName");
			             String gender = resultSet.getString("gender");
			             String birthday = resultSet.getString("birthday"); 
			             int numOfFollowers = resultSet.getInt("numOfFollowers"); 
			             int numOFFollowings = resultSet.getInt("numOfFollowings"); 
			             
			             User user = new User(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOFFollowings); 
			             users.add(user);
			        }      
			        
					disconnect();
					return users;
				}
			 
			 
			 
			 /*
				 * 10.	[Inactive users].   List those users who have never posted any image,
				 *  followed any other user, and given any like or comment.   
				 */
				
				 public List<User> getInactiveUsers() throws SQLException{
						List<User> users = new ArrayList<User>();
						
						connect_func();
						
						int maxPostCount  = this.getMaxPostCount(); 
						if(maxPostCount == -1) {
							return users; 
						}
						
						connect_func();
						String sql = "select *\r\n" + 
								"from users\r\n" + 
								"where email not in (\r\n" + 
								"	select postUser\r\n" + 
								"	from images\r\n" + 
								") and email not in (\r\n" + 
								"	select email\r\n" + 
								"    from Likes\r\n" + 
								"\r\n" + 
								") and email not in (\r\n" + 
								"	select email\r\n" + 
								"    from comments\r\n" + 
								") and email not in (\r\n" + 
								"	select followerEmail\r\n" + 
								"    from Follows\r\n" + 
								")"; 
						
					
						preparedStatement = connect.prepareStatement(sql);
						ResultSet resultSet = preparedStatement.executeQuery();
						
				        
				        while (resultSet.next()) {
				        	 String email = resultSet.getString("email");
				             String password = resultSet.getString("password");
				             String firstName = resultSet.getString("firstName"); 
				             String lastName = resultSet.getString("lastName");
				             String gender = resultSet.getString("gender");
				             String birthday = resultSet.getString("birthday"); 
				             int numOfFollowers = resultSet.getInt("numOfFollowers"); 
				             int numOFFollowings = resultSet.getInt("numOfFollowings"); 
				             
				             User user = new User(email, password, firstName, lastName, gender, birthday, numOfFollowers, numOFFollowings); 
				             users.add(user);
				        }      
				        
						disconnect();
						return users;
					}
	
	
	
	
	
	
}




