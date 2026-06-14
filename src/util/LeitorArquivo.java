package util;

import model.Profissional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela leitura
 * dos arquivos utilizados pelo sistema.
 */
public class LeitorArquivo {

    /**
     * Lê os profissionais cadastrados
     * no arquivo CSV.
     *
     * @param caminho caminho do arquivo
     * @return lista de profissionais
     */
    public List<Profissional> lerProfissionais(String caminho) {

        List<Profissional> profissionais = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;

            // Ignora o cabeçalho
            br.readLine();

            while ((linha = br.readLine()) != null) {

                // Ignora linhas vazias
                if (linha.isBlank()) {
                    continue;
                }

                String[] dados = linha.split(",");

                String nome = dados[0].trim();
                String especialidade = dados[1].trim();
                int capacidade = Integer.parseInt(dados[2].trim());
                int experiencia = Integer.parseInt(dados[3].trim());
                boolean disponibilidade = Boolean.parseBoolean(dados[4].trim());
                String localizacao = dados[5].trim();

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
            System.out.println("Erro ao ler profissionais: " + e.getMessage());
        }

        return profissionais;
    }

    /**
     * Lê as especialidades disponíveis
     * no arquivo TXT.
     *
     * @param caminho caminho do arquivo
     * @return lista de especialidades
     */
    public List<String> lerEspecialidades(String caminho) {

        List<String> especialidades = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                if (!linha.isBlank()) {
                    especialidades.add(linha.trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler especialidades: " + e.getMessage());
        }

        return especialidades;
    }
}