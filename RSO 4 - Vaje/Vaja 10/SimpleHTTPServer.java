import com.sun.net.httpserver.HttpServer;   import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpContext;  import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.Headers;      import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpPrincipal; // basic or digest auth
import java.net.InetSocketAddress;
import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import java.net.URI;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.File;

import java.security.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLContext;
import java.security.cert.Certificate;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

public class SimpleHTTPServer {

  

    public static void main(String[] args) throws IOException {

       
        HttpServer server = HttpServer.create(new InetSocketAddress(85), 0);
        
        //prvi navidenzni endpoint : oziroma koren vseh naviseznih end-pointov, ki se začne z lolipop
        HttpContext context = server.createContext("/example");
        context.setHandler(SimpleHTTPServer::handleRequest);

        //drugi navidezni endpoint
        HttpContext context2 = server.createContext("/lolipop");
        context2.setHandler(SimpleHTTPServer::handleRequest);
        
        
        //tretji navidezni endpoint
        HttpContext context3 = server.createContext("/get");
        context3.setHandler(SimpleHTTPServer::handleGet);
        
        
        // root endpoint - z drugim/drugačnim handlerjem - vsi razen prej definiranih pristanejo tule
        server.createContext("/", new RootHandler());
        

        server.start();


    }

    // tule se konča procesiranje vseh endpointov razen korenskega
    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        printRequestInfo(exchange);                                         // na konzolo
        String response = "This is the response at " + requestURI;
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());                                       //
        os.close();
    }
    
    // tale metoda hendla /get -e !!
    private static void handleGet(HttpExchange exchange) throws IOException {
        
        String endPoint = "/get";   //hendla zgolj male črke ...
        
        URI requestURI = exchange.getRequestURI();
        printRequestInfo(exchange);                                         // na konzolo
        String response = "This is the response at " + requestURI;  
        
        // odbijmo od request uri vse do vključno get/ ostalo je naš parameter z query ....
        // path /get, /get/123, , /get/123/, /get/123/slika , /get/123/slika/, ....
        // ponavadi naredimo split v array po '/', tule spodaj je malo drugače (heh!)
        
        // izločimo /get in /get/
        String ss = requestURI.getRawPath();
        if (ss.equals(endPoint) || ss.equals(endPoint+'/')){
            // procesiraj brez parametrov   ...  naslovljen je /get ali /get/
        } else {
            // pričakujemo parametre : /get/123 ali /get/123/, ...
            ss = ss.substring(ss.indexOf(endPoint)+endPoint.length()+1);  // odbijemo /get/ z začetka niza
            int kts = ss.indexOf("/");                                    // samo do morebitnega / za vrednostjo parametra
            if (kts > 0) {
               ss=ss.substring(0,kts);                 // s temle zanemarimo vse, kar sledi številki
            }
            System.out.println(ss);
               // ni realizirano:
               // še kaj URI-ja za procesiranje ? /get/123/slika , /get/123/slika/, .... 
            int vrParam = Integer.valueOf(ss);
            System.out.println(vrParam);
            } 
        
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());                                       //
        os.close();
    }
    
    

    private static void printRequestInfo(HttpExchange exchange) {
        System.out.println("-- headers --");
        Headers requestHeaders = exchange.getRequestHeaders();
        requestHeaders.entrySet().forEach(System.out::println);

        System.out.println("-- principle --");
        HttpPrincipal principal = exchange.getPrincipal();
        System.out.println(principal);

        System.out.println("-- HTTP method --");
        String requestMethod = exchange.getRequestMethod();
        System.out.println(requestMethod);

        System.out.println("-- query --");
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        System.out.println(query);
    }
}


class RootHandler implements com.sun.net.httpserver.HttpHandler {

         @Override
         public void handle(HttpExchange he) throws IOException {
                 int port=85;
                 String response = "<h1>Server start success .if you see this message</h1>" + "<h1>Port: " + port + "</h1>";
                 
                 he.sendResponseHeaders(200, response.length());
                 OutputStream os = he.getResponseBody();
                 os.write(response.getBytes());
                 os.close();
         }
}
