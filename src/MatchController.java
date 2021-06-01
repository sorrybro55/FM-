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

    public void run(){
        this.selectTaticHome();
        this.selectElevenHome();
        this.selectTaticAway();
        this.selectElevenAway();
    }

    private void selectTatic(String team){
        int[] actualTatic;
        if(team.equals(match.getTeamHome()))
            actualTatic = match.getTaticHome();
        else
            actualTatic = match.getTaticAway();
        int[][] tatics ={ {1,2,2,4,2}, {1,2,2,3,3}, {1,3,2,3,2}};
        int r = 0;
        for(int i=0; i<tatics.length; i++)
            if(tatics[i].equals(actualTatic))
                r = i;

        String[] options = {"442", "433", "352"};
        options[r] += " - atual";
        Menu menu = new Menu(options, "Sair","Escolha modelo tatico" );
        int option = -1;
        do{
            menu.run();
            option = menu.getOption();
        }while (option <0 || option> options.length);
        if (option !=0)
        {
            if(team == match.getTeamHome())
                match.setTaticHome(tatics[option-1]);
            else
                match.setTaticAway(tatics[option-1]);
        }
    }

    public void selectTaticHome(){
        selectTatic(match.getTeamHome());
    }

    public void selectTaticAway(){
        selectTatic(match.getTeamAway());
    }


    private void selectEleven(String team){
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
            IO.newLine();
            IO.message("***Titulares***");
            IO.newLine();
            IO.showPlayers(playing.iterator());
            IO.newLine();
            IO.message("***Banco***");
            IO.newLine();
            IO.showPlayers(bench.iterator());
            menu.run();
            option = menu.getOption();
            if(option ==1){

                IO.message("Selecione Jogador dos Titular");
                int out = IO.chooseNumber();
                IO.message("Selecione Jogador dos Titulares/Banco");
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
    public void selectElevenHome(){
        this.selectEleven(match.getTeamHome());
    }

    public void selectElevenAway(){
        this.selectEleven(match.getTeamAway());
    }




}

