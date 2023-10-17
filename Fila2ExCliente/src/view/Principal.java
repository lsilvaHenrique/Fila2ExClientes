package view;

import java.util.LinkedList;
import java.util.Queue;

class Cliente {
    String nome;
    int quantidadePecas;
    float valorPecas;

    public Cliente(String nome, int quantidadePecas, float valorPecas) {
        this.nome = nome;
        this.quantidadePecas = quantidadePecas;
        this.valorPecas = valorPecas;
    }
}

class OperacaoController {
    public static void caixa(Queue<Cliente> fila) {
        while (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            float valorTotal = cliente.quantidadePecas * cliente.valorPecas;
            System.out.println("Cliente: " + cliente.nome);
            System.out.println("Valor Total da Compra: R$" + valorTotal);
        }
    }
}

public class Principal {
    public static void main(String[] args) {
        Queue<Cliente> fila = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            String nome = "Cliente" + i;
            int quantidadePecas = (int) (Math.random() * 31) + 20;  // Quantidade entre 20 e 50
            float valorPecas = (float) (5.00 + Math.random() * 95.00);  // Valor entre 5.00 e 100.00
            Cliente cliente = new Cliente(nome, quantidadePecas, valorPecas);
            fila.offer(cliente);
        }

        OperacaoController.caixa(fila);
    }
}
