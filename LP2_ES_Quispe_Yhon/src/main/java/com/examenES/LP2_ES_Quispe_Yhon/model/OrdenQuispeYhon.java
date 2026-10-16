package com.examenES.LP2_ES_Quispe_Yhon.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_orden_servicio")
@Getter
@Setter
public class OrdenQuispeYhon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orden")
	private Integer idOrden;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteQuispeYhon cliente;

	@Column(name = "placa", length = 10)
	private String placa;

	@Column(name = "servicio", length = 80)
	private String servicio;

	@Column(name = "fecha_ingreso")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaIngreso;

	@Column(name = "estado", columnDefinition = "char(1)", length = 1)
	private String estado;

	public String getEstadoDescripcion() {
		if ("P".equals(estado)) {
			return "Pendiente";
		}
		if ("E".equals(estado)) {
			return "En proceso";
		}
		if ("F".equals(estado)) {
			return "Finalizado";
		}
		return "";
	}
}
