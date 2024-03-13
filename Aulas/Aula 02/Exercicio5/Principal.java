// Por Grégori Pintarelli

import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        // Chave: Nome do aluno, Valor: Estado de aprovação do aluno
        HashMap<String,String> alunos = new HashMap<String,String>();
        int opcao = 0;

        while (opcao != 6) {
            opcao = menuDeSelecao(kb);
            switch (opcao) {
                case 1:
                    cadastrar(kb, alunos);
                    break;
                case 2:
                    listar(alunos);
                    break;
                case 3:
                    estatisticas(alunos);
                    break;
                case 4:
                    alterar(kb, alunos);
                    break;
                case 5:
                    remover(kb, alunos);
                    break;
                default: break;
            }
        }

        kb.close();
    }

    private int menuDeSelecao(Scanner kb) {
        System.out.println(
            "----------==========----------\n" +
            "1 - Cadastrar aluno\n" +
            "2 - Listar alunos\n" +
            "3 - Listar estatísticas\n" +
            "4 - Alterar aluno\n" +
            "5 - Remover aluno\n" +
            "6 - Finalizar\n" +
            "----------==========----------\n" +
            "Selecione a opção: ");
        return opcao(kb, false);
    }

    private int opcao(Scanner kb, boolean printError) {
        if (printError) System.out.println("Selecione uma das opções entre 1 e 6: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(kb.next());
            if (opcao < 1 || opcao > 6) return opcao(kb, true);
        } catch (Exception e) {
            return opcao(kb, true);
        }
        return opcao;
    }

    private void cadastrar (Scanner kb, HashMap<String,String> hm) {
        System.out.print("Escreva o nome do aluno que sera cadastrado: ");
        String n = kb.next();
        boolean igualEncontrado = false;
        for (String aluno : hm.keySet()) {
            if (aluno.equalsIgnoreCase(n)) {
                igualEncontrado = true;
            }
        }
        if (igualEncontrado) System.out.println("O aluno com nome " + n + " já existe, e assim ele não pode ser cadastrado.");
        else {
            System.out.print("Escreva o estado de aprovação do aluno que sera cadastrado: ");
            String eda = kb.next();
            hm.put(n, eda);
            System.out.println("O aluno " + n + " foi cadastrado.");
        }
    }

    private void listar(HashMap<String,String> hm) {
        System.out.print("Alunos: [ ");
        if (hm.size() <= 0) {System.out.println(" ]."); return;}
        int i = 0;
        for (String aluno : hm.keySet()) {
            if (i != hm.size() - 1) System.out.print(aluno + " | " + hm.get(aluno) + ", ");
            else System.out.println(aluno + " | " + hm.get(aluno) + " ].");
            i++;
        }
    }

    private void estatisticas(HashMap<String,String> hm) {
        HashMap<String, Integer> estadosDeAprovacao = new HashMap<String, Integer>();
        String produtosDeCadaSegmento = "-----Estatísticas dos alunos:\nTotal de alunos: " + hm.size();
        for (String eda : hm.values()) {
            if (!estadosDeAprovacao.containsKey(eda)) estadosDeAprovacao.put(eda, 1);
            else estadosDeAprovacao.replace(eda, estadosDeAprovacao.get(eda) + 1);
        }
        for (String eda : estadosDeAprovacao.keySet()) {
            produtosDeCadaSegmento += "\nAlunos com estado '" + eda + "': " + estadosDeAprovacao.get(eda);
        }
        System.out.println(produtosDeCadaSegmento);
    }

    private void alterar (Scanner kb, HashMap<String,String> hm) {
        System.out.print("Escreva o nome de um aluno para alterar o estado de aprovação dele: ");
        String nS = kb.next();
        if (!hm.containsKey(nS)) {
            System.out.println("Esse aluno não foi encontrado.");
            return;
        }
        System.out.print("O aluno com nome "+ nS +" foi encontrado. Escreva o novo estado de aprovação: ");
        String eda = kb.next();
        hm.replace(nS, eda);
        System.out.println("O aluno "+ nS +" teve seu estado de aprovação substituido para "+ eda +".");
    }

    private void remover (Scanner kb, HashMap<String,String> hm) {
        System.out.print("Escreva o nome do aluno que sera excluido: ");
        String nE = kb.next();
        if (!hm.containsKey(nE)) {
            System.out.println("Esse aluno não foi encontrado.");
            return;
        }
        hm.remove(nE);
        System.out.println("O aluno "+ nE +" foi excluido.");
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}