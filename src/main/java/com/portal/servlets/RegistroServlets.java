package com.portal.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.portal.conector.Conector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegistroServlets extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Boolean emailOk = false;
		Boolean dniOk = false;
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("user");
		String fechanacimiento = request.getParameter("nacimiento");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parseDate = null;
		int id_usuario = 0;
		
		try {
			parseDate = format.parse(fechanacimiento);
		} catch (Exception e) {
		}
		Date fechaSQL = new Date(parseDate.getTime());
		
		String dni = request.getParameter("dni");
		String id_centro = request.getParameter("centro");
		String id_curso = request.getParameter("curso");
		String passwd = request.getParameter("contrasena");
		
		
		String sql = "insert into usuarios (id, nombre, apellidos, email, fecha_nacimiento, dni, id_centro, id_curso, tipo_usuario) values (?,?,?,?,?,?,?,?,'alumno')";
		String sql2 = "insert into credenciales (email, clave) values (?,?)";
		String sql3 = "Select id from credenciales where email = ?";
		String sql4 = "Select * from credenciales where email = ?";
		String sql5 = "Select * from usuarios where dni = ?";
		
		Connection con = null;
		try {
			con = new Conector().getMySQL();
			con.setAutoCommit(false);
			
			PreparedStatement ps4 = con.prepareStatement(sql4);
			ps4.setString(1, email);
			
			ResultSet rs2 = ps4.executeQuery();
			
			if(!rs2.next()) {
				emailOk = true;
				System.out.println("email no esta en la BBDD");
			} else {
				System.out.println("Email en BBDD");
			}
			
			
			PreparedStatement ps5 = con.prepareStatement(sql5);
			ps5.setString(1, dni);
			
			ResultSet rs3 = ps5.executeQuery();
			
			if(!rs3.next()) {
				dniOk = true;
				System.out.println("DNI no esta en la BBDD");
			} else {
				System.out.println("DNI en BBDD");
			}
			
			if(dniOk && emailOk) {
				
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setString(1, email);
				ps2.setString(2, passwd);
				
				ps2.executeUpdate();
				System.out.println("Inserción correcta");
				
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setString(1, email);
				
				ResultSet rs = ps3.executeQuery();
				
				while(rs.next()) {
					id_usuario = rs.getInt(1);
				}
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id_usuario);
				ps.setString(2, nombre);
				ps.setString(3, apellidos);
				ps.setString(4, email);
				ps.setDate(5, fechaSQL);
				ps.setString(6, dni);
				ps.setString(7, id_centro);
				ps.setString(8, id_curso);
				
				ps.executeUpdate();
				System.out.println("Inserción correcta");
				
				con.commit();
				
				response.sendRedirect("jsp/login.jsp");
			} else {
				con.commit();
				response.sendRedirect("jsp/Registro.jsp");
			}
			
		} catch (Exception e) {
			try {
				if(con!=null) {
					con.rollback();
					System.out.println("La transaccion no se ha completado");
				}
				}catch(SQLException e1) {
				e1.printStackTrace();
				}		
			}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
