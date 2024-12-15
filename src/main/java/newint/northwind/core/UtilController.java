package newint.northwind.core;

import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtilController {
  public void exit() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        Quarkus.asyncExit();;
      }
  }).start();
  }
}
