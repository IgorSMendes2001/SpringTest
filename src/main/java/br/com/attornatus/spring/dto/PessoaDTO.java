package br.com.attornatus.spring.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.attornatus.spring.entity.Pessoa;

public class PessoaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotBlank @Length(min=5) 
    private String nome;
    private LocalDate dataNascimento;
    @JsonProperty("endereco")
    private List<EnderecoDTO> endereco;

    public PessoaDTO(Pessoa pessoa){
        this.nome=pessoa.getNome();
        this.dataNascimento=pessoa.getDataNascimento();
    }

    public PessoaDTO(@NotBlank @Length(min = 5) String nome, LocalDate dataNascimento,
            @NotBlank @Length(min = 10) List<EnderecoDTO> endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    public PessoaDTO() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public List<EnderecoDTO> getEndereco() {
        return endereco;
    }
    public void setEndereco(List<EnderecoDTO> endereco) {
        this.endereco = endereco;
    }

    public static ResponseEntity<PessoaDTO> converter(List<Pessoa> pessoas) {
        return null;
    }

    
}
