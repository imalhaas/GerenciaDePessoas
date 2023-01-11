package com.Attornatusapi.GerenciaDePessoas.Controller;

import com.Attornatusapi.GerenciaDePessoas.Model.Endereco;
import com.Attornatusapi.GerenciaDePessoas.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco, HttpServletResponse response){
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
    }

}
