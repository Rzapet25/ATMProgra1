
package atmprogra1;


public class DatosCuentas {
    private Cuenta cuentas[];

    public DatosCuentas() {
        this.cuentas = cuentas;
        
       cuentas = new Cuenta[4];
       cuentas[0]=new Cuenta(0001,12345, 1000, 1200);
       cuentas[1]=new Cuenta(0002,67890,500,1200);
       cuentas[2]=new Cuenta(0003,02345,700,1000);
       cuentas[3]=new Cuenta(0004,56789,1000,2000);
    }
   private Cuenta obtenerCuenta(int numeroCuenta){
      
       for (Cuenta CuentaActual:cuentas){
       
       if (CuentaActual.obtenerNumeroCuenta()==numeroCuenta)
       
       return CuentaActual;
       }
   return null;
   
   }
   
   public boolean autenticarUsuario(int numeroCuentaUsuario,int nipUsuario){
   
   Cuenta cuentaUsuario = obtenerCuenta(numeroCuentaUsuario);
    
   if (cuentaUsuario != null)
    return cuentaUsuario.ValidarNip(nipUsuario);
   else
    return false;
   
   }
  
   public double obtenerSaldoDisponible(int numeroCuentaUsuario)
   
   {
    return obtenerCuenta(numeroCuentaUsuario).obtenerSaldoD();
    
    
   
   }
   
    public double obtenerSaldoTotal(int numeroCuentaUsuario)
   
   {
    return obtenerCuenta(numeroCuentaUsuario).obtenerSaldoTotal();
    
    
   
   }
   
   public void abonar (int numeroCuentaUsuario, double monto){
   
     obtenerCuenta(numeroCuentaUsuario).abonar(monto);
   
   }
   
   public void cargar(int numeroCuentaUsuario, double monto){
   
      obtenerCuenta(numeroCuentaUsuario).cargar(monto);
   }
}
