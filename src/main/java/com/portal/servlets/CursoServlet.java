package com.portal.servlets;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
 
import com.portal.conector.Conector;
import com.google.gson.Gson;
import com.portal.catalogo.Curso;
 
/**
* Servlet implementation class CursoServlet
*/
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valorSeleccionado = request.getParameter("value");
		ArrayList<Curso> listaCurso = new ArrayList<>();	//arraylist para guardar objetos de tipo curso
 
		
		String sql = "SELECT c.id_curso,c.nombre FROM curso c INNER JOIN rel_curso_centro r "+
				"ON c.id_curso = r.curso_id "+
				"INNER JOIN centro e "+
				"ON r.centro_id = e.id_centro " +
				"WHERE e.id_centro = ?";
		try(Connection con = new Conector().getMySQL()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, valorSeleccionado);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {		//recorro el resultset y voy creando objetos de tipo curso
				Curso cu = new Curso();
				cu.setId(rs.getInt(1));
				cu.setNombre(rs.getString(2));
				listaCurso.add(cu); 		// se añade a lista curso
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		String json = new Gson().toJson(listaCurso); //creamos un json con el contenido de listaCurso
		//System.out.println(json);		descomentar para comprobar respuesta en consola
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
