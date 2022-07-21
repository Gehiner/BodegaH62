import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
public class Bodega 
{
    private List<Producto> listaProductos;
    
    public Bodega()
    {
        this.listaProductos=new ArrayList<Producto>();
    }

    public List<Producto> getListaProductos() {
        this.listaProductos.clear();
        BaseDeDatos bd =new BaseDeDatos();
        bd.crearConexion();
        //consulta
        try {
            ResultSet sr=bd.consultar("SELECT * FROM TProducto");
            while (sr.next()){
                String codigo=sr.getString(1);
                String nombre=sr.getString(2);
                String marca=sr.getString(3);
                String presentacion=sr.getString(4);
                String tipo=sr.getString(5);
                int precio=sr.getInt(6);
                int cantidad=sr.getInt(7);
                Producto p = new Producto(tipo,nombre,marca,presentacion,codigo,precio,cantidad);
                this.listaProductos.add(p);
            }

        }
        catch (Exception e){
            return null;
        }
        bd.cerrarConexion();
        return listaProductos;
    }

    public void agregarProducto(Producto p)
    {
        BaseDeDatos bd=new BaseDeDatos();
        String sql="INSERT INTO Tproducto(tipo, nombre, marca, presentacion, codigo, precio, cantidad) + VALUES(\""+p.getTipo()+"\", \""+p.getNombre()+"\", \""+p.getMarca()+"\", \""+p.getPresentacion()+"\",\""+p.getCodigo()+"\",\""+p.getPrecio()+"\",\""+p.getCantidad()+"\"";
        bd.crearConexion();
        bd.insertar(sql);
        bd.cerrarConexion();
    }

    public int buscarProducto(String codigo) 
    {

        return 0;
    }
    
    public ArrayList<Producto> buscarProductos(String criterio)
    {

        return null;
    }
    
    public void eliminarProducto(String codigo) 
    {

    }

   
    public void modificarPrecio(String codigo, int precio) 
    {

    }

    public void incrementarCantProducto(String codigo, int cant) 
    {

    }

    public void disminuirCantProducto(String codigo, int cant) 
    {

    }

}






