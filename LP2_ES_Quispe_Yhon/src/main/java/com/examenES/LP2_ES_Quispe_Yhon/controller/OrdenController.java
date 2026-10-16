package com.examenES.LP2_ES_Quispe_Yhon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenES.LP2_ES_Quispe_Yhon.dto.OrdenFilter;
import com.examenES.LP2_ES_Quispe_Yhon.model.OrdenQuispeYhon;
import com.examenES.LP2_ES_Quispe_Yhon.service.ClienteService;
import com.examenES.LP2_ES_Quispe_Yhon.service.OrdenService;
import com.examenES.LP2_ES_Quispe_Yhon.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("orden")
@RequiredArgsConstructor
public class OrdenController {

	private final OrdenService ordenService;
	private final ClienteService clienteService;

	@GetMapping("listado")
	public String listado(@ModelAttribute OrdenFilter filter, Model model) {
		model.addAttribute("lstOrdenes", ordenService.search(filter));
		model.addAttribute("lstClientes", clienteService.getAll());
		model.addAttribute("filter", filter);
		return "orden/listado";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstClientes", clienteService.getAll());
		model.addAttribute("orden", new OrdenQuispeYhon());
		return "orden/nuevo";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenQuispeYhon orden, RedirectAttributes flash) {
		var response = ordenService.create(orden);
		flash.addFlashAttribute("alert",
				Alert.sweetToast(response.mensaje(), response.success() ? "success" : "error", 5000));
		return "redirect:/orden/listado";
	}
}
