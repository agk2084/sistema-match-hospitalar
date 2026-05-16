package model;

public class Paciente {
    
    /*
     Atributos da classe Paciente
    */
    int idade;
    int prioridade;
    String especialidadeNecessaria;
    String localizacao;
    String sintoma;

    /*
     Construtor de classe Paciente
    */
    public Paciente(int idade, int prioridade, String especialidadeNecessaria, String localizacao, String sintoma) {
        this.idade = idade;
        this.prioridade = prioridade;
        this.especialidadeNecessaria = especialidadeNecessaria;
        this.localizacao = localizacao;
        this.sintoma = sintoma;
    }

    /*
     getters 
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
}
