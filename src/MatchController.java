import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchController {
    private FootballMatch match;

    public MatchController(){
        this.match = new FootballMatch();
    }

    public MatchController(FootballMatch fm){
        this.match = fm.clone();
    }

    public MatchController(MatchController mc){
        this.match = mc.getMatch();
    }

    public MatchController clone(){
        return new MatchController(this);
    }

    public FootballMatch getMatch(){
        return  this.match.clone();
    }

    public void setMatch(FootballMatch fm){
        this.match = fm;
    }

    public void setEleven(String team){
        List<FootballPlayer> playing;
        List<FootballPlayer> bench;
        Map<Integer,FootballPlayer> squad;


        int option = -1;
        Menu menu =  new Menu(new String[]{"Sim"},"Não", "Deseja Fazer Alterações?");
        do{
            if (team == match.getTeamHome()){
                playing = match.playingHome();
                bench = match.benchHome();
            }
            else{
                playing = match.playingAway();
                bench = match.benchAway();
            }
            IO.message("***Titulares***");
            IO.newLine();
            IO.showPlayers(playing.iterator());
            IO.message("***Banco***");
            IO.newLine();
            IO.showPlayers(bench.iterator());
            menu.run();
            option = menu.getOption();
            if(option ==1){

                IO.message("Jogador a sair");
                int out = IO.chooseNumber();
                IO.message("Jogador a entar");
                int in = IO.chooseNumber();
                try {
                    if(team == match.getTeamHome())
                        match.substitutionHome(in, out);
                    else
                        match.substitutionAway(in, out);
                    
                }catch (SubstitutionsException e){
                    IO.message(e.getMessage());
                }

            }

        } while (option != 0);


    }

    public void setElevenHome(){
        this.setEleven(match.getTeamHome());
    }

    public void setElevenAway(){
        this.setEleven(match.getTeamAway());
    }




}

