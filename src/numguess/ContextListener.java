package numguess;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener for thread-safe initialization of global data 
 * (application scope).
 */
public class ContextListener implements Constants, ServletContextListener {

  public void contextInitialized(ServletContextEvent event) {
		System.out.println("context initializing");
		ServletContext application = event.getServletContext();
		application.setAttribute(ATTRIBUTE_GLOBALDATA, new GlobalData());
		System.out.println("context initialized");
  }

  public void contextDestroyed(ServletContextEvent event) {
    System.out.println("context destroyed");
  }
}
