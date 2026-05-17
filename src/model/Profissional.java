package model;

public class Profissional {
    /**
    * Classe que representa um paciente no sistema
    */

    // =========================
    // Atributos da classe
    // =========================
    String nome;
    String especialidade;
    int capacidade;
    int experiencia;
    boolean disponibilidade;
    String localizacao;

    // =========================
    // Construtor da classe
    // =========================
    public Profissional(String nome, String especialidade, int capacidade, int experiencia, boolean disponibilidade,
            String localizacao) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.capacidade = capacidade;
        this.experiencia = experiencia;
        this.disponibilidade = disponibilidade;
        this.localizacao = localizacao;
    }

    // =========================
    // Getters da classe
    // =========================
    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    // =========================
    // Métodos sobrescritos
    // =========================
    @Override
    public String toString() {
        return "Profissional{" +
                "nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", capacidade=" + capacidade +
                ", experiencia=" + experiencia +
                ", disponibilidade=" + disponibilidade +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }  
    /**
     * and code
     */
}