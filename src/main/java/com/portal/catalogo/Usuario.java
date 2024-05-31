package com.portal.catalogo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
	private String id;
	private String nombre;
	private String apellidos;
	private String email;
	//private Date fecha_nac;
	private int idCentro;
	private String idCurso;
	private String dni;
	private String tipo;
	private String nombreCentro;
	private String direccion;

	
}
