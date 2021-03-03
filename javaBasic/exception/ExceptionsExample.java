package javaBasic.exception;

class ExceptionsExample {

  public static void main(String[] args) {
    try {
      var yearOld = 17;
      if(yearOld < 18) {
          throw new IllegalYearOlds("Error: YearOld:'" + yearOld + "' < 18");
      }
    }
    catch(IllegalYearOlds e) {
      e.printStackTrace();
    }
    catch(Throwable e) {
      e.printStackTrace();
    }
  }
}

class IllegalYearOlds extends Exception {
  public IllegalYearOlds(String msg) {
    super(msg);
  }
  public IllegalYearOlds(String message, Throwable cause) {
    super(message, cause);
  }
}

