package com.examenES.LP2_ES_Quispe_Yhon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
public class ClienteQuispeYhon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "nom_cliente", length = 50)
	private String nomCliente;

	@Column(name = "ape_cliente", length = 50)
	private String apeCliente;

	@Column(name = "dni", length = 12)
	private String dni;

	@Column(name = "telefono", length = 15)
	private String telefono;

	public String getNombreCompleto() {
		return String.format("%s %s", nomCliente, apeCliente);
	}
}
