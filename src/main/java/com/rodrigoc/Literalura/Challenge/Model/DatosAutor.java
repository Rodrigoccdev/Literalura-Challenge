package com.rodrigoc.Literalura.Challenge.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int anioDeNacimiento,
        @JsonAlias("death_year") int anioDeMuerte
) {
}
