package com.Attornatusapi.GerenciaDePessoas.Controller;

import com.Attornatusapi.GerenciaDePessoas.Model.Endereco;
import com.Attornatusapi.GerenciaDePessoas.Repository.EnderecoRepository;
import com.Attornatusapi.GerenciaDePessoas.Service.EnderecoService;
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
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listar(){
        return enderecoService.listar();
    }
    @GetMapping("/{pessoaId}")
    public List<Endereco> listarPorPessoa(@PathVariable(value = "pessoaId")Long pessoaId){
        return enderecoService.listarPorPessoa(pessoaId);
    }

    @PostMapping
    public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco, HttpServletResponse response){
        Endereco enderecoCriado = enderecoService.salvarEnd(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCriado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Endereco codigo){
        enderecoService.remover(codigo);
    }


}
