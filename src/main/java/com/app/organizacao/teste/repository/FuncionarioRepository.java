package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    @Query(value = "select * from funcionario where idfuncionario = ?1",nativeQuery = true)
    Funcionario findByFuncionario(Long id);

    @Query("select f from Funcionario f where f.id=?1 and f.ativo = true")
    List<Funcionario> listaSeForAtivo(Long id);
}
