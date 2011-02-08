package org.wicketstuff.dojo.examples;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;


/**
 * Seperate startup class for people that want to run the examples directly.
 * 
 * Once started the phonebook is accessible under
 * http://localhost:8080/phonebook
 */
public class DojoExamplesLauncher {

    /**
     * Main function, starts the jetty server.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        SelectChannelConnector connector = new SelectChannelConnector();
        String port = System.getProperty("web.port", "8080");
        connector.setPort(Integer.parseInt(port));
        server.setConnectors(new Connector[] { connector });

        WebAppContext web = new WebAppContext();
        String contextPath = System.getProperty("web.context.path", "");
        web.setContextPath(contextPath);
        web.setWar("src/main/webapp");
        web.setDistributable(true);
        web.setClassLoader(DojoExamplesLauncher.class.getClassLoader());
        server.setHandler(web);
        
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }

    }
}
