package model;

public class Profissional {
    /**
    * Classe que representa um Profissional no sistema
    */

    // =========================
    // Atributos da classe
    // =========================
    private String nome;
    private String especialidade;
    private int capacidade;
    private int experiencia;
    private boolean disponibilidade;
    private String localizacao;

    // =========================
    // Construtor da classe
    // =========================

    /**
     * Cria um profissional com seus respectivos dados.
     *
     * @param nome nome do profissional
     * @param especialidade especialidade médica
     * @param capacidade nível de capacidade de atendimento
     * @param experiencia nível de experiência profissional
     * @param disponibilidade disponibilidade para atendimento
     * @param localizacao localização atual do profissional
    */
    public Profissional(
            String nome, 
            String especialidade, 
            int capacidade, 
            int experiencia, 
            boolean disponibilidade, 
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
}