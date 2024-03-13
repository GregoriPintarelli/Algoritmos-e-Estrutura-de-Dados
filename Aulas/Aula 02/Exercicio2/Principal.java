// Por Grégori Pintarelli

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        List<String> produtos = new Vector<String>();
        int opcao = 0;

        while (opcao != 6) {
            opcao = menuDeSelecao(kb);
            switch (opcao) {
                case 1:
                    cadastrar(kb, produtos);
                    break;
                case 2:
                    listar(produtos);
                    break;
                case 3:
                    pesquisar(kb, produtos);
                    break;
                case 4:
                    alterar(kb, produtos);
                    break;
                case 5:
                    remover(kb, produtos);
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
            "3 - Pesquisar nomes\n" +
            "4 - Alterar nome\n" +
            "5 - Remover nome\n" +
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

    private void cadastrar (Scanner kb, List<String> l) {
        System.out.print("Escreva o nome que sera cadastrado: ");
        String n = kb.next();
        boolean igualEncontrado = false;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equalsIgnoreCase(n)) {
                igualEncontrado = true;
            }
        }
        if (igualEncontrado) System.out.println("O nome " + n + " já existe, e assim não pode ser cadastrado.");
        else {
            l.add(n);
            System.out.println("O nome " + n + " foi cadastrado.");
        }
    }

    private void listar(List<String> l) {
        System.out.print("Nomes: [ ");
        if (l.size() <= 0) {System.out.println(" ]."); return;}
        for (int i = 0; i < l.size(); i++) {
            if (i != l.size() - 1) System.out.print(l.get(i) + ", ");
            else System.out.println(l.get(i) + " ].");
        }
    }

    private void pesquisar (Scanner kb, List<String> l) {
        System.out.print("Escreva um termo de pesquisa para os nomes: ");
        String tp = kb.next();
        String nomes = "";
        for (String nome : l) {
           if (nome.contains(tp)) {
                nomes += nome + "\n";
            }
        }
        if (nomes == "") System.out.println("Nenhum nome foi encontrado com esse termo de pesquisa");
        else System.out.print("Nomes achados com esse termo de pesquisa:\n" + nomes);
    }

    private void alterar (Scanner kb, List<String> l) {
        System.out.print("Escreva um nome para que ele seja substituido: ");
        String nS = kb.next();
        int pos = 0;
        boolean encontrado = false;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equalsIgnoreCase(nS)) {
                encontrado = true;
                pos = i;
            }
        }
        if (!encontrado) {
            System.out.println("Esse nome não foi encontrado.");
            return;
        }
        System.out.print("O nome "+ nS +" foi encontrado. Escreva o nome que o substituira: ");
        String n = kb.next();
        boolean igualEncontrado = false;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equalsIgnoreCase(n)) {
                igualEncontrado = true;
            }
        }
        if (igualEncontrado) System.out.println("O nome " + n + " já existe, e assim não pode ser cadastrado.");
        else {
            l.set(pos, n);
            System.out.println("O nome "+ nS +" foi substituido pelo nome "+ n +".");
        }
    }

    private void remover (Scanner kb, List<String> l) {
        System.out.print("Escreva o nome que sera excluido: ");
        String nE = kb.next();
        int pos = 0;
        boolean encontrado = false;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equalsIgnoreCase(nE)) {
                encontrado = true;
                pos = i;
            }
        }
        if (!encontrado) {
            System.out.println("O nome não foi encontrado.");
            return;
        }
        l.remove(pos);
        System.out.println("O nome "+ nE +" foi excluido.");
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}