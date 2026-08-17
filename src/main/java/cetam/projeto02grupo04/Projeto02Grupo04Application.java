package cetam.projeto02grupo04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projeto02Grupo04Application {

    public static void main(String[] args) {
        // Esta linha vai imprimir no console a versão real do Java em execução:
        System.out.println(">>> VERSÃO DO JAVA EM EXECUÇÃO: " + System.getProperty("java.version"));

        SpringApplication.run(Projeto02Grupo04Application.class, args);
    }
}