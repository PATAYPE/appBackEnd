package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClienteVentaKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name = "id_venta")
	private Integer idVenta;
	
}
