package com.loja.roupas.controller;

import com.loja.roupas.model.Endereco;
import com.loja.roupas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // 1. Listar todos os endereços
    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    // 2. Buscar endereços por ID da Pessoa
    @GetMapping("/pessoa/{idPessoa}")
    public List<Endereco> buscarPorPessoa(@PathVariable Long idPessoa) {
        return enderecoRepository.findByPessoaIdPessoa(idPessoa);
    }

    // 3. Cadastrar novo endereço
    @PostMapping
    public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEndereco);
    }

    // 4. Atualizar endereço
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody Endereco enderecoAtualizado) {
        return enderecoRepository.findById(id)
                .map(end -> {
                    end.setCep(enderecoAtualizado.getCep());
                    end.setRua(enderecoAtualizado.getRua());
                    end.setNumero(enderecoAtualizado.getNumero());
                    end.setComplemento(enderecoAtualizado.getComplemento());
                    end.setBairro(enderecoAtualizado.getBairro());
                    end.setCidade(enderecoAtualizado.getCidade());
                    end.setEstado(enderecoAtualizado.getEstado());
                    end.setTipoEndereco(enderecoAtualizado.getTipoEndereco());
                    Endereco salvo = enderecoRepository.save(end);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Deletar endereço
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}