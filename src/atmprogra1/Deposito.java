
package atmprogra1;

//herencia
public class Deposito extends Transaccion{
    
    private double monto;
   private RanuraParaDepositos ranuraparadepositoobj;
   private TecladoNumerico tecladonumericoObj; 
   
   private final static int CANCELAR =0;

    /**
     *
     * @param numeroCuentaUsuario
     * @param pantallaObj
     * @param datosCuentas
     * @param tecladonumericoObj
     * @param ranuraparadepositoobj
     */
    public Deposito(int numeroCuentaUsuario, Pantalla pantallaObj, DatosCuentas datosCuentas, TecladoNumerico tecladonumericoObj, RanuraParaDepositos ranuraparadepositoobj) {
          super(numeroCuentaUsuario, pantallaObj, datosCuentas);
        this.monto = monto;
        this.ranuraparadepositoobj = ranuraparadepositoobj;
        this.tecladonumericoObj = tecladonumericoObj;
    }

   

   // Deposito(int numeroCuenta, Pantalla pantallaObj, DatosCuentas datosCuentas, TecladoNumerico tecladonumericoObj, RanuraParaDepositos ranuraparadepositoobj) {
      //   super(numeroCuenta, pantallaObj, datosCuentas);
        //this.ranuraparadepositoobj = ranuraparadepositoobj;
        //this.tecladonumericoObj = tecladonumericoObj;
   // }
   
  /* private  int Monto;*/
    //Sobrescritura de metodos
    //para pder sobrescribir metodos la firma debe ser la misma 
    //Firma de los metodos  =Conjunto (nombre del metodo y los parametros que recibe)
 //  public  void ejecutar(int monto){
        //super.ejecutar(monto);
      // System.out.println("Deposito.Ejecutar");
   
 //  }

    @Override
    public void ejecutar() {
        
        DatosCuentas datosCuentas =obtenerDatosCuentas();
        Pantalla pantallaObj = obtenerPantalla();
        monto = pedirMontoADepositar();
        // monto =(int) MontoDeposito();
         
         if (monto!= CANCELAR)
         {
           pantallaObj.mostrarpMensaje("\n Inseerte Un sobre que contenga");
           pantallaObj.mostrarMontoQ(monto);
           pantallaObj.mostrarMensaje(".");
           
           boolean verificarSobreDeposito =  ranuraparadepositoobj.verificarSobreDeposito();
           
           if (verificarSobreDeposito)
           {
           
               pantallaObj.mostrarMensaje("\n Se recibio el sobre de deposito"
                       + "\n Nota el dinero que acaba de depositar no estara disponible"+
                       "hasta que verifiquemos el monto del efectivo y cualquier cheque incluido");
                datosCuentas.abonar(obtenerNumeroCuenta(), monto);
           }
           else
           {
             pantallaObj.mostrarMensaje("\n No inserto sobre de deposito transaccion cancelada");
           
           }
         
         }
         else {
             pantallaObj.mostrarMensaje("Transaccion Cancelada");
         }
    }
    
    private double  pedirMontoADepositar(){
    Pantalla pantallaObj =obtenerPantalla();
    
    pantallaObj.mostrarMensaje("Introduzaca un monto a depositar o 0 para cancelar");
     int entrada = tecladonumericoObj.capturarDatos();
       
     if (entrada== CANCELAR)
         return CANCELAR;
     else{
         return (double) entrada/100;
     }
    
    }

}
