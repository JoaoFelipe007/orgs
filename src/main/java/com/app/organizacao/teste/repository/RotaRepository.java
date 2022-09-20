package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota,Long> {
}
