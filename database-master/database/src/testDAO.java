



/*
The purpose of Exercise 1 is to show how to use a SELECT statement in Java to display the content of a table located at a remote database server. 
   1) Understand how to connnect to a Database server and close the connection;
   2) Understand how to run a SELECT statement in Java;
   3) Understand how the method writeResultSet works to display the result from a SELECT statement. 
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class testDAO {
 private static Connection connect = null;
 private static Statement statement = null;
 private static PreparedStatement preparedStatement = null;
 private static ResultSet resultSet = null;
 private static User user;
 private static UserDAO userDAO; 
 private static FollowDAO followDAO; 
 private static ImageDAO imageDAO;
 private static CommentsDAO commentsDAO; 
 private static LikesDAO likesDAO; 
 private static TagsDAO tagsDAO; 

 	public static void main(String[] args) {
 		try {
 	
 	 	    userDAO = new UserDAO();
 			followDAO = new FollowDAO();
 			imageDAO = new ImageDAO(); 
 			commentsDAO = new CommentsDAO(); 
 			likesDAO = new LikesDAO(); 
 			tagsDAO = new TagsDAO(); 
 	 	    
 	 		System.out.println("hello world");
 	 		
 	 		
 	 		
 	 		// get all images posted by a user
 	 		User user = userDAO.getUserByEmail("jhalpert@email.com"); 
 			List<Image> imageList = imageDAO.getImagesPostedByUser(user);
 			System.out.println("in intialize db"); 
 			for(Image img: imageList) {
 				System.out.println(img.toString()); 
 			}
 			
 			
 			
 			// get like count for imgID
 			int likeCount = likesDAO.getLikesForImage(50); 
			System.out.println("num likes: " + likeCount); 
			
			
			// get tags for imgID
			String tags = tagsDAO.getTagsForImage(5);
			System.out.println(tags); 
			
			
			
			// insert into like table
			boolean imageLiked = likesDAO.insert("jhalpert@email.com", 8);
			System.out.println("was imaged liked? " + imageLiked);
			

 			// post image
			user = userDAO.getUserByEmail("jhalpert@email.com"); 
			Image image = new Image("http://testurl.com", "so cool", user); 
			boolean imagePosted = imageDAO.insert(user.email, image);
			System.out.println("was image posted? " + imagePosted);
			
			
			// tag image
			boolean imageTagged = tagsDAO.insert("awesome", 2);
	        System.out.println("was image tagged: " + imageTagged);
	        
	        // get image id of latest post
	        int imageID = imageDAO.getLastestPostImageID("amartin@email.com"); 
	    	System.out.println("image id of latest post: " + imageID);
			
	    	
	    	// update image for imageID
	    	User user2 = userDAO.getUserByEmail("jhalpert@email.com"); 
	    	Image image2 = new Image(37, "edited url", "edited descr", user2);
	    	boolean isUpdated = imageDAO.update(image2); 
	    	System.out.println("is image updated? " + isUpdated); 
 			
	    	
	    	// delete image by imageID
	    	boolean isDeleted = imageDAO.delete(40); 
	    	System.out.println("is image deleted? " + isDeleted); 
	    	
	    	// delete tag by imageID
	    	boolean isDeleted2 = tagsDAO.delete(35); 
	    	System.out.println("are tags deleted? " + isDeleted2); 
	    	
	    	
	    	// delete comments by imageID
	    	boolean isDeleted3 = commentsDAO.delete(36); 
	    	System.out.println("are comments deleted? " + isDeleted3); 
	    	
	    	// delete likes by iamgeID
	    	boolean isDeleted4 = likesDAO.delete(36); 
	    	System.out.println("are likes deleted? " + isDeleted4);  
 			
 			
 		}
 		catch (Exception e) {
 	         System.out.println(e);
 	    }
 		

	} 
}

/*

compile
	javac -cp .;mysql-connector-java-5.1.32-bin.jar testDAO.java 

run
 	java -cp .;mysql-connector-java-5.1.32-bin.jar testDAO    

*/