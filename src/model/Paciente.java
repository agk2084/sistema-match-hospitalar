package model;

public class Paciente {
    
    /**
    * Classe que representa um paciente no sistema
    */

    // =========================
    // Atributos da classe
    // =========================   
    private int idade;
    private int prioridade;
    private String especialidadeNecessaria;
    private String localizacao;
    private String sintoma;

    // =========================
    // Construtor da classe
    // =========================

    /**
     * Cria um paciente com seus respectivos dados
     * @param idade                         => idade do paciente
     * @param prioridade                    => prioridade (nível) do paciente de acordo com sua enfermidade
     * @param especialidadeNecessaria       => especialidade médica necessária relacionada as queixas
     * @param localizacao                   => localização do paciente/ ala que se encontra
     * @param sintoma                       => sintoma (da enfermidade) do paciente
     */
    public Paciente(int idade, int prioridade, String especialidadeNecessaria, String localizacao, String sintoma) {
        this.idade = idade;
        this.prioridade = prioridade;
        this.especialidadeNecessaria = especialidadeNecessaria;
        this.localizacao = localizacao;
        this.sintoma = sintoma;
    }

    // =========================
    // Getters da classe
    // =========================

    /**
     * Retorna a idade do paciente
     * @return prioridade
     */

    public int getIdade() {
        return idade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getEspecialidadeNecessaria() {
        return especialidadeNecessaria;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getSintoma() {
        return sintoma;
    }

    // =========================
    // Métodos sobrescritos
    // =========================

    @Override
    public String toString() {
        return "Paciente{" +
                "idade=" + idade +
                ", prioridade=" + prioridade +
                ", especialidadeNecessaria='" + especialidadeNecessaria + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", sintoma='" + sintoma + '\'' +
                '}';
    } 
}


