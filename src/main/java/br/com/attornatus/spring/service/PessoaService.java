package br.com.attornatus.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.spring.dto.PessoaDTO;
import br.com.attornatus.spring.entity.Pessoa;
import br.com.attornatus.spring.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Pessoa> findAll() {
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		return listPessoa;
    }

    public PessoaDTO findByid(Long id) {

		boolean existe = pessoaRepository.existsById(id);
		if (existe == true) {
			Pessoa pessoa = pessoaRepository.getReferenceById(id);
			PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
			return pessoaDTO;
		}
		return new PessoaDTO();

	}

    public PessoaDTO save(PessoaDTO pessoaDTO) {

		try {
			Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
			 pessoaRepository.save(pessoa).getId();

			return pessoaDTO;

		} catch (Exception e) {
			return new PessoaDTO();
		}
	}

   
    public PessoaDTO update(PessoaDTO pessoaDto) {

		try {
			Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
			 pessoaRepository.save(pessoa).getId();
			return pessoaDto;
		} catch (Exception e) {
			return new PessoaDTO();
		}
	}

}
