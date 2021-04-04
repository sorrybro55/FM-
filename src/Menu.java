import java.util.Scanner;

public class Menu {

    public static int initial(){
        StringBuilder sb = new StringBuilder();
        sb.append("Menu Inicial\n\n");
        sb.append(("0. Sair\n"));
        sb.append("1. Comecar Novo Jogo\n");
        sb.append("2. Ler Jogo");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();


    }
}
