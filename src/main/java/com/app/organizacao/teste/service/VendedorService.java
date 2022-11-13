package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.repository.VendedorRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    private final VendedorRepository repository;

    public VendedorService(VendedorRepository repository) {
        this.repository = repository;
    }

    private boolean verify(List<String> messages, Vendedor vendedor, Boolean isUpdate) {
        if (isUpdate) {
            if (vendedor.getId() == null) {
                messages.add("O id do vendedor não pode ser nulo");
            } else {
                Optional<Vendedor> find = repository.findById(vendedor.getId());
                if (!find.isPresent()) {
                    messages.add("id não foi encontrado");
                }
            }

        }
        if (vendedor.getCpf() == null) {
            messages.add("O cpf precisar sem passado");
        }
        if (vendedor.getDataNascimento() == null) {
            messages.add("A data de nascimento precisa ser passada");
        }

        if (vendedor.getSalario() == null) {
            messages.add("O salario tem que ser informado");
        }

        if (vendedor.getTipoVendedor() == null) {
            messages.add("O tipo de vendedor tem que informado");
        }
        return messages.isEmpty();
    }

    public ResponseEntity<Object> salvar(Vendedor vendedor) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, vendedor, false)) {
                Vendedor v = repository.saveAndFlush(vendedor);
                return ResponseEntity.status(200).body(ResponseUtil.response("Vendedor salvo com sucesso", v));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(null, messages));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Vendedor> result = repository.findAll();
            return !result.isEmpty() ? ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucesso", result))
                    : ResponseEntity.status(404).body(ResponseUtil.response("Não ha nada para ser listado", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> editar(Vendedor vendedor) {
        List<String> messages = new ArrayList<>();
        try {
            Optional<Vendedor> optional = repository.findById(vendedor.getId());
            if (verify(messages, vendedor, Boolean.TRUE)) {
                Pessoa result = repository.saveAndFlush(vendedor);
                return ResponseEntity.status(200).body(ResponseUtil.response("Salvo com sucesso", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response("O id passado não existe", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Vendedor> optional = repository.findById(id);
            if (optional.isPresent()) {
                repository.deleteById(optional.get().getId());
                return ResponseEntity.status(200).body(ResponseUtil.response("Excluido com sucesso", null));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response("O id passado não existe", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarAtivos() {
        try {
            List<Vendedor> result = repository.listaSeForAtivo();

            return !result.isEmpty() ? ResponseEntity.status(200).body(ResponseUtil.response("Listados com sucesso", result))
                    : ResponseEntity.status(404).body(ResponseUtil.response("O id passado não existe", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);

        }
    }

}
