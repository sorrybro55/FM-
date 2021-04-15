import java.util.ArrayList;

public class GameController {

    public static void makeGame(State state){
        FootballTeam home = selectTeam(state, "Casa");
        FootballTeam away = selectTeam(state, "Visitante");
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
            int out = IO.choosePlayerStartingAway(fm);
            int in = IO.choosePlayerBenchAway(fm);
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
            fm.substitutionAway(in, out);
        }

    }

    public static FootballTeam selectTeam(State state, String status){
        if(state.getTeams().size() ==0)
            return null;
        int option = IO.chooseTeam(state, status);
        return state.getTeam(option);
    }


}

