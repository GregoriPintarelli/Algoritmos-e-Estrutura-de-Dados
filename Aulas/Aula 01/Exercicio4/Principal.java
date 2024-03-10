// Por Grégori Pintarelli
/*
    Nesse programa, utiliza-se a estrutura de dados de Fila (Queue), pois necessita-se que os dados
    adicionados por primeiro sejam removidos por primeiro (FIFO - First-In-First-Out)
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        Queue<String> Nomes = new LinkedList<String>();
        int opcao = 0;

        while (opcao != 3) {
            opcao = menuDeSelecao(kb);
            switch (opcao) {
                case 1:
                    cadastrar(kb, Nomes);
                    break;
                case 2:
                    remover(kb, Nomes);
                    break;
                default: break;
            }
        }

        kb.close();
    }

    private int menuDeSelecao(Scanner kb) {
        System.out.println(
            "----------==========----------\n" +
            "1 - Cadastrar atendimento\n" +
            "2 - Remover atendimento\n" +
            "3 - Finalizar\n" +
            "----------==========----------\n" +
            "Selecione a opção: ");
        return opcao(kb, false);
    }

    private int opcao(Scanner kb, boolean printError) {
        if (printError) System.out.println("Selecione uma das opções entre 1 e 3: ");
        int opcao;
        try {
            opcao = Integer.parseInt(kb.next());
            if (opcao < 1 || opcao > 3) return opcao(kb, true);
            return opcao;
        } catch (Exception e) {
            return opcao(kb, true);
        }
    }

    private void cadastrar (Scanner kb, Queue<String> q) {
        System.out.print("Escreva o nome da pessoa que necessita de atendimento: ");
        String n = kb.next();
        q.add(n);
        System.out.println("O Atendimento de " + n + " foi registrado.");
    }

    private void remover (Scanner kb, Queue<String> q) {
        String removido = q.poll();
        if (removido == null) System.out.println("Nenhum atendimento removido, pois a fila de atendimentos está vazia.");
        else System.out.println("O atendimento de "+ removido +" foi removido.");
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}