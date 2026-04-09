package hotel;

import javax.swing.JOptionPane;

public class Hotel {

    public static void main(String[] args) {

        //Array
        Habitacion[][] habitacion = new Habitacion[3][3];

        habitacion[0][0] = new Habitacion("1P", "Habitacion #1 ", "10000", "Libre");
        habitacion[0][1] = new Habitacion("1P", "Habitacion #2 ", "10000", "Libre");
        habitacion[0][2] = new Habitacion("1P", "Habitacion #3 ", "10000", "No disponible");

        habitacion[1][0] = new Habitacion("2P", "Habitacion #4 ", "20000", "Libre");
        habitacion[1][1] = new Habitacion("2P", "Habitacion #5 ", "20000", "Sucio");
        habitacion[1][2] = new Habitacion("2P", "Habitacion #6 ", "20000", "Libre");

        habitacion[2][0] = new Habitacion("3P", "Habitacion #7 ", "30000", "No disponible");
        habitacion[2][1] = new Habitacion("3P", "Habitacion #8 ", "30000", "Sucio");
        habitacion[2][2] = new Habitacion("3P", "Habitacion #9 ", "30000", "Libre");

        //Menu
        String opc = "";
        while (!opc.equals("5")) {
            opc = JOptionPane.showInputDialog(""
                    + "1. Ver habitaciones" + "\n"
                    + "2. Reservar Habitacion" + "\n"
                    + "3. Modificar las Habitaciones" + "\n"
                    + "4. Resumen" + "\n"
                    + "5. Salir");
            if (opc == null) {
                opc = "5";
            }
            //Recorre todo el array
            if (opc.equals("1")) {
                String msg = "";
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        msg = msg + habitacion[i][j].piso + " " + habitacion[i][j].numHabitcion + " " + habitacion[i][j].precio + " " + habitacion[i][j].estado + "\n";
                    }
                    msg = msg + "\n";
                }
                JOptionPane.showMessageDialog(null, msg);
            } 
            //Reserva de habitaciones
            else if (opc.equals("2")) {
                String pisos = JOptionPane.showInputDialog("Piso (1-3)");
                String habitaciones = JOptionPane.showInputDialog("Habitacion (1-3)");

                int p = Integer.parseInt(pisos) - 1;
                int h = Integer.parseInt(habitaciones) - 1;

                if (habitacion[p][h].estado.equals("Libre")) {

                    String nombre = JOptionPane.showInputDialog("Nombre");

                    double precio = Double.parseDouble(habitacion[p][h].precio);

                    habitacion[p][h].estado = "Ocupado";
                    habitacion[p][h].nombre = nombre;
                    habitacion[p][h].precio = " " + precio;

                    JOptionPane.showMessageDialog(null, "Reservado a nombre de : " + nombre);
                }
            } 
            //Editar array
            else if (opc.equals("3")) {
                String numHabitcion = JOptionPane.showInputDialog("Ingrese el numero de habitacion que deseas ingresar : ");
                for (int i = 0; i < habitacion.length; i++) {
                    for (int j = 0; j < habitacion.length; j++) {
                        if (habitacion[i][j].numHabitcion.equalsIgnoreCase(numHabitcion)) {     
                        }
                    }
                }
            } 
            //Resumen
            else if (opc.equals("4")) {
                double total = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (habitacion[i][j].estado.equals("Ocupado")) {
                            total = total + Double.parseDouble(habitacion[i][j].precio);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "La habitacion reservada tiene un valor de : " + total+ " Colones.");
            }
        }
    }
}
