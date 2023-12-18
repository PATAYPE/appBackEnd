package com.example.entity;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;

@Entity
@Table(name="Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "el nombre no debe ser vacio")
	@NotBlank(message = "ingrese un nombre")
	@Column(length = 200, nullable = false)
	private String nombres;
	
	@NotEmpty(message = "el apellido no debe ser vacio")
	@NotBlank(message = "ingrese un apellido")
	@Column(length = 200, nullable = false)
	private String apellidos;
	
	@NotEmpty(message = "el campo nro. documento no debe ser vacio")
	@NotBlank(message = "ingrese un nro. documento")
	@Column(length = 9, nullable = false)
	private String nroDocumento;
	
	@NotEmpty(message = "el campo email no debe ser vacio")
	@NotBlank(message = "ingrese un email")
	@Email(message = "Por favor ingrese un email valido")
	@Column(length = 40, nullable = false)
	private String email;
	
	@Column(length = 1)
	private Integer estado;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@NotNull(message = "se debe seleccionar el campo Pais")
	@ManyToOne
	@JoinColumn(name="id_pais", nullable = false)
	private Pais pais;
	
	
	@OneToMany(mappedBy = "client")
	private List<ClienteVenta> clientesVentas;
	

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<ClienteVenta> getClientesVentas() {
		return clientesVentas;
	}

	public void setClientesVentas(List<ClienteVenta> clientesVentas) {
		this.clientesVentas = clientesVentas;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
	
	
}
