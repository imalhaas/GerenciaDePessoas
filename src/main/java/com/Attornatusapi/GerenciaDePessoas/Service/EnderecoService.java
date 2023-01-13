package com.Attornatusapi.GerenciaDePessoas.Service;

import com.Attornatusapi.GerenciaDePessoas.Model.Endereco;
import com.Attornatusapi.GerenciaDePessoas.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listar(){
        return enderecoRepository.findAll();
    }

    public List<Endereco> listarPorPessoa(@PathVariable(value = "pessoaId")Long pessoaId) {
        return enderecoRepository.findAllByPessoaId(pessoaId);
    }

    public Endereco salvarEnd(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void remover(@PathVariable Endereco codigo){
        enderecoRepository.delete(codigo);
    }

}
