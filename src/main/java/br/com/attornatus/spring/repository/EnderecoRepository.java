package br.com.attornatus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.spring.entity.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
    
}
