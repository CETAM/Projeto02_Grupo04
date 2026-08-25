package cetam.projeto02grupo04.services;

public class PessoaServices {
    @Service
    public static class PessoaService {

        private final PessoaRepository pessoaRepository;

        public PessoaService(PessoaRepository pessoaRepository) {
            this.pessoaRepository = pessoaRepository;
        }

        // Listar todas as pessoas
        public List<Pessoa> listarTodas() {
            return pessoaRepository.findAll();
        }

        // Listar pessoas por tipo
        public List<Pessoa> listarPorTipo(String tipo) {
            return pessoaRepository.findByTipoIgnoreCase(tipo);
        }

        // Buscar pessoa por ID
        public Optional<Pessoa> buscarPorId(Long id) {
            return pessoaRepository.findById(id);
        }

        // Cadastrar pessoa
        public Pessoa cadastrar(Pessoa pessoa) {

            pessoa.setId(null);

            if (!tipoValido(pessoa.getTipo())) {
                throw new IllegalArgumentException(
                        "Tipo de pessoa inválido. Use: Cliente, Fornecedor ou Funcionario."
                );
            }

            pessoa.setTipo(tipoNormalizado(pessoa.getTipo()));

            return pessoaRepository.save(pessoa);
        }

        // Atualizar pessoa
        public Optional<Pessoa> atualizar(Long id, Pessoa dados) {

            if (!tipoValido(dados.getTipo())) {
                throw new IllegalArgumentException(
                        "Tipo de pessoa inválido. Use: Cliente, Fornecedor ou Funcionario."
                );
            }

            return pessoaRepository.findById(id)
                    .map(pessoa -> {

                        pessoa.setTipo(tipoNormalizado(dados.getTipo()));
                        pessoa.setNome(dados.getNome());
                        pessoa.setEmail(dados.getEmail());
                        pessoa.setSenha(dados.getSenha());
                        pessoa.setCpfCnpj(dados.getCpfCnpj());
                        pessoa.setTelefone(dados.getTelefone());

                        return pessoaRepository.save(pessoa);
                    });
        }

        // Excluir pessoa
        public boolean excluir(Long id) {

            if (!pessoaRepository.existsById(id)) {
                return false;
            }

            pessoaRepository.deleteById(id);
            return true;
        }

        // Validar tipo de pessoa
        private boolean tipoValido(String tipo) {

            if (tipo == null) {
                return false;
            }

            return tipo.equalsIgnoreCase("Cliente")
                    || tipo.equalsIgnoreCase("Fornecedor")
                    || tipo.equalsIgnoreCase("Funcionario")
                    || tipo.equalsIgnoreCase("Funcionário");
        }

        // Padronizar o tipo
        private String tipoNormalizado(String tipo) {

            if (tipo.equalsIgnoreCase("Cliente")) {
                return "Cliente";
            }

            if (tipo.equalsIgnoreCase("Fornecedor")) {
                return "Fornecedor";
            }

            if (tipo.equalsIgnoreCase("Funcionario")
                    || tipo.equalsIgnoreCase("Funcionário")) {
                return "Funcionario";
            }

            return tipo;
        }
    }
}


    

