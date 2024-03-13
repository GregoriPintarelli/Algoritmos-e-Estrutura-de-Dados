// Por Grégori Pintarelli

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        List<String> nomes = new LinkedList<String>();
        int opcao = 0;

        while (opcao != 3) {
            opcao = menuDeSelecao(kb);
            switch (opcao) {
                case 1:
                    cadastrar(kb, nomes);
                    break;
                case 2:
                    listar(nomes);
                    break;
                default: break;
            }
        }

        kb.close();
    }

    private int menuDeSelecao(Scanner kb) {
        System.out.println(
            "----------==========----------\n" +
            "1 - Cadastrar um nome\n" +
            "2 - Listar todos nomes\n" +
            "3 - Finalizar\n" +
            "----------==========----------\n" +
            "Selecione a opção: ");
        return opcao(kb, false);
    }

    private int opcao(Scanner kb, boolean printError) {
        if (printError) System.out.println("Selecione uma das opções entre 1 e 3: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(kb.next());
            if (opcao < 1 || opcao > 3) return opcao(kb, true);
        } catch (Exception e) {
            return opcao(kb, true);
        }
        return opcao;
    }

    private void cadastrar (Scanner kb, List<String> ln) {
        System.out.print("Escreva um nome para ele ser cadastrado: ");
        String n = kb.next();
        boolean igualEncontrado = false;
        for (int i = 0; i < ln.size(); i++) {
            if (ln.get(i).equals(n)) {
                igualEncontrado = true;
            }
        }
        if (igualEncontrado) System.out.println("O nome " + n + " já está cadastrado, e assim ele não foi cadastrado novamente.");
        else {
            ln.add(n);
            System.out.println("O nome " + n + " foi cadastrado.");
        }
    }

    private void listar(List<String> ln) {
        System.out.print("Nomes: [ ");
        if (ln.size() <= 0) {System.out.println(" ]."); return;}
        for (int i = 0; i < ln.size(); i++) {
            if (i != ln.size() - 1) System.out.print(ln.get(i) + ", ");
            else System.out.println(ln.get(i) + " ].");
        }
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}