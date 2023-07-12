package br.com.senac.prejetointegradorteste;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int confirma = 0;

        while (confirma != 2) {
            Classes.separaconta();
            System.out.println("""
                    Você deseja continuar?
                    (1)Sim
                    (2)Não
                    """);
            confirma = ler.nextInt();
        }
        System.out.println("Finalizando programa.");
    }
}
