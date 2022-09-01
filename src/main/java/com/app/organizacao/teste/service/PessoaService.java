package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public ResponseEntity<Object> salvar(Pessoa pessoa) {
        try {
            Pessoa p = repository.saveAndFlush(pessoa);
            return p != null ? ResponseEntity.ok().body(pessoa)
                    : (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Pessoa> result = repository.findAll();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Pessoa pessoa) {
        try {
            Optional<Pessoa> optional = repository.findById(pessoa.getId());
            if (optional.isPresent()) {
                Pessoa result = repository.saveAndFlush(pessoa);
                return ResponseEntity.ok().body(pessoa);
            }
            return (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Pessoa> optional = repository.findById(id);
            if (optional.isPresent()) {
                repository.deleteById(optional.get().getId());
                return ResponseEntity.ok().body("excluido ocm sucesso");
            }
            return ResponseEntity.badRequest().body("Id não encontrado");
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e);
        }
    }

}
