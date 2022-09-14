package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Logistica;
import com.app.organizacao.teste.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogisticaRepository extends JpaRepository<Logistica,Long> {
    @Query(value = "select * from logistica where idlogistica = ?1",nativeQuery = true)
    Logistica listByLogisticaId(Long id);

    @Query("select l from Logistica l where l.id=?1 and l.ativo = true")
    List<Logistica> listaSeForAtivo(Long id);

}
