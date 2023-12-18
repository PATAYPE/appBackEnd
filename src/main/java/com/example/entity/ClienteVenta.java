package com.example.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente_Venta")
public class ClienteVenta {
	
	@EmbeddedId
	ClienteVentaKey id;
	
	
	@ManyToOne
	@MapsId("idClient")
	@JoinColumn(name="id_cliente")
	private Cliente client;
	
	
	@ManyToOne
	@MapsId("idVenta")
	@JoinColumn(name = "id_venta")
	private Venta venta;

}
