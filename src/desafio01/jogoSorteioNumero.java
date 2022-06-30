package desafio01;

import java.util.Random;
import java.util.Scanner;

public class jogoSorteioNumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random aleatorio = new Random();

        System.out.println("-------Jogo da Adivinhação-------");
        System.out.println();
        System.out.println("**Tente descobrir qual numero foi o sorteado**");
        System.out.println();
        System.out.println("-----Como funciona o jogo?-----");
        System.out.println();
        System.out.println("- Escolha a dificuldade do jogo;\n- Digite um numero aleatório dentro do intervalo escolhido;\n- Se o numero digitado for igual ao sorteado você vence;");
        System.out.println("- Se o número digitado estiver próximo do número sorteado você ganha 5 pontos\n- Se o número digitado estiver distante do sorteado você perde o jogo;");
        System.out.println();

        int numeroaleatorio = 0;
        int numeroUsuario = 0;
        int novoJogo = 0;
        int pontuacaoTotal = 0;

        while (novoJogo != 2) {

            System.out.print("Selecione a Dificuldade do jogo: (1) Fácil -  (2) Normal -  (3) Difícil : ");
            int dificuldade = input.nextInt();

            switch (dificuldade) {
                case 1:
                    numeroaleatorio = aleatorio.nextInt(5);
                    System.out.print("Digite um número aleatório de 0 a 10: ");
                    numeroUsuario = input.nextInt();
                    break;
                case 2:
                    numeroaleatorio = aleatorio.nextInt(50);
                    System.out.print("Digite um número aleatório de 0 a 50: ");
                    numeroUsuario = input.nextInt();
                    break;
                case 3:
                    numeroaleatorio = aleatorio.nextInt(100);
                    System.out.print("Digite um número aleatório de 0 a 100: ");
                    numeroUsuario = input.nextInt();
                    break;
            }

            int numero = 0;
            int pontos = 0;

            if (numeroUsuario < 0) {
                while (numeroUsuario < 0) {
                    System.out.println("Digite um número maior que 0");
                    numeroUsuario = input.nextInt();
                }
            }

            if (numeroaleatorio == numeroUsuario) {
                System.out.println("O número sorteado foi: " + numeroaleatorio);
                System.out.println("Parabéns você venceu!!!");
                pontos += 10;
                System.out.println("Você conquistou " + pontos + " pontos!");
            } else if (numeroUsuario < numeroaleatorio - 1 || numeroUsuario > numeroaleatorio + 1) {
                System.out.println("Não foi deste vez. O número sorteado foi: " + numeroaleatorio);
                System.out.println("-----Game Over - Voce perdeu :( -----");
            } else {
                pontos += 5;
                System.out.println("Você passou perto e conquistou " + pontos + " pontos!");
                System.out.print("Tente outra vez, digite outro número: ");
                numero = input.nextInt();

                while (numero == numeroUsuario) {
                    System.out.println("Você já digitou esse número. Tente outro número ou '00' para desistir!");
                    numero = input.nextInt();
                }

                if (numero == numeroaleatorio) {
                    System.out.println("O número sorteado foi: " + numeroaleatorio);
                    System.out.println("Parabéns você acertou!!!");
                    pontos += 10;
                    System.out.println("Você conquistou " + pontos + " pontos!");

                } else if (numero > numeroaleatorio + 1 || numero < numeroaleatorio - 1 && numero != 00) {
                    System.out.println("Não foi deste vez. O número sorteado foi: " + numeroaleatorio);
                    System.out.println("Você conquistou " + pontos + " pontos!");
                    System.out.println("-----Game Over - Voce perdeu :( -----");

                } else if (numero == 0) {
                    System.out.println("---Jogo finalizado pelo usuário---");
                    System.out.println("Você conquistou " + pontos + " pontos!");
                }

            }
            System.out.println();
            pontuacaoTotal+=pontos;
            System.out.println("Você ganhou "+pontuacaoTotal+ " pontos até agora.");
            System.out.print("Deseja jogar novamente? 1 - Sim ou 2 - Não : ");
            novoJogo= input.nextInt();
        }
        System.out.println();
        System.out.println("Você conquistou "+pontuacaoTotal+" pontos no total. Parabéns!");
        System.out.println("Fim de jogo!!!");
    }
}
