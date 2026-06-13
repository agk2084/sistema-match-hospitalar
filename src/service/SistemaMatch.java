package service;

import model.Paciente;
import model.Profissional;
import model.ResultadoMatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SistemaMatch {

    // Filtra profissionais compatíveis
    public List<Profissional> filtrarProfissionais(Paciente paciente, List<Profissional> profissionais) {

        List<Profissional> filtrados = new ArrayList<>();

        // Percorre todos os profissionais
        for (Profissional profissional : profissionais) {

            // Verifica especialidade
            boolean mesmaEspecialidade = profissional.getEspecialidade().equalsIgnoreCase(paciente.getEspecialidadeNecessaria());

            // Verifica disponibilidade
            boolean disponivel = profissional.isDisponibilidade();

            // Adiciona somente profissionais válidos
            if (mesmaEspecialidade && disponivel) {
                filtrados.add(profissional);
            }
        }
        return filtrados;
    }

    // Calcula a distância Euclidiana
    public double calcularDistancia(Paciente paciente, Profissional profissional) {

        // Normaliza idade do paciente
        int idadeNormalizada = normalizarIdade (paciente.getIdade());

        // Fórmula da distância Euclidiana
        double distancia = Math.sqrt(Math.pow (paciente.getPrioridade() - profissional.getCapacidade(), 2) + Math.pow (idadeNormalizada - profissional.getExperiencia(), 2));
        return distancia;
    }

    // Converte idade em faixa numérica
    public int normalizarIdade(int idade) {

        if (idade <= 17) {
            return 1;
        }

        if (idade <= 59) {
            return 2;
        }

        return 3;
    }

    // Aplica bônus de localização
    public double aplicarAjustes(Paciente paciente, Profissional profissional, double distancia) {

        // Verifica se estão na mesma localização
        boolean mesmaLocalizacao = paciente.getLocalizacao().equalsIgnoreCase(profissional.getLocalizacao());

        // Diminui distância se estiverem próximos
        if (mesmaLocalizacao) {
            distancia -= 0.5;
        }

        // Evita distância negativa
        if (distancia < 0) {
            distancia = 0;
        }

        return distancia;
    }

    // Gera ranking dos profissionais
    public List<ResultadoMatch> gerarRanking(Paciente paciente, List<Profissional> profissionais) {

        List<ResultadoMatch> ranking = new ArrayList<>();

        // Filtra profissionais válidos
        List<Profissional> filtrados =
                filtrarProfissionais(paciente, profissionais);

        // Calcula distância de cada profissional
        for (Profissional profissional : filtrados) {

            double distancia = calcularDistancia (paciente, profissional);

            // Aplica ajustes
            distancia = aplicarAjustes (paciente, profissional, distancia);

            // Cria resultado do match
            ResultadoMatch resultado = new ResultadoMatch (profissional, distancia);
            ranking.add(resultado);
        }

        // Ordena por menor distância
        ranking.sort (Comparator.comparingDouble(ResultadoMatch::getDistancia));

        return ranking;
    }

    // Retorna o melhor profissional
    public Profissional recomendarMelhor(List<ResultadoMatch> ranking) {

        // Verifica se ranking está vazio
        if (ranking.isEmpty()) {
            return null;
        }

        // Retorna primeiro colocado
        return ranking.get(0).getProfissional();
    }
}