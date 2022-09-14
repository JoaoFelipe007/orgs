package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;


    public ResponseEntity<Object> salvar(Vendedor vendedor) {
        try {
            Pessoa p = repository.saveAndFlush(vendedor);
            return p != null ? ResponseEntity.ok().body(vendedor)
                    : (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Vendedor> result = repository.findAll();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Vendedor vendedor) {
        try {
            Optional<Vendedor> optional = repository.findById(vendedor.getId());
            if (optional.isPresent()) {
                Pessoa result = repository.saveAndFlush(vendedor);
                return ResponseEntity.ok().body(vendedor);
            }
            return (ResponseEntity<Object>) ResponseEntity.badRequest();
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Vendedor> optional = repository.findById(id);
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
            List<Vendedor> result = repository.listaSeForAtivo(id);
            if (!result.isEmpty()) {
                return ResponseEntity.ok().body(result);
            }
            return ResponseEntity.badRequest().body("Esse funcionario não está ativo");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);

        }
    }

}
