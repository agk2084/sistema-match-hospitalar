package model;

public class ResultadoMatch {

    /**
     * Class attributes
     */
    private Profissional profissional;
    private double distancia;

    /**
     * Class constructor
     */
    public ResultadoMatch(Profissional profissional, double distancia) {
        this.profissional = profissional;
        this.distancia = distancia;
    }

    /**
     * getters 
     * @return
     */
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
    /**
     * and code
     */
}