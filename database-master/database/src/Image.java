import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Image {
	protected int imgID;
	protected String url; 
	protected String description; 
	protected User postUser;
	protected String postDate; 
	protected String postTime; 
	protected int likesCount; 
	protected String tags;
	protected boolean isLiked; 
	
	
	public Image(int imgID, String url, String description, User postUser, String postDate, String postTime,
			int likesCount, String tags) {
		super();
		this.imgID = imgID;
		this.url = url;
		this.description = description;
		this.postUser = postUser;
		this.postDate = postDate;
		this.postTime = postTime;
		this.likesCount = likesCount;
		this.tags = tags;
		this.isLiked = false; 
	}


	public Image(int imgID, String url, String description, User postUser, String postDate, String postTime) {
		super();
		this.imgID = imgID;
		this.url = url;
		this.description = description;
		this.postUser = postUser;
		this.postDate = postDate;
		this.postTime = postTime;
		this.isLiked = false; 
		
	}


	


	public Image(String url, String description, User postUser) {
		super();
		this.url = url;
		this.description = description;
		this.postUser = postUser;
		this.isLiked = false; 
	}


	public Image(int imgID, String url, String description, User postUser, String postTime) {
		super();
		this.imgID = imgID;
		this.url = url;
		this.description = description;
		this.postUser = postUser;
		this.postTime = postTime;
		this.isLiked = false; 
	}
	
	
	public Image(int imgID, String url, String description, User postUser) {
		super();
		this.imgID = imgID;
		this.url = url;
		this.description = description;
		this.postUser = postUser;
		this.isLiked = false; 
	}


	


	public Image(int imgID, String url, String description) {
		super();
		this.imgID = imgID;
		this.url = url;
		this.description = description;
		this.isLiked = false; 
	}


	public Image(int id, String url2, String desc, String em, String t) {
		super();
		this.imgID = id;
		this.url = url2;
		this.description = desc;
		this.postUser = new User(em);
		this.postTime = t;
		this.isLiked = false; 
	}


	public int getImgID() {
		return imgID;
	}


	public void setImgID(int imgID) {
		this.imgID = imgID;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getPostUser() {
		return postUser;
	}


	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}


	public String getPostDate() {
		return postDate;
	}


	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}


	public String getPostTime() {
		return postTime;
	}


	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}


	public int getLikesCount() {
		return likesCount;
	}


	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public boolean getIsLiked() {
		return isLiked;
	}


	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}


	@Override
	public String toString() {
		return "Image [imgID=" + imgID + ", url=" + url + ", description=" + description + ", postUser=" + postUser.email
				+ ", postDate=" + postDate + ", postTime=" + postTime + "]";
	} 
	
	
	
	
	
	
	
	
	

}
