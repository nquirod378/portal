package com.portal.servlets;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
import com.google.gson.Gson;
import com.portal.conector.Conector;
import com.portal.catalogo.Centro;
 
/**
* Servlet implementation class CentroServlet
*/
public class CentroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Centro> listaCentro = new ArrayList<>(); //arraylist para guarar objetos de tipo centro
		String sql = "SELECT * FROM centro";
		try(Connection con = new Conector().getMySQL()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {		//recorro el resultset y voy creando objetos de tipo centro
				Centro c = new Centro();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setDireccion(rs.getString(3));
				c.setTelefono(rs.getInt(4));
				c.setEmail(rs.getString(5));
				c.setHorario(rs.getString(6));
				listaCentro.add(c); // se añade a lista centro
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		String json = new Gson().toJson(listaCentro); // lo comvierto a json
		//System.out.println(json);		desactivar comentarios para controlar por consola si se devuelve el resultado previsto
		response.getWriter().write(json);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 
}
