package com.loja.roupas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "pessoa")
    @Data
    public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pessoa")
        private Long idPessoa;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_pessoa", nullable = false)
        private TipoPessoa tipoPessoa;

        @Column(nullable = false, length = 100)
        private String nome;

        @Column(nullable = false, unique = true, length = 100)
        private String email;

        @Column(nullable = false)
        private String senha;

        @Column(name = "cpf_cnpj", unique = true, length = 18)
        private String cpfCnpj;

        private String telefone;

        @Column(name = "data_cadastro", insertable = false, updatable = false)
        private LocalDateTime dataCadastro;

        public enum TipoPessoa {
            Cliente, Funcionario, Fornecedor
        }
    }


