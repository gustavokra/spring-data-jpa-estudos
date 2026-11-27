package com.kraemer.liberyapi.repository;


import com.kraemer.liberyapi.model.Autor;
import com.kraemer.liberyapi.model.GeneroLivro;
import com.kraemer.liberyapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest() {
        Livro livro = new Livro();
        livro.setIsbn("009012-0129192");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = autorRepository
                .findById(UUID.fromString("b808e1bb-1357-4e65-ba58-11aecbe6b3a9"))
                .orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }

}