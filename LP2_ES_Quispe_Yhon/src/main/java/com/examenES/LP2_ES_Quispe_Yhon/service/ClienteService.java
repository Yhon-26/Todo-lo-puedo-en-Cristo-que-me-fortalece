package com.examenES.LP2_ES_Quispe_Yhon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenES.LP2_ES_Quispe_Yhon.model.ClienteQuispeYhon;
import com.examenES.LP2_ES_Quispe_Yhon.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public List<ClienteQuispeYhon> getAll() {
		return clienteRepository.findAll();
	}
}
