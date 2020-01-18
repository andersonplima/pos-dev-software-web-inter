package br.unipe.edu.pos.devweb.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.edu.pos.devweb.dto.ClienteDto;
import br.unipe.edu.pos.devweb.model.Cliente;
import br.unipe.edu.pos.devweb.service.ClienteService;
import br.unipe.edu.pos.devweb.service.ModelMapperService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	private ClienteDto map(Cliente cliente) {
		return modelMapperService.getMapper().map(cliente, ClienteDto.class);
	}

	private Cliente map(ClienteDto clienteDto) {
		return modelMapperService.getMapper().map(clienteDto, Cliente.class);
	}

	@GetMapping
	public List<ClienteDto> getClientes() {
		return clienteService.Retrieve()
				.stream()
				.map(cliente -> map(cliente))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ClienteDto getClienteById(@PathVariable Long id) {
		return map(clienteService.RetrieveById(id));
	}

	@PostMapping
	public ClienteDto salvar(@Valid @RequestBody ClienteDto cliente) {
		return map(clienteService.Create(map(cliente)));
	}
	
	@PutMapping
	public ClienteDto atualizar(@Valid @RequestBody ClienteDto cliente) {
		if (cliente.getId() == null)
			throw new NoSuchElementException();

		return map(clienteService.Update(map(cliente)));
	}

	@DeleteMapping("/{id}")
	public void deleteClienteById(@PathVariable Long id) {
		clienteService.Delete(id);
	}
}
