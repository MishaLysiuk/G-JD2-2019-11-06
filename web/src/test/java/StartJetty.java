import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.MalformedURLException;

public final class StartJetty {

    private StartJetty() {
    }

    /**
     * Main function, starts the jetty server.
     *
     * @param args
     * @throws MalformedURLException
     */

    public static void main(final String[] args) throws MalformedURLException {
        startInstance(8080);
    }

    private static void startInstance(final int port) throws MalformedURLException {
        final Server server = new Server();

        final HttpConfiguration httpConfig = new HttpConfiguration();
        httpConfig.setOutputBufferSize(32768);

        final ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(httpConfig));
        http.setPort(port);
        http.setIdleTimeout(1000 * 60 * 60);

        server.addConnector(http);

        final Configuration.ClassList classlist = Configuration.ClassList.setServerDefault(server);
        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration",
                "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");

        final WebAppContext bb = new WebAppContext();
        bb.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
        bb.setServer(server);
        bb.setContextPath("/linkedin");
        bb.setWar("src/main/webapp");

        server.setHandler(bb);

        try {
            server.start();
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }
}