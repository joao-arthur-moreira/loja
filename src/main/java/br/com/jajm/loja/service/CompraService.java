package br.com.jajm.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.jajm.loja.dto.CompraDTO;
import br.com.jajm.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate restTemplate;

	public void realizaCompra(CompraDTO compraDTO) {
		String estado = compraDTO.getEndereco().getEstado();
		
		ResponseEntity<InfoFornecedorDTO> infoFornecedorDTO = 
				restTemplate.exchange("http://fornecedor:8081/info/" + estado, HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(infoFornecedorDTO.getBody().getEndereco());
		
	}

}
