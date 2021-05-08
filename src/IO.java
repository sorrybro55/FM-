import java.util.Scanner;

public class IO {
/*
    public  static int initialMenu(){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Menu Inicial\n\n");
        sb.append(("0. Sair\n"));
        sb.append("1. Fazer Jogo\n");
        sb.append("2. Gerir Jogadores:\n");
        sb.append("3. Gerir Equipas: \n");
        sb.append("4. Ler Jogo\n");
        sb.append("5. Gravar Jogo\n");
        while(option <0 || option >5 ){
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

    public static int  chooseNumber(){
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while(number<0 || number>99){
            System.out.print("Digite Idade: ");
            number = sc.nextInt();

        }
        return number;
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

    public static String chooseTeamName(State state){
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
            FootballTeam team = TeamsController.selectTeam(state);
            if(team!=null)
                return team.getName();
        }
        return "Sem Equipa";

    }

    public static int chooseTeam(State state){
        if(state.getTeams().size() ==0)
            return -1;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int size = state.getTeams().size();
        while(option<1 || option > size){
            System.out.print(state.showTeams());
            System.out.print("Escolha Equipa: ");
            option = sc.nextInt();
        }
        return option-1;
    }

    public static int chooseTeam(State state, String player){
        if(state.getTeams().size() ==0)
            return -1;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int size = state.getTeams().size();
        while(option<1 || option > size){
            System.out.print(state.showTeams());
            System.out.printf("Escolha Equipa %s: \n",player);
            option = sc.nextInt();
        }
        return option-1;
    }

    public static boolean wantToMakeChange(int player) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Jogador ").append(player).append("\nDeseja fazer alteracao: 1.Sim  2.Nao: ");
        int option = -1;
        while (option < 0 || option > 2) {
            System.out.println(sb.toString());
            option = sc.nextInt();
        }
        return option == 1;
    }

    public static int choosePlayerStartingHome(FootballMatch fm){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        int size = fm.getHome().getStarting().size() - fm.getReplacedHome().size();
        while (option < 1 || option > size) {
            System.out.println(fm.showStartingHome());
            System.out.println("Escolha Jogador: ");
            option = sc.nextInt();
        }
        return option-1;
    }

    public static int choosePlayerBenchHome(FootballMatch fm){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        int size = fm.getHome().getBench().size() - fm.getReplacedHome().size();
        while (option < 1 || option > size) {
            System.out.println(fm.showBenchHome());
            System.out.println("Escolha Jogador: ");
            option = sc.nextInt();
        }
        return option -1;
    }

    public static int choosePlayerStartingAway(FootballMatch fm){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        int size = fm.getAway().getStarting().size() - fm.getReplacedAway().size();
        while (option < 1 || option > size) {
            System.out.println(fm.showStartingAway());
            System.out.println("Escolha Jogador: ");
            option = sc.nextInt();
        }
        return option -1;
    }

    public static int choosePlayerBenchAway(FootballMatch fm){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        int size = fm.getAway().getBench().size() - fm.getReplacedAway().size();
        while (option < 1 || option > size) {
            System.out.println(fm.showBenchAway());
            System.out.println("Escolha Jogador: ");
            option = sc.nextInt();
        }
        return option -1;
    }


*/



}
