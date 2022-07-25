package jogodavelha;

import java.util.Scanner;
import java.util.Random;
public class JogoDaVelha {
    
    private static Scanner teclado = new Scanner(System.in);
    private static String player1, player2;
    private static char typeplayer1, typeplayer2;
    private static String[][] old = new String[3][3];
    private static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("Jogo da Velha");
        System.out.println("-------------");
        player();
        game();
    }
    
    private static void player () {
        boolean namerept = true;
        do {
            System.out.printf("jogador X: (H)omem ou (M)aquina? ");
            typeplayer1 = teclado.nextLine().trim().charAt(0);
            if (typeplayer1 == 'h' ||typeplayer1 == 'H') {
                System.out.printf("Nome do Jogador X:");
                player1 = teclado.nextLine();
                namerept = false;
            }
            else if (typeplayer1 == 'M'|| typeplayer1 == 'm' ) {
                player1 = "Machine_X";
                namerept = false;
            }
            else{
                System.out.println("entrada invalida");
            }
        }while (namerept);
        
        namerept = true;
        do {
            System.out.printf("jogador O: (H)omem ou (M)aquina? ");
            typeplayer2 = teclado.nextLine().trim().charAt(0);
            if (typeplayer2 == 'h' ||typeplayer2 == 'H') {
                System.out.printf("Nome do Jogador O:");
                player2 = teclado.nextLine();
                namerept = false;
            }
            else if (typeplayer2 == 'M'|| typeplayer2 == 'm' ) {
                player2 = "Machine_O";
                namerept = false;
            }
            else{
                System.out.println("entrada invalida");
            }
        }while (namerept);
    }
    
    private static void game () {
        int i,j,contador,win;
        win = 0;
        contador = 1;
        for (i=0;i<3;i++) {
            for (j=0;j<3;j++) {
                old[i][j] = " ";
            }
        }
        boolean rept= true;
        
        do{
            printgrade();
            if (contador % 2 == 1 ) {
                if (typeplayer1 == 'h'|| typeplayer1 == 'H') {
                    System.out.println("");
                    System.out.printf("Jogue %s (Linha e Coluna):",player1);
                    i = teclado.nextInt();
                    j = teclado.nextInt();
                    if (!old[i-1][j-1].equals(" ")) {
                        System.out.println("Desqualificado");
                        System.out.printf("Jogador %s Ganhou%n",player2);
                        rept = false;
                    }
                    else
                    old[i-1][j-1] =  "X" ;
                }
                else if (typeplayer1 == 'm' || typeplayer1 == 'M') {
                    System.out.println("");
                    machine(contador);
                }
            }
            else if (contador % 2 == 0) {
               if (typeplayer2 == 'h'|| typeplayer2 == 'H') {
                    System.out.println("");
                    System.out.printf("Jogue %s (Linha e Coluna):",player2);
                    i = teclado.nextInt();
                    j = teclado.nextInt();
                    if (!old[i-1][j-1].equals(" ")) {
                        System.out.println("Desqualificado");
                        System.out.printf("Jogador %s Ganhou%n",player1);
                        rept = false;
                    }
                    else
                    old[i-1][j-1] =  "O" ;
                }
                else if (typeplayer2 == 'm' || typeplayer2 == 'M') {
                    System.out.println("");
                    machine(contador);
                }
            }
            
            contador ++;
            
            if (contador >=5)
               win = winer();
            if (win == 1) {
                rept = false;
            }
        }while (rept);  
    }
    
    private static int winer(){
        if (old[0][0].equals("X") && old[1][0].equals("X") && old[2][0].equals("X")||
               old[0][1].equals("X") && old[1][1].equals("X") && old[2][1].equals("X")||
               old[0][2].equals("X") && old[1][2].equals("X") && old[2][2].equals("X")) {
            System.out.printf("Jogador %s GANHOU %n",player1);
            printgrade();
            return 1;
        }
        else if (old[0][0].equals("O") && old[1][0].equals("O") && old[2][0].equals("O")||
               old[0][1].equals("O") && old[1][1].equals("O") && old[2][1].equals("O")||
               old[0][2].equals("O") && old[1][2].equals("O") && old[2][2].equals("O")) {
            System.out.printf("Jogador %s GANHOU %n",player2);
            printgrade();
            return 1;
        }
        if (old[0][0].equals("X") && old[0][1].equals("X") && old[0][2].equals("X")||
               old[1][0].equals("X") && old[1][1].equals("X") && old[1][2].equals("X")||
               old[2][0].equals("X") && old[2][1].equals("X") && old[2][2].equals("X")) {
            System.out.printf("Jogador %s GANHOU %n",player1);
            printgrade();
            return 1;
        }
         else if (old[0][0].equals("O") && old[0][1].equals("O") && old[0][2].equals("O")||
               old[1][0].equals("O") && old[1][1].equals("O") && old[1][2].equals("O")||
               old[2][0].equals("O") && old[2][1].equals("O") && old[2][2].equals("O")) {
            System.out.printf("Jogador %s GANHOU %n",player2);
            printgrade();
            return 1;
        }
        if (old[0][0].equals("X") && old[1][1].equals("X") && old[2][2].equals("X")||
               old[0][2].equals("X") && old[1][1].equals("X") && old[2][0].equals("X")) {
            System.out.printf("Jogador %s GANHOU %n",player1);
            printgrade();
            return 1;
        }
        else if (old[0][0].equals("O") && old[1][1].equals("O") && old[2][2].equals("O")||
               old[0][2].equals("O") && old[1][1].equals("O") && old[2][0].equals("O")) {
            System.out.printf("Jogador %s GANHOU %n",player2);
            printgrade();
            return 1;
        }
        if (!old[0][0].equals(" ") && !old[0][1].equals(" ") && !old[0][2].equals(" ")&&
               !old[1][0].equals(" ") && !old[1][1].equals(" ") && !old[1][2].equals(" ")&&
               !old[2][0].equals(" ") && !old[2][1].equals(" ") && !old[2][2].equals(" ")) {
            System.out.println("DEU VELHA");
            printgrade();
            return 1;
        }
        else 
            return 0;
    }
    
    private static void printgrade(){
        System.out.printf("  1   2   3 %n");
        System.out.printf("1 %s | %s | %s %n",old[0][0],old[0][1],old[0][2]);
        System.out.printf(" ---+---+---%n");
        System.out.printf("2 %s | %s | %s %n",old[1][0],old[1][1],old[1][2]);
        System.out.printf(" ---+---+---%n");
        System.out.printf("3 %s | %s | %s %n",old[2][0],old[2][1],old[2][2]);
    }
    
    private static void machine(int cont){
        int i,j;
        try {
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
        if(cont % 2 == 1){
            while(true){
                i = random.nextInt(3)+1;
                j = random.nextInt(3)+1;
                if(old[i-1][j-1].equals(" ")){
                    System.out.printf("Jogue %s (Linha e Coluna):%d %s %n",player1,i,j);
                    old[i-1][j-1] = "X";
                    break;
                }
            }
        }
        if(cont % 2 == 0){
            while(true){
                i = random.nextInt(3)+1;
                j = random.nextInt(3)+1;
                if(old[i-1][j-1].equals(" ")){
                    System.out.printf("Jogue %s (Linha e Coluna):%d %s %n",player2,i,j);
                    old[i-1][j-1] = "O";
                    break;
                }
            }
        }
    }
}