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

import br.unipe.edu.pos.devweb.dto.TipoFestaDto;
import br.unipe.edu.pos.devweb.model.TipoFesta;
import br.unipe.edu.pos.devweb.service.ModelMapperService;
import br.unipe.edu.pos.devweb.service.TipoFestaService;

@RestController
@RequestMapping("/api/tipofesta")
public class TipoFestaController {
	@Autowired
	private TipoFestaService tipoFestaService;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	private TipoFestaDto map(TipoFesta tipoFesta) {
		return modelMapperService.getMapper().map(tipoFesta, TipoFestaDto.class);
	}

	private TipoFesta map(TipoFestaDto tipoFestaDto) {
		return modelMapperService.getMapper().map(tipoFestaDto, TipoFesta.class);
	}

	@GetMapping
	public List<TipoFestaDto> getTiposFesta() {
		return tipoFestaService.Retrieve()
				.stream()
				.map(tipoFesta -> map(tipoFesta))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public TipoFestaDto getTipoFestaById(@PathVariable Short id) {
		return map(tipoFestaService.RetrieveById(id));
	}

	@PostMapping
	public TipoFestaDto salvar(@Valid @RequestBody TipoFestaDto tipoFesta) {
		return map(tipoFestaService.Create(map(tipoFesta)));
	}
	
	@PutMapping
	public TipoFestaDto atualizar(@Valid @RequestBody TipoFestaDto tipoFesta) {
		if (tipoFesta.getId() == null)
			throw new NoSuchElementException();

		return map(tipoFestaService.Update(map(tipoFesta)));
	}

	@DeleteMapping("/{id}")
	public void deleteTipoFestaById(@PathVariable Short id) {
		tipoFestaService.Delete(id);
	}
}
