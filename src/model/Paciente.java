package model;

public class Paciente {
    
    /**
    * CLASSE QUE REPRESENTA UM PROFISSIONAL NO SISTEMA
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
     * @param prioridade                    => nível de prioridade do paciente (1 = baixa, 2 = média, 3 = alta)
     * @param especialidadeNecessaria       => especialidade médica necessária relacionada as queixas
     * @param localizacao                   => setor onde o paciente se encontra
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
     * Retorna a idade do paciente.
     * @return idade do paciente
    */

    public int getIdade() {
        return idade;
    }

    /**
     * Retorna a prioridade do paciente.
     * @return prioridade do paciente
    */

    public int getPrioridade() {
        return prioridade;
    }

    /**
     * Retorna a especialidade necessária para o paciente.
     * @return especialidade necessária
     */
    public String getEspecialidadeNecessaria() {
        return especialidadeNecessaria;
    }

    /**
     * Retorna a localização do paciente.
     * @return localização do paciente
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Retorna o sintoma informado.
     * @return sintoma do paciente
     */
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


