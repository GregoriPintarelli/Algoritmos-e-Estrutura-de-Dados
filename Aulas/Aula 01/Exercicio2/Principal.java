// Por Grégori Pintarelli

import java.util.Scanner;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        String [] Nomes = new String [10];
        int opcao = 0;

        while (opcao != 5) {
            opcao = menuDeSelecao(kb);
            switch (opcao) {
                case 1:
                    cadastrar(kb, Nomes);
                    break;
                case 2:
                    listar(Nomes);
                    break;
                case 3:
                    alterar(kb, Nomes);
                    break;
                case 4:
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
            "1 - Cadastrar nome\n" +
            "2 - Listar nomes\n" +
            "3 - Alterar nome\n" +
            "4 - Remover nome\n" +
            "5 - Finalizar\n" +
            "----------==========----------\n" +
            "Selecione a opção: ");
        return opcao(kb, false);
    }

    private int opcao(Scanner kb, boolean printError) {
        if (printError) System.out.println("Selecione uma das opções entre 1 e 5: ");
        int opcao;
        try {
            opcao = Integer.parseInt(kb.next());
            if (opcao < 1 || opcao > 5) return opcao(kb, true);
            return opcao;
        } catch (Exception e) {
            return opcao(kb, true);
        }
    }

    private void cadastrar (Scanner kb, String[] v) {
        System.out.print("Escreva o nome que sera colocado no vetor: ");
        String n = kb.next();
        int i = 0;
        while (i < v.length) {
            if (v[i] == null || v[i].isBlank()) {
                v[i] = n;
                System.out.println("Nome " + n + " colocado no vetor na posição " + i + ".");
                return;
            }
            else i++;
        }
        System.out.println("O nome não foi colocado no vetor, pois ele está sem espaços vazios.");
    }

    private void listar(String[] v) {
        System.out.print("Nomes: [ ");
        for (int i = 0; i < v.length; i++) {
            if (i != v.length - 1) {
                if (v[i] == null) System.out.print(" , ");
                else System.out.print(v[i] + ", ");
            }
            else {
                if (v[i] == null) System.out.println(" ]");
                else System.out.println(v[i] + " ].");
            }

        }
    }

    private void alterar (Scanner kb, String[] v) {
        System.out.print("Escreva um nome no vetor para que ele seja substituido: ");
        String nS = kb.next();
        int pos = 0;
        boolean encontrado = false;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != null && v[i].equalsIgnoreCase(nS)) {
                encontrado = true;
                pos = i;
            }
        }
        if (!encontrado) {
            System.out.println("O nome não foi encontrado no vetor, nada foi alterado.");
            return;
        }
        System.out.print("Nome "+ nS +" encontrado. Substituir pelo nome: ");
        String n = kb.next();

        v[pos] = n;
        System.out.println("Nome "+ nS +" substituido por "+ n +".");
    }

    private void remover (Scanner kb, String[] v) {
        System.out.print("Escreva o nome que sera removido do vetor: ");
        String nE = kb.next();
        int pos = 0;
        boolean encontrado = false;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != null && v[i].equalsIgnoreCase(nE)) {
                encontrado = true;
                pos = i;
            }
        }
        if (!encontrado) {
            System.out.println("O nome não foi encontrado no vetor, nada foi removido.");
            return;
        }

        v[pos] = null;
        System.out.println("O nome "+ nE +" foi removido.");
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}