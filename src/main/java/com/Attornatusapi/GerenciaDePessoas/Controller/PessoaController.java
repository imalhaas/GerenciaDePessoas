package com.Attornatusapi.GerenciaDePessoas.Controller;

import com.Attornatusapi.GerenciaDePessoas.Model.Pessoa;
import com.Attornatusapi.GerenciaDePessoas.Repository.PessoaRepository;
import com.Attornatusapi.GerenciaDePessoas.Service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> consultarPessoaPeloCodigo(@PathVariable Long codigo){
        Pessoa pessoa = pessoaService.consultarPessoaPeloCodigo(codigo);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @PutMapping("/{codigo}")
    public Pessoa editarPessoa(@PathVariable Long codigo,  @RequestBody Pessoa pessoa ){
          return pessoaService.atualizar(codigo, pessoa);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Pessoa codigo){
        pessoaService.Remover(codigo);
    }

}
