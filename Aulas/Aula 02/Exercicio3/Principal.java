// Por Grégori Pintarelli

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Principal() {
        Scanner kb = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<Produto>();
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
                    produtosDeCadaSegmento(kb, produtos);
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
            "1 - Cadastrar produto\n" +
            "2 - Listar produtos\n" +
            "3 - Produtos de cada segmento\n" +
            "4 - Alterar produto\n" +
            "5 - Remover produto\n" +
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

    private long segmento(Scanner kb, boolean printError) {
        if (printError) System.out.println("Selecione um número positivo de segmento: ");
        long segmento = 0;
        try {
            segmento = Long.parseLong(kb.next());
            if (segmento < 0) return segmento(kb, true);
        } catch (Exception e) {
            return segmento(kb, true);
        }
        return segmento;
    }

    private void cadastrar (Scanner kb, List<Produto> p) {
        System.out.print("Escreva o nome do produto que sera colocado: ");
        String n = kb.next();
        boolean igualEncontrado = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getNome().equalsIgnoreCase(n)) {
                igualEncontrado = true;
            }
        }
        if (igualEncontrado) System.out.println("Um produto com o nome " + n + " já existe, e assim o produto novo não pode ser cadastrado.");
        else {
            System.out.print("Escreva o segmento do produto que sera colocado: ");
            long s = segmento(kb, false);
            p.add(new Produto(n, s));
            System.out.println("O produto " + n + " foi colocado.");
        }
    }

    private void listar(List<Produto> p) {
        System.out.print("Produtos: [ ");
        if (p.size() <= 0) {System.out.println(" ]."); return;}
        for (int i = 0; i < p.size(); i++) {
            if (i != p.size() - 1) System.out.print(p.get(i) + ", ");
            else System.out.println(p.get(i) + " ].");
        }
    }

    private void produtosDeCadaSegmento (Scanner kb, List<Produto> p) {
        List<Long> segmentos = new ArrayList<Long>();
        String produtosDeCadaSegmento = "-----Produtos de cada segmento:";
        for (Produto produto : p) {
            if (!segmentos.contains(produto.getSegmento()))
                segmentos.add(produto.getSegmento());
        }
        for (Long segmento : segmentos) {
            long pNum = 0;
            produtosDeCadaSegmento += "\n\n---Segmento: " + segmento;
            for (Produto produto : p) {
                if (produto.getSegmento() == segmento) {
                    produtosDeCadaSegmento += "\n" + produto;
                    pNum++;
                }
            }
            produtosDeCadaSegmento += "\nNúmero de produtos " + pNum;
        }
        System.out.println(produtosDeCadaSegmento);
    }

    private void alterar (Scanner kb, List<Produto> p) {
        System.out.print("Escreva um nome de um produto para que ele seja substituido: ");
        String nS = kb.next();
        int pos = 0;
        boolean encontrado = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getNome().equalsIgnoreCase(nS)) {
                encontrado = true;
                pos = i;
            }
        }
        if (!encontrado) {
            System.out.println("O produto com esse nome não foi encontrado.");
            return;
        }
        System.out.print("Produto com nome "+ nS +" encontrado. Escreva o nome do produto que o substituira: ");
        String n = kb.next();
        boolean igualEncontrado = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getNome().equalsIgnoreCase(n)) {
                igualEncontrado = true;
            }
        }
        if (igualEncontrado) System.out.println("Um produto com o nome " + n + " já existe, e assim o produto não pode ser alterado.");
        else {
            System.out.print("Escreva o segmento do produto que substituira o produto original: ");
            long s = segmento(kb, false);
            p.set(pos, new Produto(n, s));
            System.out.println("O produto "+ nS +" foi substituido por "+ n +".");
        }
    }

    private void remover (Scanner kb, List<Produto> p) {
        System.out.print("Escreva o nome do produto que sera excluido: ");
        String nE = kb.next();
        int pos = 0;
        boolean encontrado = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getNome().equalsIgnoreCase(nE)) {
                encontrado = true;
                pos = i;
            }
        }
        if (!encontrado) {
            System.out.println("O produto não foi encontrado.");
            return;
        }
        p.remove(pos);
        System.out.println("O produto com nome "+ nE +" foi excluido.");
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}