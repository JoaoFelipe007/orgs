package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota,Long> {

    @Query("select r from Rota r inner join r.cliente cl where cl.id = ?1")
    Rota listByClienteId(Long id);
}
