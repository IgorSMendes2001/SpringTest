package br.com.attornatus.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.spring.dto.EnderecoDTO;
import br.com.attornatus.spring.dto.PessoaDTO;
import br.com.attornatus.spring.entity.Endereco;
import br.com.attornatus.spring.entity.Pessoa;
import br.com.attornatus.spring.service.EnderecoService;
import br.com.attornatus.spring.service.PessoaService;
@RequestMapping(value = "/pessoa")
@RestController
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
	@Autowired
    private EnderecoService enderecoService;
	@GetMapping
    public List<Pessoa> findAll( ) {

		List<Pessoa> listPessoa= pessoaService.findAll();

		return listPessoa;
	}
	

    @GetMapping(path = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {

		PessoaDTO listPessoaDto = pessoaService.findByid(id);
		return ResponseEntity.ok(listPessoaDto);
	}

    @PostMapping
	public ResponseEntity<PessoaDTO> save(@Valid @RequestBody PessoaDTO pessoaDto) {

		pessoaDto = pessoaService.save(pessoaDto);	
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);		
	}

   

    @PutMapping
	public ResponseEntity<PessoaDTO> update(@Valid @RequestBody PessoaDTO pessoaDto) {

		pessoaDto = pessoaService.update(pessoaDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);		
	}

	@GetMapping("/endereco")
    public List<Endereco> findBEnderecos( ) {

		List<Endereco> listEndereco= enderecoService.findAll();

		return listEndereco;
	}

	@PostMapping("/endereco/{id}")
	public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO enderecoDTO,@PathVariable Long id) {
		enderecoDTO = enderecoService.save(enderecoDTO);	
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoDTO);		
	}
  



}
