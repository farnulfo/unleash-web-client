package net.arnulfo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import no.finn.unleash.Unleash;
import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.util.UnleashConfig;

/**
 * Web application lifecycle listener.
 *
 * @author Franck
 */
@WebListener
public class InitServletListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent event) {
    UnleashConfig config = UnleashConfig.builder()
            .appName("java-test")
            .instanceId("instance x")
            .unleashAPI("https://unleash-cat.herokuapp.com/api/")
            .build();

    Unleash unleash = new DefaultUnleash(config);
    event.getServletContext().setAttribute("unleash", unleash);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    Unleash unleash = (Unleash) event.getServletContext().getAttribute("unleash");
    if (unleash != null) {
      unleash.shutdown();
    }
  }
}
