import java.sql.DriverManager; //para el driver, es una clase que busca el driver que yo instale
import  java.sql.Connection;//para conectarme con la base de datos, es una clase que me permite el puente conexion entre ava y la base de Datos
import java.sql.ResultSet;
import java.sql.Statement;//para el sql

public class BaseDeDatos {
    private String conectorInstalado="jdbc:sqlite:";
    private String rutaBaseDeDatos="../Basedatos/basedatos.db";
    private Connection conexion;
    private Statement ejecutor;

    public void crearConexion(){
        try{
            conexion=DriverManager.getConnection(conectorInstalado+rutaBaseDeDatos);
            ejecutor= conexion.createStatement();
            ejecutor.setQueryTimeout(30);
        }
        catch (Exception e){

        }
    }
    public void cerrarConexion(){
        try{
            conexion.close();
        }
        catch (Exception e){

        }
    }

    public int insertar(String sql){
        try{
            int cant=ejecutor.executeUpdate(sql);   //(querry)hacer una consulta y genera una lista(resultset), (update)o me hace una actualizacion y me dice cuantos elementos afecte
            return cant;
        }
        catch (Exception e){
            return 0;
        }

    }
    public ResultSet consultar(String sql){
        try{
            ResultSet sr=ejecutor.executeQuery(sql);   //(querry)hacer una consulta y genera una lista(resultset), (update)o me hace una actualizacion y me dice cuantos elementos afecte
            return sr;
        }
        catch (Exception e){
            return null;
        }

    }
    public int actualizar(String sql){
        try{
            int cant=ejecutor.executeUpdate(sql);   //(querry)hacer una consulta y genera una lista(resultset), (update)o me hace una actualizacion y me dice cuantos elementos afecte
            return cant;
        }
        catch (Exception e){
            return 0;
        }
    }
    public int borrar(String sql){
        try{
            int cantidad= ejecutor.executeUpdate(sql);   //(querry)hacer una consulta y genera una lista(resultset), (update)o me hace una actualizacion y me dice cuantos elementos afecte
            return cantidad;
        }
        catch (Exception e){
            return 0;
        }
    }
}
