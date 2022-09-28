package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Cliente;
import com.app.organizacao.teste.entity.Rota;
import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.repository.ClienteRepository;
import com.app.organizacao.teste.repository.RotaRepository;
import com.app.organizacao.teste.repository.VendedorRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;


    private boolean verify(List<String> messages, Cliente c, Boolean isUpdate) {
        if (isUpdate) {
            if (c.getId() == null) {
                messages.add("O id do cliente não pode ser null");
            } else {
                Optional<Cliente> find = repository.findById(c.getId());
                if (!find.isPresent()) {
                    messages.add("id não foi encontrado");
                }
            }

            if (c.getRota() == null) {
                messages.add("O id da rota não pode ser nulo");
            } else {
                Optional<Rota> r = rotaRepository.findById(c.getRota().getId());
                if (!r.isPresent()) {
                    messages.add("O id dessa rota não foi encontrada não foi encontrada");
                }
            }
        }

        if (c.getVendedor() == null) {
            messages.add("O id do vendedor não pode estar vazio");
        } else {
            Optional<Vendedor> find = vendedorRepository.findById(c.getVendedor().getId());
            if (!find.isPresent()) {
                messages.add("O id passado não existe");
            }
        }
        return messages.isEmpty();
    }


    public ResponseEntity<Object> salvar(Cliente cliente) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, cliente, false)) {
                Cliente result = repository.saveAndFlush(cliente);

                return ResponseEntity.status(200).body(ResponseUtil.response("Cliente cadastrado!", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));

        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Cliente cliente) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, cliente, true)) {
                Cliente result = repository.saveAndFlush(cliente);
                return ResponseEntity.status(200).body(ResponseUtil.response(messages, cliente));
            }
            return ResponseEntity.status(400).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarPorId(Long id) {
        try {
            Optional<Cliente> find = repository.findById(id);
            if (find.isPresent()) {
                return ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucesso", find.get()));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response("O id passado não foi encontrado", null));

        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }
    public ResponseEntity<Object> listarTodaOsClientes() {
        try {
            List<Cliente> result = repository.findAll();
            return result != null ? ResponseEntity.status(200).body(ResponseUtil.response("Listagem realizada com sucesso", result))
                    : ResponseEntity.status(400).body("Não foi possivel realizar a listagem");
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();

        }
    }

}
