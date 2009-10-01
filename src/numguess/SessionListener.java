package numguess;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Listener for thread-safe initialization of user-specific data 
 * (session scope).
 */
public class SessionListener implements Constants, HttpSessionListener {

  public void sessionCreated(HttpSessionEvent event) {
    System.out.println("session initializing");
    HttpSession session = event.getSession();
    ServletContext context = session.getServletContext();
    SharedData sharedData = (SharedData) context.getAttribute(ATTRIBUTE_GLOBALDATA);
		UserData model = new UserData();
		model.setSharedData(sharedData);
		session.setAttribute(ATTRIBUTE_USERDATA, model);
		System.out.println("session initialized");
  }

  public void sessionDestroyed(HttpSessionEvent event) {
    System.out.println("session destroyed");
  }
}
