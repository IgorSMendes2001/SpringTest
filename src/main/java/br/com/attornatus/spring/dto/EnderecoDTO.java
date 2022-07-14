package br.com.attornatus.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.attornatus.spring.entity.Endereco;

public class EnderecoDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotBlank @Length(min=5) 
    private String logradouro;
    @NotBlank @Length(min=8) 
    private String cep;
    @NotBlank @Length(min=1) 
    private String numero;
    @NotBlank @Length(min=10) 
    private String cidade;

   
   
    public EnderecoDTO(@NotBlank @Length(min = 5) String logradouro, @NotBlank @Length(min = 8) String cep,
            @NotBlank @Length(min = 1) String numero, @NotBlank @Length(min = 10) String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }
    public EnderecoDTO(Endereco endereco){
        this.logradouro=endereco.getLogradouro();
        this.cep=endereco.getCep();
        this.numero=endereco.getNumero();
        this.cidade=endereco.getCidade();
    }
    public EnderecoDTO() {
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}
