package com.examenES.LP2_ES_Quispe_Yhon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenES.LP2_ES_Quispe_Yhon.dto.OrdenFilter;
import com.examenES.LP2_ES_Quispe_Yhon.dto.ResultadoResponse;
import com.examenES.LP2_ES_Quispe_Yhon.model.OrdenQuispeYhon;
import com.examenES.LP2_ES_Quispe_Yhon.repository.OrdenRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenService {

	private final OrdenRepository ordenRepository;

	public List<OrdenQuispeYhon> search(OrdenFilter filter) {
		return ordenRepository.findByFilters(filter.idCliente());
	}

	@Transactional
	public ResultadoResponse create(OrdenQuispeYhon orden) {
		try {
			var registrado = ordenRepository.save(orden);
			var mensaje = String.format("Orden de servicio con ID %d registrado.", registrado.getIdOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
