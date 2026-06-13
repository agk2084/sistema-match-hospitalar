// import java.util.List;
// import java.util.Scanner;

// import model.Paciente;
// import model.Profissional;
// import model.ResultadoMatch;
// import service.SistemaMatch;
// import util.LeitorArquivo;

// public class Main {
//     public static void main(String[] args) {

//         Scanner scanner = new Scanner(System.in);

//         LeitorArquivo leitor = new LeitorArquivo();

//         List<Profissional> profissionais = leitor.lerProfissionais("data/profissionais.csv");

//         List<String> especialidades = leitor.lerEspecialidades("data/especialidades.txt");

//         SistemaMatch sistema = new SistemaMatch();

//         int opcao;

//         do {
//             System.out.println("\n=================================");
//             System.out.println(" SISTEMA DE TRIAGEM HOSPITALAR ");
//             System.out.println("=================================");

//             System.out.println("1 - Realizar Triagem");
//             System.out.println("2 - Listar Profissionais");
//             System.out.println("3 - Sair");

//             System.out.print("\nEscolha uma opção: ");
//             opcao = scanner.nextInt();
//             scanner.nextLine();

//             switch (opcao) {
//                 case 1:
//                     realizarTriagem(scanner,especialidades,profissionais,sistema);
//                     break;

//                 case 2:
//                     listarProfissionais(profissionais);
//                     break;

//                 case 3:
//                     System.out.println("Encerrando sistema...");
//                     break;

//                 default:
//                     System.out.println("Opção inválida.");
//             }

//         } while (opcao != 3);

//         scanner.close();
//     }

//     /**
//      * Método realizarTriagem
//      */
//     public static void realizarTriagem(Scanner scanner,List<String> especialidades,List<Profissional> profissionais,SistemaMatch sistema) {

//         System.out.println("\n===== TRIAGEM =====");

//         System.out.print("Idade do paciente: ");
//         int idade = scanner.nextInt();
//         int prioridade;

//         do {

//             System.out.print("Prioridade (1-Baixa | 2-Média | 3-Alta): ");
//             prioridade = scanner.nextInt();

//             if (prioridade < 1 || prioridade > 3) {
//                 System.out.println("Prioridade inválida.");
//             }

//         } while (prioridade < 1 || prioridade > 3);

//         scanner.nextLine();

//         System.out.println("\nEspecialidades disponíveis:");

//         for (int i = 0; i < especialidades.size(); i++) {

//             System.out.println((i + 1) + " - " + especialidades.get(i));
//         }

//         int opcao;

//         do {

//             System.out.print("\nEscolha uma especialidade: ");
//             opcao = scanner.nextInt();

//             if (opcao < 1 || opcao > especialidades.size()) {
//                 System.out.println("Opção inválida.");
//             }

//         } while (opcao < 1 || opcao > especialidades.size());

//         scanner.nextLine();

//         String especialidade = especialidades.get(opcao - 1);

//         System.out.print("Localização: ");
//         String localizacao = scanner.nextLine();

//         System.out.print("Sintoma: ");
//         String sintoma = scanner.nextLine();

//         Paciente paciente = new Paciente(idade,prioridade,especialidade,localizacao,sintoma);

//         List<ResultadoMatch> ranking = sistema.gerarRanking(paciente,profissionais);

//         Profissional melhor = sistema.recomendarMelhor(ranking);

//         System.out.println("\n=================================");
//         System.out.println(" RESULTADO DA TRIAGEM ");
//         System.out.println("=================================");

//         System.out.println("\nDados do Paciente");
//         System.out.println("---------------------");
//         System.out.println("Idade: " + idade);
//         System.out.println("Prioridade: " + prioridade);
//         System.out.println("Especialidade: " + especialidade);
//         System.out.println("Localização: " + localizacao);
//         System.out.println("Sintoma: " + sintoma);

//         if (melhor != null) {

//             System.out.println("\nProfissional recomendado:");
//             System.out.println("-------------------------");

//             System.out.println("Nome: " + melhor.getNome());

//             System.out.println("Especialidade: " + melhor.getEspecialidade());

//             System.out.println("Capacidade: " + melhor.getCapacidade());

//             System.out.println("Experiência: " + melhor.getExperiencia());

//             System.out.println("Localização: " + melhor.getLocalizacao());

//         } else {

//             System.out.println("\nNenhum profissional encontrado.");
//         }

//         System.out.println("\n===== RANKING =====");

//         int posicao = 1;

//         for (ResultadoMatch resultado : ranking) {

//             System.out.printf(
//                     "%dº Lugar - %s | Distância: %.2f%n",
//                     posicao,
//                     resultado.getProfissional().getNome(),
//                     resultado.getDistancia()
//             );

//             posicao++;
//         }
//     }

//     /**
//      * Método listarProfissionais
//      */

//     public static void listarProfissionais(List<Profissional> profissionais) {

//         System.out.println("\n===== PROFISSIONAIS CADASTRADOS =====");

//         for (Profissional profissional : profissionais) {

//             System.out.println("\n--------------------------------");

//             System.out.println(
//                     "Nome: "
//                     + profissional.getNome()
//             );

//             System.out.println(
//                     "Especialidade: "
//                     + profissional.getEspecialidade()
//             );

//             System.out.println(
//                     "Capacidade: "
//                     + profissional.getCapacidade()
//             );

//             System.out.println(
//                     "Experiência: "
//                     + profissional.getExperiencia()
//             );

//             System.out.println(
//                     "Disponibilidade: "
//                     + profissional.isDisponibilidade()
//             );

//             System.out.println(
//                     "Localização: "
//                     + profissional.getLocalizacao()
//             );
//         }
//         System.out.println("\n--------------------------------");
//     }
// }

