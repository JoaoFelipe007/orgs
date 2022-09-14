package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Financeiro;
import com.app.organizacao.teste.entity.Logistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro,Long> {
    @Query(value = "select * from financeiro where idfinanceiro = ?1",nativeQuery = true)
    Financeiro listByFinanceiroId(Long id);

    @Query("select f from Financeiro f where f.id=?1 and f.ativo = true")
    List<Financeiro> listaSeForAtivo(Long id);
}
