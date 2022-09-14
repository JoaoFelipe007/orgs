package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Financeiro;
import com.app.organizacao.teste.entity.Logistica;
import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceiroService {
    @Autowired
    private FinanceiroRepository repository;


    public ResponseEntity<Object> salvar(Financeiro financeiro) {
        try {
            Pessoa p = repository.saveAndFlush(financeiro);
            return p != null ? ResponseEntity.ok().body(financeiro)
                    : (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Financeiro> result = repository.findAll();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Financeiro financeiro) {
        try {
            Optional<Financeiro> optional = repository.findById(financeiro.getId());
            if (optional.isPresent()) {
                Pessoa result = repository.saveAndFlush(financeiro);
                return ResponseEntity.ok().body(financeiro);
            }
            return (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Financeiro> optional = repository.findById(id);
            if (optional.isPresent()) {
                repository.deleteById(optional.get().getId());
                return ResponseEntity.ok().body("excluido ocm sucesso");
            }
            return ResponseEntity.badRequest().body("Id não encontrado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    public ResponseEntity<Object> listarAtivos(Long id) {
        try {
            List<Financeiro> result = repository.listaSeForAtivo(id);
            if (!result.isEmpty()) {
                return ResponseEntity.ok().body(result);
            }
            return ResponseEntity.badRequest().body("Esse funcionario não está ativo");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);

        }
    }
}
