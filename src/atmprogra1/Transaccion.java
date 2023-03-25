//Herencia
//Sobrescritura de metodos

package atmprogra1;

//Clase Padre, Deposito,Retiro 
//solo se heredan los atributos y metodos que son publicos
public abstract class Transaccion {
    
    //private int Monto;
    
    private int numeroCuenta;
    Pantalla pantallaObj;
    private DatosCuentas datosCuentas;

    public Transaccion(int numeroCuentaUsuario, Pantalla pantallaObj, DatosCuentas datosCuentas) {
        this.numeroCuenta = numeroCuentaUsuario;
        this.pantallaObj = pantallaObj;
        this.datosCuentas = datosCuentas;
    }
    public int obtenerNumeroCuenta(){
     return numeroCuenta;
    }
    
    public Pantalla obtenerPantalla(){
       
        return pantallaObj;
    
    }
    
    public DatosCuentas obtenerDatosCuentas(){
    
          return datosCuentas;
    }
     
    abstract public void ejecutar();

    /*public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }
    */
    
   // public void ejecutar(int monto) {
    
    //System.out.println("Transaccion.Ejecutar");
    //}
            
    
}
