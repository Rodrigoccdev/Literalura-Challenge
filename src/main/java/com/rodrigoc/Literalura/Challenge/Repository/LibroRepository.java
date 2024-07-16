package com.rodrigoc.Literalura.Challenge.Repository;
import com.rodrigoc.Literalura.Challenge.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}

