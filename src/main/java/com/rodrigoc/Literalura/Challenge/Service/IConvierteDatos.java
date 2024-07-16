package com.rodrigoc.Literalura.Challenge.Service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
