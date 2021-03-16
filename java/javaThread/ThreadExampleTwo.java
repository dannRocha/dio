package dio.javaThread;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.time.LocalTime;


public class ThreadExampleTwo {
  // Numero de Threads
  static final Random rand = new Random();
  static final ExecutorService threadPool = Executors.newFixedThreadPool(5);
  public static void main(String[] args) {
    example2();
    example1();
  }

  static void example1() {
    System.out.println("\033[41mPDF: SEM limite de THREADs\033[0m");
    var pdfs = new ArrayList<GeradorDePDF>();
    var load = new LoadingPercent();


    for(int i = 0; i < 5; i++) {
      pdfs.add(new GeradorDePDF(rand.nextInt(5)));
    }
    for(var pdf : pdfs) {
      pdf.start();
      load.add(pdf);
    }
    load.start();
  }

  static void example2() {
    
    System.out.println("\033[41mDOC: COM limite de THREADs\033[0m");
    
    var docxs = new ArrayList<GerarDOCX>();
    var tempo = 5;

    for(int i = 0; i < 15; i++) {
      docxs.add(new GerarDOCX(rand.nextInt(tempo)));
    }
    // Sem retorno
    // docxs.forEach( 
    //   docx -> threadPool.execute(docx::formatar)
    // );
    
    
    // Com retorno;
    var future = docxs
      .stream()
      .map(docx -> threadPool.submit(docx::formatar))
      .collect(Collectors.toList());

    // Arraylist Thread safe
    // new CopyOnWriteArrayList(future);
    
    System.out.println("Esperando os DOCX terminar ...  Tempo MAX: " + tempo + "s");
    while(!future.stream().allMatch(Future::isDone));
    
    future.forEach(docs -> {
      try {
        System.out.println(docs.get());
      }
      catch(Exception e) {
        e.printStackTrace();
      }
    });
    

    // Desligar a threadPool
    threadPool.shutdown();
  }
}


class LoadingPercent extends Thread {
  
  // private ArrayList<Thread> process = new ArrayList<>();
  private CopyOnWriteArrayList<Thread> process = new CopyOnWriteArrayList<>();

  private String[] icon = {"-", "\\", "|", "/"};

  public LoadingPercent() {}
  public LoadingPercent(Thread ...process) {
    for(var proc : process) {
      this.add(proc);
    }
  }

  public void add(Thread process) {
    this.process.add(process);
  }

  @Override
  public void run() {

    int count = 0;
    Double total = Double.valueOf(process.size());

    while(true) {
      
      System.out.print("\033[?25l");
      
      try {
        
        Thread.sleep(90);
        
        // var proc = process
        //   .stream()
        //   .filter(Thread::isAlive)
        //   .collect(Collectors.toList());

        // process.clear();
        // process.addAll(proc);

        process.forEach(proc -> {
          if(!proc.isAlive()) {
            process.remove(proc);
          }
        });

        // ( Variable * 100.0 ) / Final         
        //    -> retorna o percento de 0 a n de 0% a 100%
        // ((Final - Variable) / Final) * 100.0 
        //    -> retorna o percento de n a 0 de 0% a 100%

        System.out.printf("\r%s %.2f%%", 
          icon[count % icon.length], 
          ((total - process.size()) / total) * 100.0
        );

        
        if(process.isEmpty()) {
          System.out.print("\033[?25h");
          System.out.print("\r");
          break;
        }
      }
      catch(Exception e) {
        e.printStackTrace();
      }

      count++;
    }
  }
}

class GeradorDePDF extends Thread {
  
  private Integer tempo;
  
  public GeradorDePDF() {}
  public GeradorDePDF(Integer tempo) {
    this.tempo = tempo;
  }

  @Override
  public void run() {

    System.out.print("\033[?25l");
    try {
      Thread.sleep(1000 * tempo);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    System.out.println("\r ✔ PDF Gerado | tempo: " + tempo + "s");
    
  }
}

@FunctionalInterface
interface DOCX {
  String formatar();
}

class GerarDOCX implements DOCX {
  
  private Integer tempo;
  
  public GerarDOCX() {}
  public GerarDOCX(Integer tempo) {
    this.tempo = tempo;
  }

  public String formatar() {
    System.out.print("\033[?25l");
    try {
      Thread.sleep(1000 * tempo);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    // System.out.println("\r ✔ DOCX Gerado | tempo: " + tempo + "s");
    
    return "DOCX - " + tempo + "s";
  }

}