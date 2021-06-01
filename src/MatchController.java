import java.util.*;

public class MatchController {
    private FootballMatch match;
    private int attacking;

    public MatchController(){
        this.match = new FootballMatch();
        this.attacking = 1;
    }

    public MatchController(FootballMatch fm){
        this.match = fm.clone();
        this.attacking = 1;
    }

    public MatchController(MatchController mc){
        this.match = mc.getMatch();
        this.attacking = mc.getAttacking();
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

    public int getAttacking(){
        return this.attacking;
    }

    public String teamAttacking(){
        if(this.attacking ==1)
            return this.match.getTeamHome();
        else
            return this.match.getTeamAway();
    }

    private void switchAttacking(){
        if (this.attacking == 1)
            this.attacking = 2;
        else
            this.attacking = 1;
    }

    public void run(){
        IO.message(match.toString());
        IO.newLine();
        this.substitutionsHome();
        this.selectTaticHome();
        IO.newLine();
        this.substitutionsAway();
        this.selectTaticAway();
        IO.newLine();
        IO.message(match.toString());
        IO.newLine();
        IO.message("***Alinhamentos***");
        IO.message(match.getTeamHome());
        IO.showPlayers(match.playingHome().iterator());
        IO.newLine();
        IO.message(match.getTeamAway());
        IO.showPlayers(match.playingAway().iterator());
        this.match.startGame();
        IO.newLine();
        IO.message("Inicio da Partida");


        for(int i=0; i<10; i++){
            IO.newLine();
            IO.message("Ataque: " + this.teamAttacking());
            IO.pressEnter();
            int decision = this.decision();
            switch (decision){
                case 0:
                    IO.message("Perda de Bola");
                    this.switchAttacking();
                    break;
                case 1:
                    IO.message("Lance Perigoso");
                    break;
                case 2:
                    IO.message("Golo!!!");
                    if(this.attacking ==1)
                        this.match.goalHome();
                    else
                        this.match.goalAway();
                    this.switchAttacking();
                    break;
            }
            IO.message(match.score());
            IO.pressEnter();

            if(i==5){
                match.itervall();
                if(this.attacking == 1)
                    this.switchAttacking();
                IO.newLine();
                IO.message("Intervalo");
                IO.message(match.score());
            }


            if(i==2 || i==5 || i==8){
                IO.newLine();
                this.substitutionsHome();
                this.selectTaticHome();
                IO.newLine();
                this.substitutionsAway();
                this.selectTaticAway();
                if(i==5){
                    match.restartGame();
                    IO.newLine();
                    IO.message("Inicio da Segunda Parte");
                    IO.message(match.score());
                }
            }
        }
        this.match.endGame();
        IO.newLine();
        IO.message("Fim do Jogo");
        IO.message(match.score());
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
            if(Arrays.equals(tatics[i], actualTatic))
                r = i;

            System.out.println(r);

        String[] options = {"442", "433", "352"};
        options[r] += " - atual";
        Menu menu = new Menu(options, "Sair","Modelo tatico:" );
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


    private void substitutions(String team){
        List<FootballPlayer> playing;
        List<FootballPlayer> bench;
        Map<Integer,FootballPlayer> squad;

        int option = -1;
        IO.message(team);
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
            IO.showPlayers(playing.iterator());
            IO.newLine();
            IO.message("***Banco***");
            IO.showPlayers(bench.iterator());
            menu.run();
            option = menu.getOption();
            if(option ==1){

                IO.message("Selecione Jogador dos Titulares");
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
    public void substitutionsHome(){
        this.substitutions(match.getTeamHome());
    }

    public void substitutionsAway(){
        this.substitutions(match.getTeamAway());
    }
    
    public int decision(){
        List<Integer> possibilities = new ArrayList<>();
        double attack, defense;
        if (this.attacking == 1){
            attack = this.match.ofensiveOverallHome();
            defense = this.match.defensiveOverallAway();
        }
        else
        {
            attack = this.match.ofensiveOverallAway();
            defense = this.match.defensiveOverallHome();
            
        }
        double total = attack + defense;
        attack *= 0.7;
        defense *= 0.7;
        int i = (int) (defense*100/total)/10;
        int j = (int) (attack*100/total)/10;
        int k = 10 - i - j;

        for(int l=0; l<i; l++)
            possibilities.add(0);
        for(int l=0; l<j; l++  )
            possibilities.add(1);
        for(int l=0; l<k; l++)
            possibilities.add(2);
        Random random = new Random();
        int r = random.nextInt(10);
        return possibilities.get(r);
    }




}

