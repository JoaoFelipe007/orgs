package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Produto;
import com.app.organizacao.teste.repository.ProdutoRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    private Boolean isVerify(List<String> messages, Produto produto, Boolean isUpdate) {
        if (isUpdate) {
            if (produto.getId() == null) {
                messages.add("O id não pode ser nulo");
            } else {
                if (!repository.findById(produto.getId()).isPresent()) {
                    messages.add("O id não foi encontrado");
                }
            }
        }
        if (produto.getNome() == null) {
            messages.add("O nome do produto não pode ser nulo");
        }
        if (produto.getMarca() == null) {
            messages.add("A marca do produto não pode ser nula");
        }

        if (produto.getAtivo() == null) {
            messages.add("O campo ativo não pode ser nulo");
        }

        if (produto.getValidade() == null) {
            messages.add("A validade do produto não poder nula");
        }

        return messages.isEmpty();
    }

    public ResponseEntity<Object> salvar(Produto produto) {
        List<String> messages = new ArrayList<>();
        try {
            if (isVerify(messages, produto, false)) {
                Produto result = repository.saveAndFlush(produto);
                return ResponseEntity.status(200).body(ResponseUtil.response("Prodouto salvo com sucesso", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> editar(Produto produto) {
        List<String> messages = new ArrayList<>();
        try {
            if (isVerify(messages, produto, true)) {
                Produto result = repository.saveAndFlush(produto);
                return ResponseEntity.status(200).body(ResponseUtil.response("Prodouto salvo com sucesso", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarPorId(Long id) {
        try {
            Optional<Produto> find = repository.findById(id);
            if (find.isPresent()) {
                return ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucesso", find));
            }
            return ResponseEntity.status(404).body("Não existe nenhum produto com esse id");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarPorAtivo() {
        try {
            List<Produto> find = repository.listPorAtivo();
            return !find.isEmpty() ? ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucesso", find))
                    : ResponseEntity.status(404).body("Não existe nenhum produto com esse id");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }


}
