package model;

public class ResultadoMatch {

    // =========================
    // Atributos da classe
    // =========================
    private Profissional profissional;
    private double distancia;

    // =========================
    // Construtor da classe
    // =========================
    public ResultadoMatch(Profissional profissional, double distancia) {
        this.profissional = profissional;
        this.distancia = distancia;
    }

    // =========================
    // Getters
    // =========================
    public Profissional getProfissional() {
        return profissional;
    }

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