package util;

import model.Profissional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    public List<Profissional> lerProfissionais(String caminho) {

        List<Profissional> profissionais = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;

            // Ignora cabeçalho
            br.readLine();

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(",");

                String nome = dados[0];
                String especialidade = dados[1];
                int capacidade = Integer.parseInt(dados[2]);
                int experiencia = Integer.parseInt(dados[3]);
                boolean disponibilidade = Boolean.parseBoolean(dados[4]);
                String localizacao = dados[5];

                Profissional profissional = new Profissional(
                        nome,
                        especialidade,
                        capacidade,
                        experiencia,
                        disponibilidade,
                        localizacao
                );

                profissionais.add(profissional);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return profissionais;
    }
}