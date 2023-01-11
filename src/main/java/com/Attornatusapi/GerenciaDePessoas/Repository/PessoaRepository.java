package com.Attornatusapi.GerenciaDePessoas.Repository;

import com.Attornatusapi.GerenciaDePessoas.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
