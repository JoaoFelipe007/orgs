package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
    @Query(value = "select * from funcionario where idfuncionario = ?1",nativeQuery = true)
    Vendedor findByFuncionario(Long id);

    @Query("select f from Vendedor f where f.id=?1 and f.ativo = true")
    List<Vendedor> listaSeForAtivo(Long id);
}