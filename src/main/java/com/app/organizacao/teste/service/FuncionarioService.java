package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Funcionario;
import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;


    public ResponseEntity<Object> salvar(Funcionario funcionario) {
        try {
            Pessoa p = repository.saveAndFlush(funcionario);
            return p != null ? ResponseEntity.ok().body(funcionario)
                    : (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Funcionario> result = repository.findAll();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Funcionario funcionario) {
        try {
            Optional<Funcionario> optional = repository.findById(funcionario.getId());
            if (optional.isPresent()) {
                Pessoa result = repository.saveAndFlush(funcionario);
                return ResponseEntity.ok().body(funcionario);
            }
            return (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Funcionario> optional = repository.findById(id);
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
            List<Funcionario> result = repository.listaSeForAtivo(id);
            if (!result.isEmpty()) {
                return ResponseEntity.ok().body(result);
            }
            return ResponseEntity.badRequest().body("Esse funcionario não está ativo");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);

        }
    }

}
