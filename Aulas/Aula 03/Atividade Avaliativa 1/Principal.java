// Por Grégori Pintarelli - Atividade Avaliativa 1

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        Queue<String> Tarefas = new LinkedList<String>();
        int opcao = 0;

        while (opcao != 4) {
            opcao = menuDeSelecao(kb);
            switch (opcao) {
                case 1:
                    cadastrar(kb, Tarefas);
                    break;
                case 2:
                    verProxima(Tarefas);
                    break;
                case 3:
                    concluir(Tarefas);
                    break;
                default: break;
            }
        }

        kb.close();
    }

    private int menuDeSelecao(Scanner kb) {
        System.out.print(
            "----------==========----------\n" +
            "1 - Cadastrar tarefa\n" +
            "2 - Ver próxima tarefa\n" +
            "3 - Concluir tarefa\n" +
            "4 - Finalizar\n" +
            "----------==========----------\n" +
            "Selecione a opção: ");
        return opcao(kb, false);
    }

    private int opcao(Scanner kb, boolean printError) {
        if (printError) System.out.println("Selecione uma das opções entre 1 e 4: ");
        int opcao;
        try {
            opcao = Integer.parseInt(kb.next());
            if (opcao < 1 || opcao > 4) return opcao(kb, true);
            return opcao;
        } catch (Exception e) {
            return opcao(kb, true);
        }
    }

    private void cadastrar (Scanner kb, Queue<String> q) {
        kb.nextLine(); // Pular linha, bug do Scanner
        System.out.print("Escreva a tarefa que necessita de conclusão: ");
        String t = kb.nextLine();
        if (t.isBlank()) {
            System.out.println("A tarefa cadastrada não pode ser vazia!");
        } else {
            q.add(t);
            System.out.println("A tarefa '" + t + "' foi registrada.");
        }
    }

    private void verProxima (Queue<String> q) {
        String proxima = q.peek();
        if (proxima == null) System.out.println("Nenhuma tarefa está cadastrada.");
        else System.out.println("Próxima: '"+ proxima +"'");
    }

    private void concluir (Queue<String> q) {
        String removida = q.poll();
        if (removida == null) System.out.println("Nenhum tarefa removida, pois nenhuma tarefa está cadastrada.");
        else System.out.println("A tarefa '"+ removida +"' foi removida.");
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}