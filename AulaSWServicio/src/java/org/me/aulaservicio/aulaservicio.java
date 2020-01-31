/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.aulaservicio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author link
 */
@WebService(serviceName = "aulaservicio")
@Stateless()
public class aulaservicio {

    /**
     * Registra un usuario con un nombre, email y contraseña
     */
    @WebMethod(operationName = "registrar")
    public int registrar(@WebParam(name = "nombre") String nombre, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        // Comprobamos que no existe
        int salida = -99;
        String consulta = "Select count(*) as existe from usuarios where email='"+email+"'";
        // Abrimos la base de datos
        ControladorBD bd = ControladorBD.nuevaConexionBD();
        bd.abrirBD();
        ResultSet rs = bd.consultarBD(consulta);
        int tam=0;
        try {
            while (rs.next()) {
                tam = rs.getInt("existe");
            }
        } catch (SQLException ex) {
            System.err.println("ServicioSW->" + ex.getMessage());
            salida = -99;
        }
        // Si no existe lo insertamos
        if(tam==0){
             consulta = "INSERT INTO usuarios (nombre, email, password) "
                     + "VALUES ('"+nombre+"','"+email+"','"+password+"')";
             //System.out.println(consulta);
            if(bd.actualizarBD(consulta)>0){
            // Vamos a crearle la firma
                crearFirmas(email);
                salida = 1;
            }
            else{
                salida = -99;
            }
        }else{
            // Si existe lo largamos
            salida = -1;
        }
        bd.cerrarBD();
        return salida;
    }
    
    private void crearFirmas(String email){
        String consulta = "Select id from usuarios where email='"+email+"'";
        ControladorBD bd = ControladorBD.nuevaConexionBD();
        bd.abrirBD();
        ResultSet rs = bd.consultarBD(consulta);
        int id=0;
        try {
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("ServicioSW->" + ex.getMessage());
        }
        // Creamos las claves y las metemos
        for(int i = 1; i<=20; i++){
            consulta = "INSERT INTO firmas (id, usuario_id, valor) "
                     + "VALUES ('"+i+"','"+id+"','"+getComponente()+"')";
            System.err.println(consulta);
            bd.actualizarBD(consulta);
        }
        bd.cerrarBD();
    }
    
    private String getComponente(){
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sal="";
        for(int i=0; i<4;i++){
            Random rnd = new Random();
            char c = alphabet.charAt(rnd.nextInt(alphabet.length()));
            sal+=c;
        }
        return sal; 
    }
    
    ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS
    
    /**
     * Identifica a un usuario en la BD
     * email y password como parámetros de entradas
     * devueleve el id del usuario si éxito
     * -1 si no existe
     * -99 si error
     */
    @WebMethod(operationName = "indetificar")
    public int indetificar(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        int salida = 0;
        String consulta = "Select id as id from usuarios where email='"+email+"' and password='"+password+"'";
        //System.out.println(consulta);
        ControladorBD bd = ControladorBD.nuevaConexionBD();
        bd.abrirBD();
        // Consultamos
        ResultSet rs = bd.consultarBD(consulta);
        int id=-1;
        try {
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("ServicioSW->" + ex.getMessage());
            salida = -99;
        }
        // si existe, lo insertamos en acceso
        if(id>0){
            // Primero lo borramos si hay algún rastro
             consulta = "DELETE from accesos where usuario_id='"+id+"'";
            bd.actualizarBD(consulta);
            
            consulta = "INSERT INTO accesos (usuario_id) "
                     + "VALUES ('"+id+"')";
            //System.out.println(consulta);
            if(bd.actualizarBD(consulta)>0){
            // Vamos a crearle la firma
                bd.cerrarBD();
                salida = id;
                
            }
            else{
                salida = -99;
            }
            
        }else{
            salida = -1;
        }
        bd.cerrarBD();
        return salida;
    }
    
    ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Sale de la sesión del usuario
     * 1, exito
     * -1 no existe
     * -99 otro
     */
    @WebMethod(operationName = "salir")
    public int salir(@WebParam(name = "id") int id) {
        int salida = 0;
        String consulta = "Select id as id from usuarios where id='"+id+"'";
        //System.out.println(consulta);
        ControladorBD bd = ControladorBD.nuevaConexionBD();
        bd.abrirBD();
        // Consultamos
        ResultSet rs = bd.consultarBD(consulta);
        int user=-1;
        try {
            while (rs.next()) {
                user = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("ServicioSW->" + ex.getMessage());
            salida = -99;
        }
        // si existe, lo insertamos en acceso
        if(user>0){
            consulta = "DELETE from accesos where usuario_id='"+id+"'";
            //System.out.println(consulta);
            if(bd.actualizarBD(consulta)>0){
            // Vamos a crearle la firma
                bd.cerrarBD();
                salida = 1;
                
            }
            else{
                salida = -99;
            }
            
        }else{
            salida = -1;
        }
        bd.cerrarBD();
        return salida;
    }
    ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Devuelve los datos del usuario en JSON si existe
     */
    @WebMethod(operationName = "usuario")
    public String usuario(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        String salida = "nada";
        String consulta = "select id, nombre, email, password, momento from usuarios, accesos "
                + "where id='"+id+"' and id = usuario_id";
        //System.out.println(consulta);
        ControladorBD bd = ControladorBD.nuevaConexionBD();
        bd.abrirBD();
        // Consultamos
        ResultSet rs = bd.consultarBD(consulta);
        Usuario user = null;
        try {
            while (rs.next()) {
                user = new Usuario(rs.getInt("id"), rs.getString("nombre"), 
                        rs.getString("email"), rs.getString("password"), rs.getTimestamp("momento"));
            }
        } catch (SQLException ex) {
            System.err.println("ServicioSW->" + ex.getMessage());
            salida = "error";
        }
        // si existe, lo insertamos en acceso
        if(user!=null){
            // Pasamos a JSON
            Gson gson = new Gson();  
            salida = gson.toJson(user);
            // Para recuperarlo
            //JsonParser parser = new JsonParser();
            //salida = parser.parse(salida).getAsJsonObject().get("email").getAsString();
            return salida;
        }else{
            salida = "nada";
        }
        bd.cerrarBD();
        return salida;
    }
    ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Web service operation. Obtiene un listado de alumnos en JSON
     */
    @WebMethod(operationName = "listar")
    public String listar(@WebParam(name = "id") int id) {
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        ControladorBD c = ControladorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta = "Select * from alumnos where usuario_id='"+id+"' order by id";
        //System.out.println(consulta);
        ResultSet rs = c.consultarBD(consulta);
        c.cerrarBD();
        try {
            while(rs.next()){
                Alumno a = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("nota"));
                lista.add(a);
            }
        } catch (SQLException ex) {
           System.err.println("Servicio->Error al listar " +ex.getMessage());
           return "-99";
        }
        // Serializamos
        Gson gson = new Gson();  
        String salida = gson.toJson(lista); 
        return salida;
    }
  ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Devuelve las estadístcias de un clase
     */
    @WebMethod(operationName = "estadisticas")
    public String estadisticas(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Estadistica e = new Estadistica();
            ControladorBD c = ControladorBD.nuevaConexionBD();
            c.abrirBD();
            // sacamos el aprobados
            String consulta = "select COUNT(id) as aprobados from alumnos where nota>=5 and usuario_id='"+id+"'";
            //System.out.println(consulta);
            ResultSet rs = c.consultarBD(consulta);
            c.cerrarBD(); 
            try {
                while(rs.next())
                    e.setAprobados(rs.getInt("aprobados"));

            } catch (SQLException ex) {
                System.err.println("Servicio->Error al obtener aprbados " +ex.getMessage());
                return "-98";
            }
            
            // Suspensos
            c.abrirBD();
            // sacamos el aprobados
            consulta = "select COUNT(id) as suspensos from alumnos where nota<5 and usuario_id='"+id+"'";
            //System.out.println(consulta);
            rs = c.consultarBD(consulta);
            c.cerrarBD(); 
            try {
                while(rs.next())
                    e.setSuspensos(rs.getInt("suspensos"));

            } catch (SQLException ex) {
                System.err.println("Servicio->Error al obtener suspensos " +ex.getMessage());
                return "-97";
            }
            
            // Media
            c.abrirBD();
            // sacamos el aprobados
            consulta = "select AVG(nota) as media from alumnos where usuario_id='"+id+"'";
            //System.out.println(consulta);
            rs = c.consultarBD(consulta);
            c.cerrarBD(); 
             try {
                while(rs.next())
                   e.setMedia(rs.getFloat("media"));

            } catch (SQLException ex) {
                System.err.println("Servicio->Error al obtener media " +ex.getMessage());
                return "-96";
            }
            // Parseamos
            Gson gson = new Gson();  
            String salida = gson.toJson(e);
            return salida;
    }
    ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Obtiene la tarjeta de coordenadas de un usuario
     */
    @WebMethod(operationName = "tarjeta")
    public String tarjeta(@WebParam(name = "id") int id) {
        ArrayList<Coordenada> lista = new ArrayList<Coordenada>();
        ControladorBD c = ControladorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta = "Select * from firmas where usuario_id='"+id+"' order by id";
        //System.out.println(consulta);
        ResultSet rs = c.consultarBD(consulta);
        c.cerrarBD();
        try {
            while(rs.next()){
                Coordenada a = new Coordenada(rs.getInt("id"), rs.getString("valor"));
                lista.add(a);
            }
        } catch (SQLException ex) {
           System.err.println("Servicio->Error al tarjeta " +ex.getMessage());
           return "-99";
        }
        // Serializamos
        Gson gson = new Gson();  
        String salida = gson.toJson(lista); 
        return salida;
    }
  ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Inicia la operación de firmar
     */
    @WebMethod(operationName = "firmar")
    public int firmar(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y 99
        int al = aleatorio.nextInt(20)+1;
        //refresca la semilla de aleatorios
        aleatorio.setSeed(System.currentTimeMillis());
        return al;
    }

    /**
     * Comprueba si una firma es válida
     */
    @WebMethod(operationName = "validar")
    public int validar(@WebParam(name = "id") int id, @WebParam(name = "clave") int clave, @WebParam(name = "valor") String valor) {
            ControladorBD c = ControladorBD.nuevaConexionBD();
            c.abrirBD();
            int val=0;
            // sacamos el aprobados
            String consulta = "select COUNT(id) as veces from firmas where "
                    + "usuario_id='"+id+"' and valor='"+valor+"' and id ='"+clave+"'";
            //System.out.println(consulta);
            ResultSet rs = c.consultarBD(consulta);
            c.cerrarBD(); 
            try {
                while(rs.next()){
                   val = rs.getInt("veces");
                   return val;
                }     

            } catch (SQLException ex) {
                System.err.println("Servicio->Error al validar " +ex.getMessage());
                return -99;
            }
            return val;
    }
  ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Inserta un alumno con su calificacion
     */
    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "nota") float nota) {
        String consulta = "INSERT INTO alumnos (usuario_id, nombre, nota) "
                     + "VALUES ('"+id+"', '"+nombre+"', '"+nota+"')";
        int sal = -1;
        ControladorBD c = ControladorBD.nuevaConexionBD();
        c.abrirBD();
        if(c.actualizarBD(consulta)>0){
            // Vamos a crearle la firma
                sal = 1;
            }
            else{
                sal = -99;
            }
        c.cerrarBD();
        return sal;
    }
    ///************* FIN DE SERVICIO Y MÉTODO ASOCIADOS

    /**
     * Elimina a un usuario de una tabla
     */
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "usuario_id") int usuario_id, @WebParam(name = "alumno_id") int alumno_id) {
         String consulta = "DELETE from alumnos where usuario_id ='"+usuario_id+"' and id='"+alumno_id+"'";
         int sal = -1;
        ControladorBD c = ControladorBD.nuevaConexionBD();
        c.abrirBD();
        if(c.actualizarBD(consulta)>0){
            // Vamos a crearle la firma
                sal = 1;
            }
            else{
                sal = -99;
            }
        c.cerrarBD();
        return sal;

    }
}
