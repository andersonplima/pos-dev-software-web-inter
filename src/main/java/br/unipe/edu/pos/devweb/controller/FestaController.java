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

import br.unipe.edu.pos.devweb.dto.FestaDto;
import br.unipe.edu.pos.devweb.model.Festa;
import br.unipe.edu.pos.devweb.service.FestaService;
import br.unipe.edu.pos.devweb.service.ModelMapperService;

@RestController
@RequestMapping("/api/festa")
public class FestaController {

	@Autowired
	private FestaService festaService;

	@Autowired
	private ModelMapperService modelMapperService;

	private FestaDto map(Festa festa) {
		return modelMapperService.getMapper().map(festa, FestaDto.class);
	}

	private Festa map(FestaDto festaDto) {
		return modelMapperService.getMapper().map(festaDto, Festa.class);
	}

	@GetMapping
	public List<FestaDto> getFestas() {
		return festaService.Retrieve()
				.stream()
				.map(festa -> map(festa))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/nome/{nome}")
	public List<FestaDto> getFestaByNome(@PathVariable String nome) {
		return festaService.retrieveFestaByNome(nome).stream().map(festa -> map(festa)).collect(Collectors.toList());
	}
	
	@GetMapping("/valor/between/{valorInicial}/{valorFinal}")
	public List<FestaDto> getFestaByNome(@PathVariable float valorInicial, @PathVariable float valorFinal) {
		return festaService.retrieveFestaByValorBetween(valorInicial, valorFinal)
				.stream()
				.map(festa -> map(festa))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public FestaDto getFestaById(@PathVariable Long id) {
		return map(festaService.RetrieveById(id));
	}

	@PostMapping
	public FestaDto salvar(@Valid @RequestBody FestaDto festa) {
		return map(festaService.Create(map(festa)));
	}

	@PutMapping
	public FestaDto atualizar(@Valid @RequestBody FestaDto festa) {
		if (festa.getId() == null)
			throw new NoSuchElementException();

		return map(festaService.Update(map(festa)));
	}

	@DeleteMapping("/{id}")
	public void deleteFestaById(@PathVariable Long id) {
		festaService.Delete(id);
	}
}
