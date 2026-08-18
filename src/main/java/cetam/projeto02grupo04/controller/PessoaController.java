package com.loja.roupas.controller;

import com.loja.roupas.model.Pessoa;
import com.loja.roupas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // 1. Listar todas as pessoas (Clientes, Funcionários, Fornecedores)
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    // 2. Buscar pessoa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Cadastrar nova pessoa
    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    // 4. Atualizar pessoa existente
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaAtualizada.getNome());
                    pessoa.setEmail(pessoaAtualizada.getEmail());
                    pessoa.setTelefone(pessoaAtualizada.getTelefone());
                    pessoa.setTipoPessoa(pessoaAtualizada.getTipoPessoa());
                    Pessoa atualizado = pessoaRepository.save(pessoa);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Deletar pessoa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}