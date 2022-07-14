import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bodega 
{
    private List<Producto> listaProductos;

    public Bodega(){
        ArchivoProductos a= new ArchivoProductos();
        this.listaProductos=a.leerProductos();
    }

    public void agregarProducto(Producto p) throws IOException {
       this.listaProductos.add(p);
       ArchivoProductos a = new ArchivoProductos();
       a.guardarProducto(p.toCVC());
    }

    public void eliminarProducto(String codigo) 
    {

        int indexAEliminar=this.buscarProducto(codigo);
        if (indexAEliminar!=-1){
            this.listaProductos.remove(indexAEliminar);
        }
    }

    public void buscarProductos(String criterio){
        ArrayList<Producto> listEncontrados=new ArrayList<Producto>();
        for(Producto p: this.listaProductos){
            if (p.getNombre().equals(criterio)||p.getMarca().equals(criterio)||p.getPresentacion().equals(criterio)){
                listEncontrados.add(p);
            }
        }
    }
   public int buscarProducto(String codigo)
    {
        for(int i=0;i<this.listaProductos.size();i++){
            if(this.listaProductos.get(i).getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;
    }

    public void modificarPrecio(String codigo, int precio) 
    {
        int indexAModificar=this.buscarProducto(codigo);
        if (indexAModificar!=-1){
            this.listaProductos.get(indexAModificar).setPrecio(precio);
        }
    }

    public void incrementarCantProducto(String codigo, int cant) 
    {
        int indexAModificar=this.buscarProducto(codigo);
        if (indexAModificar!=-1){
            int cantidadActual=this.listaProductos.get(indexAModificar).getCantidad();
            this.listaProductos.get(indexAModificar).setCantidad(cantidadActual+cant);
        }
    }

    public void disminuirCantProducto(String codigo, int cant) 
    {
        int indexAModificar=this.buscarProducto(codigo);
        if (indexAModificar!=-1){
            int cantidadActual=this.listaProductos.get(indexAModificar).getCantidad();
            if(cantidadActual>=cant){
                this.listaProductos.get(indexAModificar).setCantidad(cantidadActual-cant);
            }
        }
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}