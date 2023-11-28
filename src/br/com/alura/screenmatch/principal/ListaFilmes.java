package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloTeste;
import br.com.alura.screenmatch.modelos.exception.ErroDeConversaoDeAno;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaFilmes {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);

        String busca = "";
        List<Titulo> titulos= new ArrayList<>();
        Gson gson =  new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();


        while (!busca.equalsIgnoreCase("sair")){

            System.out.println("Digite filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }



            String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=229d5d71";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);


//        System.out.println(meuTitulo);
                TituloTeste tituloTeste = gson.fromJson(json, TituloTeste.class);
                System.out.println(tituloTeste);

                Titulo meuTitulo = new Titulo (tituloTeste);
                System.out.println("Titulo já convertido!!!");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch (NumberFormatException erro){
                System.out.println("Error");
                System.out.println(erro.getMessage());
            } catch (ErroDeConversaoDeAno erro){
                System.out.println(erro.getMessage());
            }
        }
            System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
            System.out.println("o programa finalizou corretamente!");
    }


}

