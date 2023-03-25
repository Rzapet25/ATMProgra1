
package atmprogra1;


public class Dispensador {
    
 private final static int  MONTO_INICIAL=500;
    
  private int efectivoDisponible;

    public Dispensador() {
        
        efectivoDisponible = MONTO_INICIAL;
    }
    
     public  void dispensarEfectivo (int monto){
      int billetesRequeridos = monto / 20;
      efectivoDisponible -=billetesRequeridos;
     }
    
   public boolean verificarEfectivo(int monto){
    int billetesRequeridos = monto / 20;
   
   if (efectivoDisponible>=billetesRequeridos)
   
       return true;
   else
       return false;
   
   
   
   
   }
    
}
