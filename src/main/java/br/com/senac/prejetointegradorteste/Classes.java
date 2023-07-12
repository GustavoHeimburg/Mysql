package br.com.senac.prejetointegradorteste;

import java.util.Scanner;

public class Classes {
    private static String nomeConta;
    private static String senhaConta;

    public static int auxconta() {
        Scanner ler = new Scanner(System.in);
        int inicio = 0;
        while (inicio != 1 && inicio != 2) {
            System.out.println(""" 
                    *********************************
                    Bem-vindo ao banco seccobe!
                    Escolha uma das seguintes opções:
                                    
                    (1) Logar em uma Conta existente.
                    (2) Cadastrar uma nova conta.
                    *********************************
                    """);
            inicio = ler.nextInt();
            if (inicio != 1 && inicio != 2) {
                System.out.println("Por-favor, digite um valor valido! \n");
            }
        }
        return inicio;
    }

    public static String criarNomeConta(){
        Scanner ler = new Scanner (System.in);
        System.out.println("Por favor, digite o nome da conta que deseja criar: ");
        nomeConta = ler.nextLine();
        return nomeConta;
    }

    public static String criarSenhaConta(){
        Scanner ler = new Scanner (System.in);
        System.out.println("Digite a senha da conta que deseja criar: ");
        senhaConta = ler.nextLine();
        return senhaConta;
    }

    public static void separaconta() {
        Scanner ler = new Scanner(System.in);
        int inicio = auxconta();

        if (inicio == 2) {
            System.out.println("Deseja criar conta. Proecando dados...");
            String nomeConta = criarNomeConta();
            String senhaConta = criarSenhaConta();
            System.out.println("Conta criada com sucesso! \nNome: " + nomeConta + "\nSenha: " + senhaConta);
        }  else if (inicio == 1) {
            System.out.println("Deseja logar na conta. Processando dados...");
            System.out.println("Digite o nome da sua conta: ");
            String contaNome = ler.nextLine();
            System.out.println("Digite a senha da sua conta: ");
            String contaSenha = ler.nextLine();

            if (contaNome.equals(nomeConta) && contaSenha.equals(senhaConta)){
                System.out.println("login permitido!! \n");
            } else {
                System.out.println("login negado");
            }
        }
    }
}
