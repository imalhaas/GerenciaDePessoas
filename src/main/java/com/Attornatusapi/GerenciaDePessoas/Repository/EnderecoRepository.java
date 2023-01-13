package com.Attornatusapi.GerenciaDePessoas.Repository;

import com.Attornatusapi.GerenciaDePessoas.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "select * from tb_enderecos  WHERE pessoa_codigo = :pessoaId", nativeQuery = true)
    List<Endereco> findAllByPessoaId(@Param("pessoaId") Long pessoaId);

}
