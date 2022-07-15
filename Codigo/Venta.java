import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<Producto> carritoCompra;
    public Venta(){
        carritoCompra=new ArrayList<Producto>();
    }
    public void agregarACarrito(Producto p, int cantidad ){
        p.setCantidad(cantidad);
        this.carritoCompra.add(p);
    }
    public int calcularVenta(){
        int valorTotal=0;
        for (Producto p: this.carritoCompra){
            valorTotal+= p.getCantidad()*p.getPrecio();
        }
        return valorTotal;
    }
    public void finalizarVenta()
    {
        Bodega b = new Bodega();
        for (Producto p : this.carritoCompra)
        {
            b.disminuirCantProducto(p.getCodigo(), p.getCantidad());
        }
        b.actualizarArchivo();
    }
}
