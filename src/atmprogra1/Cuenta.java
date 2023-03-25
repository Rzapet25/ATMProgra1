
package atmprogra1;


public class Cuenta {
    
 
   private int numeroCuenta;
   private int nip;
   private double saldoDisponible;
   private double saldoTotal;

    public Cuenta(int numeroCuenta, int nip, double saldoDisponible, double saldoTotal) {
        this.numeroCuenta = numeroCuenta;
        this.nip = nip;
        this.saldoDisponible = saldoDisponible;
        this.saldoTotal = saldoTotal;
    }

 

   
   
   public boolean ValidarNip(int nipCliente){
   
      if (nipCliente==nip)
          return true;
      else
          return false;
   
   }

   


    
    
    
  public   double obtenerSaldoD(){
   return saldoDisponible;
  }
  public   double obtenerSaldoTotal(){
   return  saldoTotal;
  }
  public  void abonar(double monto)
  {
  
  saldoTotal+=monto;
  }
  
  public void cargar (double monto){
      
      saldoDisponible-=monto;
      saldoTotal-=monto;
  
  
  }
  
  public int obtenerNumeroCuenta(){
  
  return numeroCuenta;
  
  }
  
  
  
  
  
  
  
  //public   void debitar(int monto){}
}
