package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Financeiro;
import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.repository.FinanceiroRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceiroService {

    @Autowired
    private FinanceiroRepository repository;

    private boolean verify(List<String> messages, Financeiro finan, Boolean isUpdate) {
        if (isUpdate) {
            if (finan.getId() == null) {
                messages.add("O id do vendedor não pode ser nulo");
            } else {
                Optional<Financeiro> find = repository.findById(finan.getId());
                if (!find.isPresent()) {
                    messages.add("id não foi encontrado");
                }
            }

        }
        if (finan.getCpf() == null) {
            messages.add("O cpf precisar sem passado");
        }
        if (finan.getDataNascimento() == null) {
            messages.add("A data de nascimento precisa ser passada");
        }
        return messages.isEmpty();
    }

    public ResponseEntity<Object> salvar(Financeiro financeiro) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, financeiro, false)) {
                Pessoa p = repository.saveAndFlush(financeiro);
                return ResponseEntity.status(200).body(ResponseUtil.response("Funcionario da Parte do financeiro salvo com sucesso", p));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarTodos() {
        try {
            List<Financeiro> result = repository.findAll();
            return !result.isEmpty()? ResponseEntity.status(200).body(ResponseUtil.response("Funcionarios do Funcionario Listados com sucesso", result)):
                    ResponseEntity.status(404).body(ResponseUtil.response("Não foi encontrado nenhum funcionario do financeiro",null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> editar(Financeiro financeiro) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, financeiro, true)) {
                Pessoa result = repository.saveAndFlush(financeiro);
                return ResponseEntity.status(200).body(ResponseUtil.response("Funcionario da Parte do financeiro salvo com sucesso", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> excluir(Long id) {
        try {
            Optional<Financeiro> optional = repository.findById(id);
            if (optional.isPresent()) {
                repository.deleteById(optional.get().getId());
                return ResponseEntity.status(200).body("excluido ocm sucesso");
            }
            return ResponseEntity.status(404).body("Id não encontrado para realizar o processo");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarAtivos() {
        try {
            List<Financeiro> result = repository.listaSeForAtivo();
                return !result.isEmpty()? ResponseEntity.status(200).body(ResponseUtil.response("Listado com Sucesso", result)):
                ResponseEntity.status(404).body(ResponseUtil.response("No momento não tem funcionarios ativos para a listagem", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);

        }
    }
}
