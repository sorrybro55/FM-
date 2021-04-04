import java.util.ArrayList;

public class Controller {

    public static void run() {
    State state = generateState();

    while (true) {
            int option = IO.initialMenu();
            switch (option) {
                case 0:
                    return;
                case 1:
                    //
                case 2:
                    ////
            }

        }
    }

    public  static void createPlayer(State state){
        String name = IO.chooseName();
        int age = IO.chooseAge();
        Position position = IO.choosePosition();
        int speed = IO.chooseAbility("Velocidade");
        int stamina = IO.chooseAbility("Resistencia");
        int agility = IO.chooseAbility("Agilidade");
        int heading = IO.chooseAbility("Jogo de Cabeca");
        int finishing = IO.chooseAbility("Capaciadade de Remate");
        int passing = IO.chooseAbility("Capacidade de Passe");
        int elasticity = 0;
        if(position == Position.GOALKEEPER)
            elasticity = IO.chooseAbility("Elasticidade");

        String team = IO.chooseTeamName(state);

        switch (position){
            case GOALKEEPER:
                state.addPlayer(new GoalKeeper(name, age,speed, stamina, agility, heading, finishing, passing, elasticity, team, new ArrayList<String>()));
                break;
            case DEFENDER:
                state.addPlayer(new Defender(name, age,speed, stamina, agility, heading, finishing, passing, team, new ArrayList<String>()));
                break;
            case WINGER:
                state.addPlayer(new Winger(name, age,speed, stamina, agility, heading, finishing, passing, team, new ArrayList<String>()));
                break;
            case MIDFIELDER:
                state.addPlayer(new MidFielder(name, age,speed, stamina, agility, heading, finishing, passing, team, new ArrayList<String>()));
                break;
            case STRIKER:
                state.addPlayer(new Striker(name, age,speed, stamina, agility, heading, finishing, passing, team, new ArrayList<String>()));
                break;
        }
    }

    public static FootballTeam selectTeam(State state){
        if(state.getTeams().size() ==0)
            return null;
        int option = IO.chooseTeam(state);
        return state.getTeam(option);
    }






    public  static State generateState(){
        State state = new State();
        return  state;
    }





    public void saveState(State state){


    }
    public void loadState(State state){

    }
}





