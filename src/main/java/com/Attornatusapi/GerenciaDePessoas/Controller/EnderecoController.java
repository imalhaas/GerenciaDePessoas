package com.Attornatusapi.GerenciaDePessoas.Controller;

import com.Attornatusapi.GerenciaDePessoas.Model.Endereco;
import com.Attornatusapi.GerenciaDePessoas.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listar(){
        return enderecoRepository.findAll();
    }

    
}
