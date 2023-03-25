
package atmprogra1;


public class ATM {
    
    //Relacion de Composicion
    /*
    RanuraParaDepositos ranuraparadepositoobj = new RanuraParaDepositos();
    TecladoNumerico tecladonumericoObj = new TecladoNumerico();
    Pantalla pantallaObj = new Pantalla();
    Dispensador dispensadorObj = new Dispensador ();
    */
    
   private boolean usuarioAutenticado;
   private int numCuentaActual;
   private RanuraParaDepositos ranuraparadepositoobj;
   private TecladoNumerico tecladonumericoObj; 
   private Pantalla pantallaObj;
   private Dispensador dispensadorObj; 
   private DatosCuentas datosCuentas;
   
   private static final int  SOLICITUD_SALDO =1;
   private static final int  RETIRO = 2;
   private static final int DEPOSITO =3;
   private static final int SALIR =4;
    
    
  public  ATM (){
      
      usuarioAutenticado=false;
      numCuentaActual = 0;
      
      this.pantallaObj = new Pantalla ();
      this.ranuraparadepositoobj = new RanuraParaDepositos();
      this.tecladonumericoObj = new TecladoNumerico();
      this.datosCuentas = new DatosCuentas();
      this.dispensadorObj = new Dispensador ();
     
      //this.solicitarDatos();
     
    // pantallaObj.mostrarMensaje("Bienvenido\n");
     //pantallaObj.mostrarMensaje("Ingrese su No. de cuenta:");
     //int numeroCuenta = tecladonumericoObj.capturarDatos();
    
     //System.out.println();
    
    }
    public void inicio ()
    { 
    
    while (true)
    {
     while (!usuarioAutenticado)
     {
     
     pantallaObj.mostrarMensaje("\nBienvenido");
      autenticarUsuario();
    }
    hacerTransacciones();
    usuarioAutenticado= false;
    numCuentaActual = 0;
    pantallaObj.mostrarMensaje("\nGracias! Vuelva Pronto!");
    
   }
   }
    
    private void autenticarUsuario(){
      
      pantallaObj.mostrarMensaje("Ingrese su No. de cuenta:");
      int numeroCuenta = tecladonumericoObj.capturarDatos();
      pantallaObj.mostrarMensaje("Ingrese su NIP:");
      int nip = tecladonumericoObj.capturarDatos();
      
      usuarioAutenticado=
             datosCuentas.autenticarUsuario(numeroCuenta, nip);
             
       if (usuarioAutenticado){
           
           numCuentaActual = numeroCuenta;
       
       }
       else
           pantallaObj.mostrarMensaje("Numero de Cuenta O NIP incorrecto intente nuevamente");
       
    }
    
    private void hacerTransacciones(){
    
     Transaccion transaccionActual = null;
     boolean usuarioSalio= false;
     
     while (!usuarioSalio){
     
     int menuPrincipal = mostrarMenuPrincipal();
     
     switch(menuPrincipal){
         
         case SOLICITUD_SALDO, RETIRO, DEPOSITO -> {
             transaccionActual=
                     crearTransaccion(menuPrincipal);
             
             transaccionActual.ejecutar();
             }
         case SALIR -> {
             pantallaObj.mostrarMensaje("\nCerrando el Sistema...");
             usuarioSalio= true;
             }
         default -> pantallaObj.mostrarMensaje("\n Ingrese Una Opcion Valida");
      
      
      }
     
     }
    
    
    
    }
    
    private int mostrarMenuPrincipal(){
     pantallaObj.mostrarMensaje("\nMenu Principal");
     pantallaObj.mostrarMensaje("1 - Consultar Saldo");
     pantallaObj.mostrarMensaje("2 - Retirar Efectivo");
     pantallaObj.mostrarMensaje("3 - Depositar Fondos");
     pantallaObj.mostrarMensaje("4 - Salir");
     pantallaObj.mostrarMensaje("Ingrese Una Opcion");
     return tecladonumericoObj.capturarDatos();
   
    }
    
    private Transaccion crearTransaccion(int tipo){
    
    Transaccion temp = null;
      switch (tipo){
          case SOLICITUD_SALDO -> temp = new SolicitudSaldo(numCuentaActual,pantallaObj,datosCuentas);
          case RETIRO -> temp = new Retiro(numCuentaActual,pantallaObj,datosCuentas,tecladonumericoObj,dispensadorObj);
          case DEPOSITO -> temp = new Deposito(numCuentaActual,pantallaObj,datosCuentas,tecladonumericoObj,ranuraparadepositoobj);
      }
    
    return temp;
    }
    
    
  
       
     
      
}
