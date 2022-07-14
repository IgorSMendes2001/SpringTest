package br.com.attornatus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.spring.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
    
}
