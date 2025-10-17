/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication32;

import java.util.*;



public class JogoInverterPalavras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> frases = new ArrayList<>();
        Deque<String> pilhaInversoes = new ArrayDeque<>();
        int opcao = 0;
        while (true) {
            System.out.println("1 - Inverter nova frase");
            System.out.println("2 - Ver frases já inseridas ");
            System.out.println("3 - Desfazer última inversão");
            System.out.println("4 - Inverter letras de cada palavra");
            System.out.println("5 - Sair");
            String linha = sc.nextLine().trim();
            if (linha.isEmpty()) continue;
            try {
                opcao = Integer.parseInt(linha);
            } catch (Exception e) {
                System.out.println("Opção inválida");
                continue;
            }
            if (opcao == 5) break;
            if (opcao == 1) {
                System.out.println("Digite uma frase:");
                String frase = sc.nextLine().trim();
                if (frase.isEmpty()) {
                    System.out.println("Frase vazia.");
                    continue;
                }
                frases.add(frase);
                String[] palavras = frase.trim().split("\\s+");
                Deque<String> pilha = new ArrayDeque<>();
                int i = 0;
                while (i < palavras.length) {
                    pilha.push(palavras[i]);
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                while (!pilha.isEmpty()) {
                    sb.append(pilha.pop()).append(" ");
                }
                String invertida = sb.toString().trim();
                System.out.println("Original: " + frase);
                System.out.println("Invertida: " + invertida);
                if (pilhaInversoes.size() == 5) pilhaInversoes.removeFirst();
                pilhaInversoes.addLast(frase + "||" + invertida);
            } else if (opcao == 2) {
                if (frases.isEmpty()) {
                    System.out.println("Nenhuma frase armazenada.");
                    continue;
                }
                List<String> copia = new ArrayList<>(frases);
                Collections.sort(copia);
                int j = 0;
                while (j < copia.size()) {
                    System.out.println(copia.get(j));
                    j++;
                }
            } else if (opcao == 3) {
                if (pilhaInversoes.isEmpty()) {
                    System.out.println("Nada para desfazer.");
                    continue;
                }
                String item = pilhaInversoes.removeLast();
                int sep = item.indexOf("||");
                String orig = sep >= 0 ? item.substring(0, sep) : item;
                String inv = sep >= 0 ? item.substring(sep + 2) : "";
                System.out.println("Desfeito:");
                System.out.println("Original: " + orig);
                System.out.println("Invertida: " + inv);
            } else if (opcao == 4) {
                System.out.println("Digite uma frase:");
                String frase = sc.nextLine().trim();
                if (frase.isEmpty()) {
                    System.out.println("Frase vazia.");
                    continue;
                }
                frases.add(frase);
                String[] palavras = frase.trim().split("\\s+");
                StringBuilder sb = new StringBuilder();
                int k = 0;
                while (k < palavras.length) {
                    sb.append(new StringBuilder(palavras[k]).reverse()).append(" ");
                    k++;
                }
                String invertida = sb.toString().trim();
                System.out.println("Original: " + frase);
                System.out.println("Invertida: " + invertida);
                if (pilhaInversoes.size() == 5) pilhaInversoes.removeFirst();
                pilhaInversoes.addLast(frase + "||" + invertida);
            } else {
                System.out.println("Opção inválida");
            }
        }
        sc.close();
    }
}
