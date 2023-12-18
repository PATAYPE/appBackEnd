package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="Pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPais;
	
	@NotEmpty(message = "El nombre de pais no debe ser vacio")
	@NotBlank(message = "Por favor ingrese un nombre de pais")
	private String nombre;
	
	@Column(length = 1)
	private Integer estado;
	
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
}
