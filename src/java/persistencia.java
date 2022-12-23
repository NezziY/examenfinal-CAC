
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSetMetaData;



/**
 *
 * @author vanep
 */
public class persistencia {
    
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    
    public String servidor, baseDeDatos, usuario, clave, ejecutar;
    
    public Connection conectarse(){
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
       
        
        servidor="localhost:3306/";
        baseDeDatos="cacproyecto";
        usuario="root";
        clave="";
        
        cn= (Connection) DriverManager.getConnection("jdbc:mysql://"+servidor+baseDeDatos+"?autoReconnect=true&useSSL=false",usuario,clave);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    return cn;
    }

    //***********************************************
    
    public ResultSet consultaSQL(String busqueda){
        
        try {
            ps=conectarse().prepareStatement(busqueda);
        
       
        rs=ps.executeQuery();
            
        rsm=rs.getMetaData();
        
        } catch (SQLException ex) {
            Logger.getLogger(persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    
    }

}
  