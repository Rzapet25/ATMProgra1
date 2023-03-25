
package atmprogra1;


public class SolicitudSaldo extends Transaccion {

    public SolicitudSaldo(int numeroCuentaUsuario, Pantalla pantallaObj, DatosCuentas datosCuentas) {
        super(numeroCuentaUsuario, pantallaObj, datosCuentas);
    }
    
    

   
    @Override
    public void ejecutar() {
        
        DatosCuentas datosCuentas =obtenerDatosCuentas();
        Pantalla pantallaObj = obtenerPantalla();
         
        double saldoDisponible = 
        datosCuentas.obtenerSaldoDisponible(obtenerNumeroCuenta());
        
         double saldoTotal =
        datosCuentas.obtenerSaldoTotal(obtenerNumeroCuenta());
        
        pantallaObj.mostrarMensaje("\n Informacion de Saldo");
        pantallaObj.mostrarpMensaje("- Saldo Disponible");
        pantallaObj.mostrarMontoQ(saldoDisponible);
        pantallaObj.mostrarpMensaje("\n Saldo Total:    ");
        pantallaObj.mostrarMontoQ(saldoTotal);
        pantallaObj.mostrarMensaje("");
    }

   
    
}
