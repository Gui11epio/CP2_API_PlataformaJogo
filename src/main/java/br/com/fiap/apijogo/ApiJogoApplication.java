package br.com.fiap.apijogo;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/swagger-ui/index.html#/

@OpenAPIDefinition(
		info = @Info(
				title = "CP2 - API",
				version = "1.0",
				description = "Documentação da API para gerenciamento de jogos e plataformas"
		)
)


@SpringBootApplication
public class ApiJogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJogoApplication.class, args);
	}

}
