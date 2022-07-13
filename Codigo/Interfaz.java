import javax.swing.JOptionPane;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class Interfaz {
    private Bodega b;
    public Interfaz(){
        b=new Bodega();
    }
    public void presentarMenu(){
        int opcion=0;
        do {
            String menu="Menu Principal \n" +
                        "1. Ingresar Producto Nuevo\n" +
                        "2. Mostrar lista de Productos\n" +
                        "0.Salir";
            opcion= Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Seleccione una opcion",JOptionPane.QUESTION_MESSAGE ));
            switch (opcion){
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias", "Salir del programa",JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Advertencia",JOptionPane.WARNING_MESSAGE);
            }

        }while (opcion!=0);

    }

    public void ingresarProducto() {
        String tipo=JOptionPane.showInputDialog(null, "Ingrese Tipo de Producto", "Producto nuevo", JOptionPane.QUESTION_MESSAGE);
        String nombre=JOptionPane.showInputDialog(null, "Ingrese nombre de Producto", "Nombre de producto", JOptionPane.QUESTION_MESSAGE);
        String marca=JOptionPane.showInputDialog(null, "Ingrese la Marca del Producto", "Marca del producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion=JOptionPane.showInputDialog(null, "Ingrese la presentacion del Producto", "Presentacion del producto", JOptionPane.QUESTION_MESSAGE);
        String codigo=this.generarCodigoAleatorio();
        int precio= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese El precio del Producto", "Precio del producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad  del Producto", "Cantidad del producto", JOptionPane.QUESTION_MESSAGE));

        Producto p=new Producto(tipo,nombre,marca,presentacion,codigo,precio,cantidad);
        b.agregarProducto(p);
        JOptionPane.showMessageDialog(null, "Producto Agregado Con Exito \n" + p.toString(), "Producto Agregado", JOptionPane.INFORMATION_MESSAGE);
    }
    public String generarCodigoAleatorio(){
        Random ramdom=new Random();
        String codigo="";
        String caracteres="0123456789abcdefgihjklmnopqrstuvwxyz";
        for (int j=0;j<10;j++){
            int i=ramdom.nextInt(caracteres.length());
            codigo += caracteres.charAt(i);
        }
        return codigo;
    }
    public void mostrarProductos(){
        ArrayList<Producto> lista = (ArrayList<Producto>) b.getListaProductos();
        for (Producto p:lista){
            JOptionPane.showMessageDialog(null, p.toString(),"Productos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
