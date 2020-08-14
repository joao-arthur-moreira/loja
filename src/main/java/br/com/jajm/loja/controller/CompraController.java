package br.com.jajm.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jajm.loja.dto.CompraDTO;
import br.com.jajm.loja.service.CompraService;

@RestController
@RequestMapping(path = "/compras")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public void realizaCompra(@RequestBody CompraDTO compraDTO) {
		System.out.println(compraDTO.getEndereco().getEstado());
		
		compraService.realizaCompra(compraDTO);
	}

}
