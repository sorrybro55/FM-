import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class IO {


    public static void showTeam(FootballTeam team){
        System.out.println(team);
    }

    public static void showPlayer(FootballPlayer player){
        System.out.println(player);
    }

    public static void showGame(FootballMatch fm){
        System.out.println(fm);
    }



    public  static String chooseName(){
        Scanner sc = new Scanner(System.in);
        String name = null;
        while(name == null){
            System.out.print("Digite Nome: ");
            name = sc.nextLine();
        }
        return name;
    }


    public static int  chooseNumber(){
        Scanner sc = new Scanner(System.in);
        int number = -1;
        do{
            System.out.print("Digite Numero: ");
            try {
                number = sc.nextInt();
            } catch (InputMismatchException e){
                number = -1;
                sc.nextLine();
            }
            if(number <0 ){
                System.out.println("Numero Invalido");
                number = -1;
            }
        }while (number == -1);

        return number;
    }

    public static int chooseAbility(String ability){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Digite Valor De ").append(ability).append(": ");
        int value = -1;
        do{
            System.out.print(sb.toString());
            try{
                value = sc.nextInt();
            }catch (InputMismatchException e){
                value = -1;
                sc.nextLine();
            }
            if(value <0 || value > 100){
                System.out.println("Valor Invalido");
                value = -1;
            }
        } while( value == -1);

        return value;
    }

    public static Position choosePosition(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("1: Guarda-Redes:\n");
        sb.append("2: Defesa:\n");
        sb.append("3: Lateral:\n");
        sb.append("4: Medio:\n");
        sb.append("5: Avancado:\n");
        sb.append("Escolha Posicao: ");
        int option = -1;
        do{
            System.out.print(sb.toString());
            try{
                option = sc.nextInt();
            }catch (InputMismatchException e){
                option = -1;
                sc.nextLine();
            }
            if(option <1 || option > 5){
                System.out.println("Valor Invalido");
                option = -1;
            }
        }while (option == -1);
        switch (option){
            case 1:
                return Position.GOALKEEPER;
            case 2:
                return Position.DEFENDER;
            case 3:
                return Position.WINGER;
            case 4:
                return Position.MIDFIELDER;
            case 5:
                return Position.STRIKER;
            default:
                return Position.ND;
        }
    }



    public static void showPlayers(Iterator<FootballPlayer> it){
        FootballPlayer fp = null;
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            fp = it.next();
            if(fp.getNumber()<10)
                sb.append(" ");
            sb.append(fp.toStringSimple());
            if(it.hasNext())
                sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void showFutureSubstitutions(Iterator<Map.Entry<Integer,Map<Integer,Integer>>> it){
        StringBuilder sb = new StringBuilder();
        Map.Entry<Integer,Map<Integer,Integer>> me = null;
        while(it.hasNext()){
            me = it.next();
            String when = null;
            switch (me.getKey())
            {
                case 2 :
                    when = "Primeira Parte";
                    break;
                case 8:
                    when = "Segunda Parte";
                    break;
                default:
                    when = "Intervalo";

            }
            if(!me.getValue().isEmpty())
                sb.append(when).append(": ");
            for(Map.Entry<Integer,Integer> x: me.getValue().entrySet())
                sb.append(x.getValue()).append(" -> ").append(x.getKey()).append("   ");
            if(!me.getValue().isEmpty())
                sb.append("\n");
        }

            System.out.print(sb);


    }

    public static void message(String message){
        System.out.println(message);
    }

    public static void newLine(){
        System.out.println();
    }

    public static  void pressEnter(){
        System.out.print("Pressione Enter Para Continuar! ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println();
    }

    public static String getFileName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite Nome Do Ficheiro: ");
        String fileName = sc.nextLine();
        return fileName;
    }







}
