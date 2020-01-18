package br.unipe.edu.pos.devweb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.edu.pos.devweb.dto.UsuarioDto;
import br.unipe.edu.pos.devweb.model.Usuario;
import br.unipe.edu.pos.devweb.service.ModelMapperService;
import br.unipe.edu.pos.devweb.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ModelMapperService modelMapperService;

	private UsuarioDto map(Usuario usuario) {
		return modelMapperService.getMapper().map(usuario, UsuarioDto.class);
	}

	private Usuario map(UsuarioDto usuarioDto) {
		return modelMapperService.getMapper().map(usuarioDto, Usuario.class);
	}

	@GetMapping
	public List<UsuarioDto> getUsuarios() {
		return usuarioService.Retrieve().stream().map(usuario -> map(usuario)).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public UsuarioDto getUsuarioById(@PathVariable Long id) {
		return map(usuarioService.RetrieveById(id));
	}

	@PostMapping
	public UsuarioDto salvar(@RequestBody UsuarioDto usuario) {
		return map(usuarioService.Create(map(usuario)));
	}

	@PutMapping
	public UsuarioDto atualizar(@RequestBody UsuarioDto usuario) {
		return map(usuarioService.Update(map(usuario)));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuarioById(@PathVariable Long id) {
		usuarioService.Delete(id);
	}

}
