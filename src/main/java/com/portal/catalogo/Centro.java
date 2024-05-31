package com.portal.catalogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Centro {
	
	public int id;
	public String nombre;
	public String direccion;
	public int telefono;
	public String email;
	public String horario;
	
	public Centro() {}
	
}