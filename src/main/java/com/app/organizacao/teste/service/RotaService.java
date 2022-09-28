package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Rota;
import com.app.organizacao.teste.repository.ClienteRepository;
import com.app.organizacao.teste.repository.RotaRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


/*
 * João Felipe
 */
@Service
public class RotaService {

    @Autowired
    private RotaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<Object> salvar(Rota rota) {
        try {
            if (rota.getCliente().getId() != null) {
                if (clienteRepository.findById(rota.getCliente().getId()).isPresent()) {
                    Rota result = repository.saveAndFlush(rota);
                    return ResponseEntity.status(200).body(ResponseUtil.response("Rota salva com sucesso", result));
                }
                String message = String.format("O idcliente  %d passado não existe", rota.getCliente().getId());
                return ResponseEntity.status(404).body(ResponseUtil.response(message, null));
            }
            return ResponseEntity.status(406).body(ResponseUtil.response("O id não pode ser nulo ou vazio", null));
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> editar(Rota rota) {
        try {
            if (rota.getId() != null) {
                if (repository.findById(rota.getId()).isPresent()) {
                    Rota result = repository.saveAndFlush(rota);
                    return ResponseEntity.status(200).body(ResponseUtil.response("Rota salva com sucesso", result));
                }
                String message = String.format("O id %d passado não existe", rota.getCliente().getId());
                return ResponseEntity.status(404).body(ResponseUtil.response(message, null));
            }
            return ResponseEntity.status(406).body(ResponseUtil.response("O id não pode ser nulo ou vazio", null));
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listaPorIdCliente(Long id) {
        try {
            Rota rota = repository.listByClienteId(id);
            if (rota == null) {
                return ResponseEntity.status(404).body(ResponseUtil.response("O id do cliente nãp existe", null));
            }

            return ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucesso", rota));
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();
        }
    }

    public ResponseEntity<Object> listarTodaAsRotas() {
        try {
            List<Rota> result = repository.findAll();
            return result != null ? ResponseEntity.status(200).body(ResponseUtil.response("Listagem realizada com sucesso", result))
                    : ResponseEntity.status(400).body("Não foi possivel realizar a listagem");
        } catch (Exception e) {
            return (ResponseEntity<Object>) ResponseEntity.internalServerError();

        }
    }
}
