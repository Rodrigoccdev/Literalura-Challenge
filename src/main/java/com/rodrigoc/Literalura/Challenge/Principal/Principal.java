package com.rodrigoc.Literalura.Challenge.Principal;

import com.rodrigoc.Literalura.Challenge.Model.Autor;
import com.rodrigoc.Literalura.Challenge.Model.Datos;
import com.rodrigoc.Literalura.Challenge.Model.DatosLibro;
import com.rodrigoc.Literalura.Challenge.Model.Libro;
import com.rodrigoc.Literalura.Challenge.Repository.LibroRepository;
import com.rodrigoc.Literalura.Challenge.Service.ConsumoAPI;
import com.rodrigoc.Literalura.Challenge.Service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner in = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;

    private List<Libro> libros;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void muestraMenu(){
        var option = -1;
        while (option!=0){
            var menu = """
                    1.-Buscar Libro por Titulo
                    2.-Libros Registrados
                    3.-Autores Registrados
                    4.-Autores vivos en Determinado Año
                    5.-Libros por Determinado Idioma
                    """;
            System.out.println(menu);
            option = in.nextInt();
            in.nextLine();

            switch (option){
                case 1:
                    buscarLibro(); break;
                case 2:
                    mostarLibrosRegistrados(); break;
                case 3:
                    mostarAutoresRegistrados(); break;
                case 4:
                    buscarAutorPorAnio(); break;
                case 5:
                    buscarLibroPorIdioma(); break;
                case 0:
                    System.out.println("Saliendo del programa.....");
            }
        }
    }

    private void buscarLibro() {
        System.out.println("Ingrese el titulo del libro deseado: ");
        var tituloLibro = in.nextLine();
        var url = URL+"?search="+tituloLibro.replace(" ","+");
        System.out.println(url);
        var json = consumoAPI.obtenerDatos(url);
        System.out.println(json);
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroDeseado = datosBusqueda.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroDeseado.isPresent()){
            System.out.println("!Libro Encontrado!");
            System.out.println(libroDeseado.get());
        }else{
            System.out.println("Libro No Encontrado :(");
        }
        Libro libro = new Libro(libroDeseado.get());
        repositorio.save(libro);
    }

    private void mostarLibrosRegistrados(){

    }

    private void mostarAutoresRegistrados(){

    }

    private void buscarAutorPorAnio(){

    }

    private void buscarLibroPorIdioma(){

    }


}
