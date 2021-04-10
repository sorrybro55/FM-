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
                    makeGame(state);
                    break;
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



    public static void makeGame(State state){
        FootballTeam home = selectTeam(state);
        FootballTeam away = selectTeam(state);
        FootballMatch fm = new FootballMatch(MatchState.TOSTART, 0, 0, 0, 0, home, away, new ArrayList<FootballPlayer>(), new ArrayList<FootballPlayer>());
        makeLineUPs(fm);
        fm.setState(MatchState.FIRSTHALF);
        while(fm.getState() != MatchState.FINISHED) {
            if (fm.clock() >= 600000 && fm.clock() < 1200000) {
                fm.setState(MatchState.STOPED);
                makeSubstitutions(fm);
                fm.setState(MatchState.FIRSTHALF);
            }
            if (fm.clock() >= 1200000 && fm.getState() == MatchState.FIRSTHALF) {
                fm.setState(MatchState.INTERVALL);
                makeSubstitutions(fm);
                fm.setState(MatchState.SECONDHALF);
            }
            if (fm.clock() >= 1800000 && fm.clock() < 2400000) {
                fm.setState(MatchState.STOPED);
                makeSubstitutions(fm);
                fm.setState(MatchState.SECONDHALF);
            }
            if (fm.clock() >= 2400000)
                fm.setState(MatchState.FINISHED);
        }
    }

    public static void makeLineUPs(FootballMatch fm){
        while(IO.wantToMakeChange(1)){
            int out = IO.choosePlayerStartingHome(fm);
            int in = IO.choosePlayerBenchHome(fm);
            fm.substitutionHome(in, out);
        }
        while(IO.wantToMakeChange(2)){
            int out = IO.choosePlayerStartingHome(fm);
            int in = IO.choosePlayerBenchHome(fm);
            fm.substitutionHome(in, out);
        }
    }

    public static  void makeSubstitutions(FootballMatch fm){
        while(fm.getReplacedHome().size() <3 && IO.wantToMakeChange(1)){
            int out = IO.choosePlayerStartingHome(fm);
            int in = IO.choosePlayerBenchHome(fm);
            fm.substitutionHome(in, out);
        }
        while(fm.getReplacedAway().size() <3 && IO.wantToMakeChange(2)) {
            int out = IO.choosePlayerStartingHome(fm);
            int in = IO.choosePlayerBenchHome(fm);
            fm.substitutionHome(in, out);
        }

    }







    public void saveState(State state){


    }
    public void loadState(State state){

    }
}





