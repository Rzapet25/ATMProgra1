
package atmprogra1;

import java.util.Scanner;


public class TecladoNumerico {
    
    private Scanner entrada;
    public TecladoNumerico() {
    entrada = new Scanner(System.in);
    
    }

  public  int capturarDatos(){ 
      
      
   return entrada.nextInt();
   
  
  }
    
}
