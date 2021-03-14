package dio.javaThread;

import java.util.ArrayList;
import java.util.Random;

class ThreadExampleOne {
  static Random rand = new Random();
  public static void main(String[] args) {
    // System.out.println("\033[42m-------START--------\033[0m");
    // threadExample1();
    // threadExample2();
    // System.out.println("\033[42m--------END---------\033[0m");
    
    threadExample3();
  }

  static void threadExample1() {
    
    System.out.println("\033[41mExemplo 1 - Threads \033[0m");
    var list = new ArrayList<LoadingBar>();

    for(int i = 0; i < 4; i++) {
      list.add(new LoadingBar(rand.nextInt(2)));
    }

    for(var thread : list) {
      thread.start();
      System.out.println("Start " + thread.getName());
    }
  }

  static void threadExample2() {
    System.out.println("\033[41mExemplo 2 - Threads \033[0m");
    var pdfs = new ArrayList<Thread>();
    
    for(int i = 0; i < 3; i++) {
      pdfs.add(new Thread(new GerarPDF(rand.nextInt(5))));
    }

    for(var pdf : pdfs) {
      pdf.start();
    }
  }

  static void threadExample3() {

    // var pdfs = new ArrayList<GeradorDePDF>();
    // var loads = new ArrayList<Loading>();

    // for(int i = 0; i < 5; i++) {
    //  pdfs.add(new GeradorDePDF(rand.nextInt(10)));
    // }

    // for(var pdf : pdfs) {
    //   pdf.start();
    //   loads.add(new Loading(pdf));
    // }

    // for(var load : loads) {
    //   load.start();
    // }

    var pdfs = new ArrayList<GeradorDePDF>();
    var load = new LoadingPercent();


    for(int i = 0; i < 15; i++) {
      pdfs.add(new GeradorDePDF(rand.nextInt(5)));
    }
    for(var pdf : pdfs) {
      pdf.start();
      load.add(pdf);
    }

    load.start();
  }
}

class GerarPDF implements Runnable {
  private Integer tempo;
  public GerarPDF() {}
  public GerarPDF(Integer tempo) {
    this.tempo = tempo;
  }

  @Override
  public void run() {
    
    System.out.println("Gerando PDF");
    
    try {
      Thread.sleep(1000 * tempo);
    }
    catch(Exception e ) {
      e.printStackTrace();
    }

    System.out.println("PDF Gerado | Tempo : " + tempo + "s");
  }
}

class LoadingBar extends Thread {
  
  private Integer time = 0;

  public LoadingBar() {}
  public LoadingBar(Integer time) {
    this.time = time;
  }
  
  @Override
  public void run() {
    super.run();
    try {
      Thread.sleep(1000 * time);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("Loading ... | Time: " + time + "s | " + this.getName());
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

class LoadingPercent extends Thread {
  
  private ArrayList<Thread> process = new ArrayList<>();
  private String[] icon = {"-", "\\", "|", "/"};

  public LoadingPercent() {}
  public LoadingPercent(Thread ...process) {
    for(var proc : process) {
      this.process.add(proc);
    }
  }

  public void add(Thread process) {
    this.process.add(process);
  }

  @Override
  public void run() {
    int count = 0;
    int processFinish = 0;
    double percent = 0;


    while(true) {
      
      
      System.out.print("\033[?25l");
      
      try {
        Thread.sleep(80);
        for(var proc : process) {
          if(!proc.isAlive()) {
            processFinish++;
          }
        }
        // (2 * 100)/5
        System.out.printf("\r%s %.2f%%", 
          icon[count % icon.length], 
          (processFinish * 100.0) / process.size()
        );

        if(processFinish == process.size()) {
          System.out.print("\033[?25h");
          break;
        }
        processFinish = 0;

      }
      catch(Exception e) {
        e.printStackTrace();
      }

      count++;
    }
  }
}

class Loading extends Thread {
  
  private Thread process;
  private String[] icon = {"-", "\\", "|", "/"};
  
  public Loading() {}
  public Loading(Thread process) {
    this.process = process;
  }

  @Override
  public void run() {
    
    int count = 0;

    while(true) {
      
      System.out.printf("\r%s", icon[count % icon.length]);
      System.out.print("\033[?25l");
      
      try {
        Thread.sleep(80);
        if(!process.isAlive()) {
          System.out.print("\033[?25h");
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
