import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Interfaz {
    private Bodega b;
    public Interfaz(){
        b=new Bodega();
    }

    public void presentarMenu() throws IOException {
        int opcion=0;
        do{
            String menu="MENU PRODUCTOS \n" +
                    "1. Producto\n" +
                    "2. ventas\n" +
                    "0.Regresar Al menu principal";
            opcion= Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Seleccione una opcion",JOptionPane.QUESTION_MESSAGE ));
            switch (opcion){
                case 1:
                    this.presentarMenuProductos();
                    break;
                case 2:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias", "Salir del programa",JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        }while (opcion!=0);
    }
    public void presentarMenuProductos() throws IOException {
        int opcion=0;
        do {
            String menu="MENU PRODUCTOS \n" +
                        "1. Ingresar Producto Nuevo\n" +
                        "2. Mostrar lista de Productos\n" +
                        "3. Buscar Productos\n" +
                        "4. Suritr Productos\n" +
                        "0.Regresar Al menu principal";
            opcion= Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Seleccione una opcion",JOptionPane.QUESTION_MESSAGE ));
            switch (opcion){
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProductos();
                    break;
                case 4:
                    surtirProductos();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias", "Salir del programa",JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Advertencia",JOptionPane.WARNING_MESSAGE);
            }

        }while (opcion!=0);
        presentarMenu();
    }

    public void ingresarProducto() throws IOException {
        String [] tipos = {"Aseo", "Alimento"};
        int tipo = JOptionPane.showOptionDialog(null, "Ingrese tipo de producto", "Producto nuevo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        String nombre=JOptionPane.showInputDialog(null, "Ingrese nombre de Producto", "Nombre de producto", JOptionPane.QUESTION_MESSAGE);
        String marca=JOptionPane.showInputDialog(null, "Ingrese la Marca del Producto", "Marca del producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion=JOptionPane.showInputDialog(null, "Ingrese la presentacion del Producto", "Presentacion del producto", JOptionPane.QUESTION_MESSAGE);
        String codigo=this.generarCodigoAleatorio();
        int precio= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese El precio del Producto", "Precio del producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad  del Producto", "Cantidad del producto", JOptionPane.QUESTION_MESSAGE));

        Producto p = new Producto(tipos[tipo], nombre, marca, presentacion, codigo, precio, cantidad);
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
        String listado="";
        ArrayList<Producto> lista = (ArrayList<Producto>) b.getListaProductos();
        for (Producto p:lista){
            listado+=p.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null, listado,"Productos ", JOptionPane.INFORMATION_MESSAGE);
    }
    public ArrayList<Producto> buscarProductos(){
        String busqueda=JOptionPane.showInputDialog(null, "Ingrese la marca,nombre,presentacion", "Busqueda del producto", JOptionPane.QUESTION_MESSAGE);
        ArrayList<Producto> lista = new ArrayList<Producto>();
        lista=b.buscarProductos(busqueda);
        String listado="";
        for (int i=0;i<lista.size();i++){
            listado+= "["+ (i+1) + "]"+ lista.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null, listado,"Productos Encontrados", JOptionPane.INFORMATION_MESSAGE);
        return lista;
    }
    public void surtirProductos() {
        List<Producto> lista=this.buscarProductos();
        int posicion= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posicion del producto a surtir", "Surtir Producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto a surtir", "Surtir Producto", JOptionPane.QUESTION_MESSAGE));
        String codigo=lista.get(posicion-1).getCodigo();
        b.incrementarCantProducto(codigo,cantidad);
        JOptionPane.showMessageDialog(null, "producto surtido exitosamente ", "Producto Surtido", JOptionPane.INFORMATION_MESSAGE);
    }


    public void generarVenta()
    {
        Venta v = new Venta();
        List<Producto> lista = this.buscarProductos();
        int posicion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese posición del producto a vender", "Vender producto", JOptionPane.QUESTION_MESSAGE)) - 1;
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad del producto a vender", "Vender producto", JOptionPane.QUESTION_MESSAGE));
        Producto p = lista.get(posicion);
        if (cantidad <= p.getCantidad()) {
            v.agregarACarrito(p, cantidad);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cantidad insuficiente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
