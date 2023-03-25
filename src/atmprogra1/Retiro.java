
package atmprogra1;


public class Retiro extends Transaccion{
    private int numeroCuenta;
    private int monto;

   
    private Pantalla pantallaObj;
    private TecladoNumerico tecladonumericoObj;
    private Dispensador dispensadorObj;
    private DatosCuentas datosCuentas;
    
    private final static int CANCELAR =6;

   

    Retiro(int numeroCuenta, Pantalla pantallaObj, DatosCuentas datosCuentas, TecladoNumerico tecladonumericoObj, Dispensador dispensadorObj) {
                 super(numeroCuenta, pantallaObj, datosCuentas);
      
        this.tecladonumericoObj = tecladonumericoObj;
        this.dispensadorObj = dispensadorObj;
        
    }

   
 

   

    
   
   
   
    
 /*   
  private  int Monto; */  
  
    @Override
    public void ejecutar() {
        boolean efectivoDispensado = false;
        double saldoDisponible;
        
         DatosCuentas datosCuentas =obtenerDatosCuentas();
        Pantalla pantallaObj = obtenerPantalla();
        
        do
        {
        
        monto = mostrarMenuMontos();
        
        if (monto!=CANCELAR)
        {
           
            saldoDisponible=
            datosCuentas.obtenerSaldoDisponible(obtenerNumeroCuenta());
        if (monto<=saldoDisponible)
        {
        
        if(dispensadorObj.verificarEfectivo(monto))
        {
            datosCuentas.cargar(obtenerNumeroCuenta(), monto);
        
           dispensadorObj.dispensarEfectivo(monto);
          efectivoDispensado= true;
          
          pantallaObj.mostrarMensaje("\n Transaccion Completa Tome su Efectivo" );
        }
        else
            pantallaObj.mostrarMensaje("\n No hay suficiente Efectivo"
                    + "\n Ingrese un Monto menor");
        }
        else
        {   
            pantallaObj.mostrarMensaje("\n No hay suficientes fondos en su cuenta"
                    + "\n Ingrese un Monto menor");
        }  
        }
        else
        {
          pantallaObj.mostrarMensaje("\n Cancelando Transaccion...");
                
           return;
                
    }
    
}while(!efectivoDispensado);

}    

    private int mostrarMenuMontos(){
   
     int Opcion =0;
     
     Pantalla pantallaObj =obtenerPantalla();
      int montos []={100,200,300,400,500};
      while(Opcion==0);
      {
       pantallaObj.mostrarMensaje("\n Menu de Retiro");
       pantallaObj.mostrarMensaje("1 - 100Q");
       pantallaObj.mostrarMensaje("2 - 200Q");
       pantallaObj.mostrarMensaje("3 - 300Q"); 
       pantallaObj.mostrarMensaje("4 - 400Q");
       pantallaObj.mostrarMensaje("5 - 500Q");
       pantallaObj.mostrarMensaje("6 - Cancelar Transacción");
       pantallaObj.mostrarpMensaje("\n Seleccione un monto a retirar");
       
       int entrada =tecladonumericoObj.capturarDatos();
      
       switch(entrada)
       {
           case 1:
           case 2:
           case 3:
           case 4:
           case 5:
               Opcion =montos[entrada];
           break;
           case CANCELAR:
               Opcion =CANCELAR;
           break;
           default:
               pantallaObj.mostrarMensaje("\n Ingrese una opcion Valida");
       }    
      
   }
      return Opcion;
}
}

    