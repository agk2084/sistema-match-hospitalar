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
    private JTextField txtLocalizacao;
    private JTextField txtSintoma;
    private JButton btnMatch;

    public TelaPrincipal() {

        setTitle("Sistema de Triagem Hospitalar");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        // =========================
        // Título
        // =========================

        JLabel titulo = new JLabel("Sistema de Triagem Hospitalar");

        titulo.setBounds(100, 10, 300, 30);

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

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
                new String[]{"1", "2", "3"}
        );

        cbPrioridade.setBounds(150, 100, 200, 25);
        add(cbPrioridade);

        // =========================
        // Especialidade
        // =========================

        JLabel lblEspecialidade = new JLabel("Especialidade:");
        lblEspecialidade.setBounds(20, 140, 100, 25);
        add(lblEspecialidade);

        cbEspecialidade = new JComboBox<>(
                new String[]{
                        "Cardiologia",
                        "Clinico Geral",
                        "Ortopedia",
                        "Neurologia"
                }
        );

        cbEspecialidade.setBounds(150, 140, 200, 25);
        add(cbEspecialidade);

        // =========================
        // Localização
        // =========================

        JLabel lblLocalizacao = new JLabel("Localização:");
        lblLocalizacao.setBounds(20, 180, 100, 25);
        add(lblLocalizacao);

        txtLocalizacao = new JTextField();
        txtLocalizacao.setBounds(150, 180, 200, 25);
        add(txtLocalizacao);

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
        // Botão
        // =========================

        btnMatch = new JButton("Realizar Match");
        btnMatch.setBounds(150, 280, 200, 35);
        add(btnMatch);

        // Evento do botão
        btnMatch.addActionListener(e -> realizarMatch());
    }

    /**
     * Realiza o processo de triagem
     * e exibe o resultado do matching.
     */
    private void realizarMatch() {

        try {

            int idade =
                    Integer.parseInt(txtIdade.getText());

            int prioridade =
                    Integer.parseInt(
                            cbPrioridade.getSelectedItem().toString()
                    );

            String especialidade =
                    cbEspecialidade.getSelectedItem().toString();

            String localizacao =
                    txtLocalizacao.getText();

            String sintoma =
                    txtSintoma.getText();

            Paciente paciente = new Paciente(
                    idade,
                    prioridade,
                    especialidade,
                    localizacao,
                    sintoma
            );

            LeitorArquivo leitor = new LeitorArquivo();

            List<Profissional> profissionais =
                    leitor.lerProfissionais(
                            "data/profissionais.csv"
                    );

            SistemaMatch sistema =
                    new SistemaMatch();

            List<ResultadoMatch> ranking =
                    sistema.gerarRanking(
                            paciente,
                            profissionais
                    );

            Profissional melhor =
                    sistema.recomendarMelhor(
                            ranking
                    );

            if (melhor != null) {

                StringBuilder mensagem = new StringBuilder();

                mensagem.append("=== PROFISSIONAL RECOMENDADO ===\n\n");

                mensagem.append("Nome: ")
                        .append(melhor.getNome())
                        .append("\n");

                mensagem.append("Especialidade: ")
                        .append(melhor.getEspecialidade())
                        .append("\n");

                mensagem.append("Capacidade: ")
                        .append(melhor.getCapacidade())
                        .append("\n");

                mensagem.append("Experiência: ")
                        .append(melhor.getExperiencia())
                        .append("\n");

                mensagem.append("Localização: ")
                        .append(melhor.getLocalizacao())
                        .append("\n\n");

                mensagem.append("=== RANKING ===\n\n");

                int posicao = 1;

                for (ResultadoMatch resultado : ranking) {

                    mensagem.append(posicao)
                            .append("º Lugar - ")
                            .append(resultado.getProfissional().getNome())
                            .append(" | Distância: ")
                            .append(String.format("%.2f",
                                    resultado.getDistancia()))
                            .append("\n");

                    posicao++;
                }

                JOptionPane.showMessageDialog(
                        this,
                        mensagem.toString(),
                        "Resultado da Triagem",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum profissional encontrado."
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Preencha todos os campos corretamente."
            );
        }
    }
}