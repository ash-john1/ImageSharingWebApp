import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener  implements HttpSessionAttributeListener {
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("\n\nattribute added: " + arg0.getName()); 
		System.out.println("object on which the Event initially occurred: " + arg0.getSource().toString());
		System.out.println("class: " + arg0.getClass().toString()); 
		
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("\n\nattribute removed: " + arg0.getName()); 
		System.out.println("object on which the Event initially occurred: " + arg0.getSource().toString()); 
		System.out.println("class: " + arg0.getClass().toString()); 
		
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("\n\nattribute replaced: " + arg0.getName()); 
		System.out.println("object on which the Event initially occurred: " + arg0.getSource().toString());
		System.out.println("class: " + arg0.getClass().toString()); 
		System.out.print("hello world");
		
	}

}
