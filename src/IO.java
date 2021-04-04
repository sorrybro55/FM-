import java.util.Scanner;

public class IO {

    public  static int initialMenu(){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Menu Inicial\n\n");
        sb.append(("0. Sair\n"));
        sb.append("1. Comecar Novo Jogo\n");
        sb.append("2. Ler Jogo");
        sb.append("3. Gravar Jogo");
        while(option <0 || option >3 ){
            System.out.println(sb.toString());
            option = sc.nextInt();
        }
        return option;
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

    public static int  chooseAge(){
        Scanner sc = new Scanner(System.in);
        int age = 0;
        while(age<18 || age>40){
            System.out.print("Digite Idade: ");
            age = sc.nextInt();

        }
        return age;
    }

    public static int chooseAbility(String ability){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Digite Valor De ").append(ability).append(": ");
        int value = -1;
        while( value < 0 || value >100){
            System.out.print(sb.toString());
            value = sc.nextInt();

        }
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
        while(option <0 || option >5){
            System.out.print(sb.toString());
            option = sc.nextInt();
        }
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

    public static String chooseTeam(State state){
        StringBuilder sb = new StringBuilder();
        sb.append("Deseja escoler Equipa?\n");
        sb.append("1.Sim ").append("2.Nao: ");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option <1 || option > 2){
            System.out.print(sb.toString());
            option = sc.nextInt();
        }
        if(option ==1){
            System.out.println();
            FootballTeam team = selectTeam(state);
            if(team!=null)
                return team.getName();
        }
        return "Sem Equipa";

    }

    public static FootballTeam selectTeam(State state){
        if(state.getTeams().size() ==0)
            return null;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(option<1 || option> state.getTeams().size()){
            System.out.print(state.showTeams());
            System.out.print("Escolha Equipa: ");
            option = sc.nextInt();
        }
        return state.getTeam(option-1);
    }



}
