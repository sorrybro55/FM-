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
        FootballMatch fm = new FootballMatch();
        FootballTeam team = state.getTeam("Mahler Athletic");
        fm.setSquadHome(team.getSquad());
        List<Integer> aux = new ArrayList<>(team.getSquad().keySet());
        List<Integer> numbers = new ArrayList<>();
        for(int i =0; i <11; i++)
            numbers.add(aux.get(i));
        fm.setPlayersHome(numbers);
        //System.out.println(fm.getSquadHome().keySet());
        //System.out.println(fm.getPlayersHome());

        /*try{
            fm.substitutionHome(20,17);}
        catch (SubstitutionsException e){
            System.out.println(e.getMessage());
        }

        System.out.println(fm.getPlayersHome());*/

        try{
            fm.substitutionHome(20,17);}
        catch (SubstitutionsException e){
            System.out.println(e.getMessage());
        }
        MatchController mc = new MatchController(fm);

        //System.out.println(fm.getPlayersHome());
        //System.out.println(fm.getSquadHome().keySet());
        //System.out.println(fm.getSubstitutionsHome());

        mc.setElevenHome();

        //*/
    }
}


