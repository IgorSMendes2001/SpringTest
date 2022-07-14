package br.com.attornatus.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.spring.dto.EnderecoDTO;
import br.com.attornatus.spring.entity.Endereco;
import br.com.attornatus.spring.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Endereco> findAll() {

		List<Endereco> listEndereco = enderecoRepository.findAll();

		return listEndereco;
    }

    public EnderecoDTO findByid(Long id) {

		boolean existe = enderecoRepository.existsById(id);
		if (existe == true) {
			Endereco endereco = enderecoRepository.getReferenceById(id);
			EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
			return enderecoDTO;
		}
		return new EnderecoDTO();

	}

    public EnderecoDTO save(EnderecoDTO enderecoDTO) {

		try {
			Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
			enderecoRepository.save(endereco).getId();
			return enderecoDTO;
		} catch (Exception e) {
			return new EnderecoDTO();
		}
	}

   
    public EnderecoDTO update(EnderecoDTO enderecoDTO) {

		try {
			Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
			 enderecoRepository.save(endereco).getId();
			return enderecoDTO;
		} catch (Exception e) {
			return new EnderecoDTO();
		}
	}

}
