import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PlayersController {

    public  static void run(State state){
        transferPalyer(state);

    }

    public static void showPlayer(State state){
        

    }

    public  static void createPlayer(State state){
        String name = IO.chooseName();
        Position position = IO.choosePosition();
        int number = IO.chooseNumber();
        int speed = IO.chooseAbility("Velocidade");
        int stamina = IO.chooseAbility("Resistencia");
        int agility = IO.chooseAbility("Agilidade");
        int jumping = IO.chooseAbility("Impulsao");
        int heading = IO.chooseAbility("Jogo de Cabeca");
        int finishing = IO.chooseAbility("Capaciadade de Remate");
        int passing = IO.chooseAbility("Capacidade de Passe");
        int elasticity = 0;
        int recovery = 0;
        int crossing = 0;
        if(position == Position.GOALKEEPER)
            elasticity = IO.chooseAbility("Elasticidade");
        if(position == Position.MIDFIELDER)
            recovery = IO.chooseAbility("Recuperacao");
        if(position == Position.WINGER)
            recovery = IO.chooseAbility("Cruzamento");

        String team = "Sem Equipa";

        switch (position){
            case GOALKEEPER:
                state.addPlayer(new GoalKeeper(name, number, speed, stamina, agility, jumping, heading, finishing, passing, elasticity, team, new ArrayList<String>()));
                break;
            case DEFENDER:
                state.addPlayer(new Defender(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, new ArrayList<String>()));
                break;
            case WINGER:
                state.addPlayer(new Winger(name, number, speed, stamina, agility, jumping, heading, finishing, passing, crossing, team, new ArrayList<String>()));
                break;
            case MIDFIELDER:
                state.addPlayer(new MidFielder(name, number, speed, stamina, agility, jumping, heading, finishing, passing, recovery, team, new ArrayList<String>()));
                break;
            case STRIKER:
                state.addPlayer(new Striker(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, new ArrayList<String>()));
                break;
        }
    }

    public static void transferPalyer(State state){
        String player = selectPlayer(state);
        String team = selectTeam(state);
        state.transferPlayer(player,team);

    }

    public static String selectPlayer(State state){
        Iterator<Map.Entry<String, FootballPlayer>> iteratorPlayers = state.getPlayers().entrySet().iterator();
        int option = IO.selectPlayer(iteratorPlayers);
        iteratorPlayers = state.getPlayers().entrySet().iterator();
        Map.Entry<String,FootballPlayer> mapEntryPlayer = null;
        while(option>0){
            mapEntryPlayer = iteratorPlayers.next();
            option--;
        }
        if(mapEntryPlayer == null)
            return null;
        return mapEntryPlayer.getKey();
    }

    public static  String selectTeam(State state){
        Iterator<Map.Entry<String, FootballTeam>> iteratorTeams = state.getTeams().entrySet().iterator();
        int option = IO.selectTeam(iteratorTeams);
        iteratorTeams = state.getTeams().entrySet().iterator();
        Map.Entry<String,FootballTeam> mapEntryTeam = null;
        while(option>0){
            mapEntryTeam = iteratorTeams.next();
            option--;
        }
        if(mapEntryTeam == null)
            return null;
        return mapEntryTeam.getKey();

    }




   /* public static FootballTeam selectTeam(State state){
        if(state.getTeams().size() ==0)
            return null;
        int option = IO.chooseTeam(state);
        return state.getTeam(option);
    }
*/



}
