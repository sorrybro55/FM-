import java.util.ArrayList;
import java.util.List;

public class Test
{

    public static void main(String[] args) {



        State state = new State();
        try {
            state.parse("logs.txt");
        } catch (LinhaIncorretaException e) {
            System.out.println(e.getMessage());
        }
        Controller controller = new Controller(state);
        //controller.run();

        ///*
        FootballTeam team1 = state.getTeam("Mahler Athletic");
        FootballTeam team2 = state.getTeam("Wagner Athletic");
        FootballMatch fm = new FootballMatch(team1,team2);
        MatchController mc = new MatchController(fm);
        mc.run();


    }
}


