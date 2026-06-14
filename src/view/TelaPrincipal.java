package view;

import model.Paciente;
import model.Profissional;
import model.ResultadoMatch;
import service.SistemaMatch;
import util.LeitorArquivo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private JTextField txtIdade;
    private JComboBox<String> cbPrioridade;
    private JComboBox<String> cbEspecialidade;
    private JComboBox<String> cbLocalizacao; ////////////////
    private JTextField txtSintoma;
    private JButton btnMatch;
    private JTextArea areaResultado;

    public TelaPrincipal() {

        setTitle("Sistema de Triagem Hospitalar");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // =========================
        // Título
        // =========================

        JLabel titulo = new JLabel("Sistema de Triagem Hospitalar");
        titulo.setBounds(100, 10, 300, 30);
        titulo.setFont(new Font("Arial",Font.BOLD,18));

        add(titulo);

        // =========================
        // Idade
        // =========================

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(20, 60, 100, 25);
        add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(150, 60, 200, 25);
        add(txtIdade);

        // =========================
        // Prioridade
        // =========================

        JLabel lblPrioridade = new JLabel("Prioridade:");
        lblPrioridade.setBounds(20, 100, 100, 25);
        add(lblPrioridade);

        cbPrioridade = new JComboBox<>(
            new String[]{
                "Baixa", 
                "Média", 
                "Alta"
            }
        );

        cbPrioridade.setBounds(150, 100, 200, 25);
        add(cbPrioridade);

        // =========================
        // Especialidade
        // =========================

        LeitorArquivo leitor = new LeitorArquivo();

        List<String> especialidades = leitor.lerEspecialidades("data/especialidades.txt");

        JLabel lblEspecialidade = new JLabel("Especialidade:");

        lblEspecialidade.setBounds(20,140,100,25);

        add(lblEspecialidade);

        cbEspecialidade = new JComboBox<>(especialidades.toArray(new String[0]));

        cbEspecialidade.setBounds(150,140,200,25);

        add(cbEspecialidade);

        // =========================
        // Localização
        // =========================

        JLabel lblLocalizacao = new JLabel("Setor:");
        lblLocalizacao.setBounds(20, 180, 100, 25);
        add(lblLocalizacao);

        cbLocalizacao = new JComboBox<>(
            new String[]{
                "Emergencia",
                "Ala A",
                "Ala B",
                "Ala C"
            }
        );

        cbLocalizacao.setBounds(150, 180, 200, 25);

        add(cbLocalizacao);

        // =========================
        // Sintoma
        // =========================

        JLabel lblSintoma = new JLabel("Sintoma:");
        lblSintoma.setBounds(20, 220, 100, 25);
        add(lblSintoma);

        txtSintoma = new JTextField();
        txtSintoma.setBounds(150, 220, 200, 25);
        add(txtSintoma);

        // =========================
        // Botões
        // =========================

        btnMatch = new JButton("Realizar Match");
        btnMatch.setBounds(80, 280, 150, 35);
        add(btnMatch);

        btnMatch.addActionListener(e -> realizarMatch());

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(250, 280, 100, 35);
        add(btnLimpar);

        btnLimpar.addActionListener(e -> limparCampos());

        // =========================
        // Resultado
        // =========================

        JLabel lblResultado = new JLabel("Resultado da Triagem");

        lblResultado.setBounds(20,330,200,25);

        add(lblResultado);

        areaResultado = new JTextArea();

        areaResultado.setEditable(false);

        areaResultado.setLineWrap(true);

        areaResultado.setWrapStyleWord(true);

        JScrollPane scrollResultado = new JScrollPane(areaResultado);

        scrollResultado.setBounds(20,360,440,170);

        add(scrollResultado);
    }

    /**
     * Executa a triagem do paciente,
     * gera o ranking e exibe o resultado.
     */
    private void realizarMatch() {
        try {
            int idade = Integer.parseInt(txtIdade.getText());

            if (idade < 0 || idade > 120) {
                JOptionPane.showMessageDialog(this,"A idade deve estar entre 0 e 120 anos.");
                return;
            }
            int prioridade;

            String prioridadeSelecionada = cbPrioridade.getSelectedItem().toString();

            switch (prioridadeSelecionada) {
                case "Baixa":
                    prioridade = 1;
                    break;

                case "Média":
                    prioridade = 2;
                    break;

                default:
                    prioridade = 3;
            }
        
            String especialidade = cbEspecialidade.getSelectedItem().toString(); 
            String localizacao = cbLocalizacao.getSelectedItem().toString();           
            String sintoma = txtSintoma.getText();            
            
            Paciente paciente = new Paciente(
                idade,
                prioridade,
                especialidade,
                localizacao,
                sintoma
            );

            LeitorArquivo leitor = new LeitorArquivo();
            List<Profissional> profissionais = leitor.lerProfissionais( "data/profissionais.csv");
            SistemaMatch sistema = new SistemaMatch();
            List<ResultadoMatch> ranking = sistema.gerarRanking(paciente,profissionais);
            Profissional melhor = sistema.recomendarMelhor(ranking);

            if (melhor != null) {

                StringBuilder mensagem = new StringBuilder();

                mensagem.append("Paciente\n");
                mensagem.append("-----------------\n");
                mensagem.append("Idade: ").append(idade).append("\n");
                mensagem.append("Prioridade: ").append(prioridadeSelecionada).append("\n");
                mensagem.append("Especialidade: ").append(especialidade).append("\n");
                mensagem.append("Setor: ").append(localizacao).append("\n");
                mensagem.append("Sontoma: ").append(sintoma).append("\n\n");

                mensagem.append("PROFISSIONAL RECOMENDADO\n");
                mensagem.append("-------------------------\n\n");
                mensagem.append("Nome: ").append(melhor.getNome()).append("\n");
                mensagem.append("Especialidade: ").append(melhor.getEspecialidade()).append("\n");
                mensagem.append("Capacidade: ").append(melhor.getCapacidade()).append("\n");
                mensagem.append("Experiência: ").append(melhor.getExperiencia()).append("\n");
                mensagem.append("Localização: ").append(melhor.getLocalizacao()).append("\n");
                mensagem.append("Distância: ").append(String.format("%.2f", ranking.get(0).getDistancia())).append("\n\n");
                
                mensagem.append("\nRANKING DE COMPATIBILIDADE\n");
                mensagem.append("-------------------------\n\n");   

                int posicao = 1;

                for (ResultadoMatch resultado : ranking) {
                    mensagem.append("#")
                        .append(posicao)
                        .append(" - ")
                        .append(resultado.getProfissional().getNome())
                        .append(" | Distância: ")
                        .append(
                        String.format("%.2f", resultado.getDistancia()))
                        .append("\n");
                    posicao++;
                }

                areaResultado.setText(mensagem.toString());
                } else {
                    JOptionPane.showMessageDialog(this,"Nenhum profissional encontrado.");
                }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,"Preencha todos os campos corretamente.");
            }
    }

    /**
     * Limpa todos os campos da tela.
     */
    private void limparCampos() {

        txtIdade.setText("");

        cbLocalizacao.setSelectedIndex(0);

        txtSintoma.setText("");

        cbPrioridade.setSelectedIndex(0);

        cbEspecialidade.setSelectedIndex(0);

        areaResultado.setText("");
    }
}