package com.Attornatusapi.GerenciaDePessoas.Service;

import com.Attornatusapi.GerenciaDePessoas.Model.Pessoa;
import com.Attornatusapi.GerenciaDePessoas.Repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa consultarPessoaPeloCodigo(Long codigo) {
        return pessoaRepository.findById(codigo).orElseThrow(( ) -> new EmptyResultDataAccessException(1));


    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizar(Long codigo, Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.findById(codigo).
                orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return this.pessoaRepository.save(pessoaSalva);
    }


    public void Remover(@PathVariable Pessoa codigo){
        pessoaRepository.delete(codigo);
    }
}
