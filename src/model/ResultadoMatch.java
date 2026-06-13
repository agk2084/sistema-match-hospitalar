package model;

/**
 * Classe responsável por armazenar
 * o resultado do cálculo de similaridade
 * entre um paciente e um profissional.
 */
public class ResultadoMatch {

    /**
     * Profissional avaliado.
     */
    private Profissional profissional;

    /**
     * Distância calculada pelo algoritmo.
     * Quanto menor a distância,
     * maior a compatibilidade.
     */
    private double distancia;

    /**
     * Cria um resultado de matching.
     *
     * @param profissional profissional avaliado
     * @param distancia distância calculada pelo algoritmo
     */
    public ResultadoMatch(Profissional profissional, double distancia) {
        this.profissional = profissional;
        this.distancia = distancia;
    }

    /**
     * Retorna o profissional associado ao resultado.
     *
     * @return profissional
     */
    public Profissional getProfissional() {
        return profissional;
    }

    /**
     * Retorna a distância calculada.
     *
     * @return distância
     */
    public double getDistancia() {
        return distancia;
    }

    // =========================
    // Métodos sobrescritos
    // =========================

    @Override
    public String toString() {
        return "ResultadoMatch{" +
                "profissional=" + profissional.getNome() +
                ", distancia=" + distancia +
                '}';
    }
}