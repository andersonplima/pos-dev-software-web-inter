package br.unipe.edu.pos.devweb.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unipe.edu.pos.devweb.dto.ClienteDto;
import br.unipe.edu.pos.devweb.dto.FestaDto;
import br.unipe.edu.pos.devweb.dto.TipoFestaDto;
import br.unipe.edu.pos.devweb.dto.UsuarioDto;
import br.unipe.edu.pos.devweb.model.Cliente;
import br.unipe.edu.pos.devweb.model.Festa;
import br.unipe.edu.pos.devweb.model.TipoFesta;
import br.unipe.edu.pos.devweb.model.Usuario;

@Service
public class ModelMapperService {
	private ModelMapper modelMapper;
	public ModelMapperService() {
		modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Festa.class, FestaDto.class);
		modelMapper.createTypeMap(TipoFesta.class, TipoFestaDto.class);
		modelMapper.createTypeMap(Usuario.class, UsuarioDto.class);
		modelMapper.createTypeMap(Cliente.class, ClienteDto.class);
	}

	public ModelMapper getMapper() {
		return modelMapper;
	}
}
