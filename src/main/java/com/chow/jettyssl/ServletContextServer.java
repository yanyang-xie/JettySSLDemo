package com.chow.jettyssl;


import org.eclipse.jetty.http.ssl.SslContextFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ssl.SslSocketConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Administrator on 2017/2/19.
 */
public class ServletContextServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        // 设置ssl连接器
        SslSocketConnector ssl_connector = new SslSocketConnector();
        ssl_connector.setPort(9000);
        SslContextFactory cf = ssl_connector.getSslContextFactory();
        cf.setKeyStorePath("D:\\MyProgram\\java\\JettySSLDemo\\tomcat.keystore");
        cf.setKeyStorePassword("123456");
        cf.setKeyManagerPassword("123456");
        server.addConnector(ssl_connector);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloServlet()), "/HelloServlet");
        context.addServlet(new ServletHolder(new FileDownloadServlet()), "/FileDownloadServlet");
        server.start();
        server.join();
    }
}
