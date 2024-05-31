package com.portal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portal.catalogo.Usuario;
import com.portal.conector.Conector;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



//@WebServlet(urlPatterns = "/login")
public class LoginServlets extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/portal/jsp/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		String email = request.getParameter("user");
		String password = request.getParameter("passwd");
 
		HttpSession session = request.getSession();
 
		Usuario user = null;
		Connection conn = null;
 
		try {
			conn = new Conector().getMySQL();
 
			if (conn != null) {
				System.out.println("Conexion OK");
 
				PreparedStatement ps = conn.prepareStatement(
					"SELECT centro.nombre, usuarios.id, usuarios.nombre, usuarios.apellidos, usuarios.email, usuarios.dni, usuarios.tipo_usuario, usuarios.fecha_nacimiento, usuarios.id_centro, usuarios.id_curso " +
					"FROM credenciales " +
					"JOIN usuarios ON credenciales.id = usuarios.id LEFT OUTER JOIN centro ON usuarios.id_centro = centro.id_centro " +
					"WHERE credenciales.email = ? AND clave = ?"
				);
 
				ps.setString(1, email);
				ps.setString(2, password);
 
				ResultSet rs = ps.executeQuery();
 
				if (rs.next()) {
					user = new Usuario();
					user.setId(rs.getString("id"));
					user.setNombre(rs.getString("usuarios.nombre"));
					user.setApellidos(rs.getString("apellidos"));
					user.setEmail(rs.getString("usuarios.email"));
					user.setDni(rs.getString("dni"));
					user.setTipo(rs.getString("tipo_usuario"));
					user.setIdCentro(rs.getInt("id_centro"));
					user.setIdCurso(rs.getString("id_curso"));
					user.setNombreCentro(rs.getString("centro.nombre"));
					String tipo;
					tipo = rs.getString("tipo_usuario");
					session.setAttribute("usuario", user);
					session.setAttribute("tipo", tipo);

					response.sendRedirect("/portal/index.jsp");
				} else {
					response.sendRedirect("/portal/jsp/login.jsp");
				}
			} else {
				response.sendRedirect("/portal/jsp/login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Error");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
