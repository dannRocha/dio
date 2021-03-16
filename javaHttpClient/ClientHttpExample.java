/**
 * jdk >= 11
 */
// package dio.javaHttpClient;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;


public class ClientHttpExample {
  static ExecutorService threadPool = Executors.newFixedThreadPool(4, new ThreadFactory() {
    /**
     * Sobrescrever quando uma nova thread é criada pelo Execurtors;
     */
    @Override
    public Thread newThread(Runnable runnable) {
      var thread = new Thread(runnable);
      System.out.println("Daemon : " + thread.isDaemon());
      return thread;
    }
  });
  public static void main(String[] args) throws IOException, InterruptedException {
    example2();
  }

  static void example1() throws IOException, InterruptedException {

    var address = "http://pudim.com.br/";
    var request = HttpRequest
      .newBuilder()
      .GET().uri(URI.create(address))
      .build();

    var response = HttpClient
      .newHttpClient()
      .send(request, HttpResponse.BodyHandlers.ofString());
    
    System.out.println("HEADERS: " + response.headers() + " \n");
    System.out.println("STATUS : " + response.statusCode() + " \n"); 
    System.out.println("BODY   : " + response.body() + " \n");
  
  }

  static void example2() throws IOException, InterruptedException {
    var address = "https://http2.akamai.com/demo/h2_demo_frame.html";
    var httpClient = HttpClient
      .newBuilder()
      .version(Version.HTTP_1_1)
      .proxy(ProxySelector.getDefault())
      .build();

    var request = HttpRequest
      .newBuilder()
      .uri(URI.create(address))
      .build();

    var response = httpClient
      .send(request, HttpResponse.BodyHandlers.ofString());
    
    // System.out.println(response.body());

    var body = response.body();
    
    var imageList = new ArrayList<Future<?>>();

    body
      .lines()
      .filter(line -> line.trim().startsWith("<img height"))
      .map(line -> {
        var start = "src='";
        var end = "'/>";
        return line.substring(line.indexOf(start) + start.length(), line.indexOf(end));
      })
      .forEach(image -> {
        Future<String> imgFuture = threadPool.submit(() -> {
          var req = HttpRequest
            .newBuilder()
            .uri(URI.create("https://http2.akamai.com" + image))
            .build();

          try {
            var content = httpClient
              .send(req, HttpResponse.BodyHandlers.ofString());
            

            System.out.println("Imagen Carregada: " + content.statusCode());
            return content.body();
          }
          catch(Exception e) {
            e.printStackTrace();

            return "";
          }


        });
        imageList.add(imgFuture);
      });

      while(!imageList.stream().allMatch(Future::isDone));
      imageList.forEach(image -> {
        try {
          System.out.println(image.get());
        }
        catch(Exception e) {
          e.printStackTrace();
        }
      });

      threadPool.shutdown();
  }
}

