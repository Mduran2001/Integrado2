package hotel;

public class Habitacion {
    
    //Atributos
    String piso;
    String numHabitcion;
    String precio;
    String estado;
    String nombre;
    
    //Constructor
    public Habitacion(String piso, String numHabitcion, String precio,String estado) {
        this.piso = piso;
        this.numHabitcion = numHabitcion;
        this.precio = precio;
        this.estado = estado;
        nombre = "";
    }
}
