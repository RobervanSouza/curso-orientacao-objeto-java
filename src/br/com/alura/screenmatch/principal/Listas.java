package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Listas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 2012);
        meuFilme.avalia(3);
        Filme outroFilme = new Filme("Avatar", 1989);
        meuFilme.avalia(6);
        var filmeRobervan = new Filme("peratas do caribe!!!", 2000);
        filmeRobervan.avalia(8);

        Serie lost = new Serie("Lost", 2000);




        ArrayList<Titulo> assistidos = new ArrayList<>();
        assistidos.add(filmeRobervan);
        assistidos.add(meuFilme);
        assistidos.add(outroFilme);
        assistidos.add(lost);

        for (Titulo item: assistidos ) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
            System.out.println("classificação:  " + filme.getClassificacao());
            }
        }


        Filme favorito = new Filme(" The Matrix", 1999);
        favorito.avalia(10);

        Filme outro = new Filme("Alice", 2014);
        outro.avalia(9);

        Serie serie = new Serie("robervan", 2017);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(outro);
        lista.add(serie);

        for(Titulo item : lista) {
            System.out.println("nome do filme:  " +item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação do Filme:  " +filme.getClassificacao());
            }
        }

        ArrayList<String> buscaArtista = new ArrayList<>();
        buscaArtista.add("robervan souza");
        buscaArtista.add("Auriene");
        buscaArtista.add("bia");
        buscaArtista.add("Alice");
        System.out.println(buscaArtista);

        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);


        System.out.println("Titulos Ordenados:::");

        Collections.sort(lista);
        System.out.println("lista" + lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento)); // metodo comparação;
        System.out.println("ano de lancamento: " + lista);

    }
}
