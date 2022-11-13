package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Logistica;
import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.repository.LogisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogisticaService {

    private final LogisticaRepository repository;

    public LogisticaService(LogisticaRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Object> salvar(Logistica logistica) {
        try {
            Logistica p = repository.saveAndFlush(logistica);
            return p != null ? ResponseEntity.ok().body(logistica)
                    : (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Logistica> result = repository.findAll();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Logistica logistica) {
        try {
            Optional<Logistica> optional = repository.findById(logistica.getId());
            if (optional.isPresent()) {
                Pessoa result = repository.saveAndFlush(logistica);
                return ResponseEntity.ok().body(logistica);
            }
            return (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Logistica> optional = repository.findById(id);
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
            List<Logistica> result = repository.listaSeForAtivo(id);
            if (!result.isEmpty()) {
                return ResponseEntity.ok().body(result);
            }
            return ResponseEntity.badRequest().body("Esse funcionario não está ativo");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);

        }
    }
}
