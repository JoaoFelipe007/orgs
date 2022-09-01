package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    @Query(value = "select * from pessoa where idpessoa = ?1",nativeQuery = true)
    Pessoa findByPessoa(Long id);
}
