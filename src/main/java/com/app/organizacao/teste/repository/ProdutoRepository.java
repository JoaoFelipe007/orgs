package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query("select p from Produto p where p.ativo = true")
    List<Produto> listPorAtivo();

}
