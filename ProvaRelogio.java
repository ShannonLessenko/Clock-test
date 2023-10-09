package aplication;

import java.util.Scanner;

public class ProvaRelogio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite as horas (0-23): ");
        int hora = scanner.nextInt();

        System.out.print("Digite os minutos (0-59): ");
        int minuto = scanner.nextInt();

        //Verifica se é um horário válido.
        if ( hora > 24 || hora < 0 || minuto > 59 || minuto < 0) {
            System.out.println("Hora ou minuto inválido.");
            return;
        }
        //Método que retorna o ângulo do relógio.
        int retornaAngulo = retornaAnguloRelogio(hora, minuto);

        System.out.println("O ângulo entre os ponteiros do relógio é: " + retornaAngulo + " graus.");

        scanner.close();
    }

    private static int retornaAnguloRelogio(int hora, int minuto) {

        // Converte as 24h para as 12h do relógio.
        hora = hora % 12;

        int anguloHora = (360 * hora) / 12;
        int anguloMinuto = (360 * minuto) / 60;
        int anguloTotal = Math.abs(anguloMinuto - anguloHora);

        // Pega o menor ângulo entre os ponteiros.
        if(anguloTotal > 180){
            anguloTotal = 360 - anguloTotal;
        }

        return anguloTotal;
    }
}