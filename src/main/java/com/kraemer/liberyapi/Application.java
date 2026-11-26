package com.kraemer.liberyapi;

import com.kraemer.liberyapi.model.Autor;
import com.kraemer.liberyapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
		AutorRepository repository = context.getBean(AutorRepository.class);

		exemploSalvarRegistro(repository);
	}

	public static void exemploSalvarRegistro(AutorRepository autorRepository) {
    	Autor autor = new Autor();

		autor.setNome("José");
		autor.setNacionalidade("Brasileira");
		autor.setDataNascimento(LocalDate.of(1950, 1, 31));

		Autor autorSalvo = autorRepository.save(autor);

		System.out.println("Autor Salvo: " + autorSalvo);
	}
}
