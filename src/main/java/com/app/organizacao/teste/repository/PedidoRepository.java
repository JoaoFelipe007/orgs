package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    @Query("select p from Pedido p where p.pago =false")
    List<Pedido> listPorPago();
}
