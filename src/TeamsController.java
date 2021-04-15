public class TeamsController {

    public static void run(State state){

    }


    public static FootballTeam selectTeam(State state){
        if(state.getTeams().size() ==0)
            return null;
        int option = IO.chooseTeam(state);
        return state.getTeam(option);
    }
}
