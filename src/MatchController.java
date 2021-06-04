import java.util.*;

public class MatchController {
    private FootballMatch match;
    private int attacking;
    private Map<Integer,Map<Integer, Integer>> futureSubstitutionsHome;
    private Map<Integer,Map<Integer, Integer>> futureSubstitutionsAway;


    public MatchController(FootballMatch fm){
        this.match = fm.clone();
        this.attacking = 1;
        this.futureSubstitutionsHome = new TreeMap<>();
        this.futureSubstitutionsAway = new TreeMap<>();
    }

    public FootballMatch getMatch(){
        return  this.match.clone();
    }




    private String teamAttacking(){
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

    private void matchPresentation(){
        IO.message(match.toString());
        IO.newLine();
    }

    private void lineUpHome(){
        this.substitutionsHome();
        this.selectTaticHome();
        IO.newLine();
    }

    private void lineUpAway(){
        this.substitutionsAway();
        this.selectTaticAway();
        IO.newLine();
    }

    private void lineUps(){
        IO.message(match.toString());
        IO.newLine();
        IO.message("***Alinhamentos***");
        IO.newLine();
        IO.message(match.getTeamHome());
        IO.showPlayers(match.playingHome().iterator());
        IO.newLine();
        IO.message(match.getTeamAway());
        IO.showPlayers(match.playingAway().iterator());

    }

    public void run(){
        this.matchPresentation();
        this.lineUpHome();
        this.lineUpAway();
        this.lineUps();
        this.match.startGame();
        IO.newLine();
        IO.message("Inicio da Partida");
        IO.newLine();


        for(int i=0; i<10; i++){

            IO.message("Ataque: " + this.teamAttacking());
            IO.newLine();
            IO.pressEnter();
            int decision = this.decision();
            switch (decision){
                case 0:
                    IO.message("Perda de Bola");
                    this.switchAttacking();
                    break;
                case 1:
                    IO.message("Lance Perigoso!");
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
            IO.newLine();
            IO.message(match.score());
            IO.newLine();
            IO.pressEnter();

            if(i==5){
                match.itervall();
                if(this.attacking == 1)
                    this.switchAttacking();
                IO.newLine();
                IO.message("Intervalo");
                IO.newLine();
                IO.message(match.score());
            }


            if(i==2 || i==5 || i==8){
                IO.newLine();
                this.substitutionsHome();
                this.selectTaticHome();
                IO.newLine();
                this.substitutionsAway();
                this.selectTaticAway();
                IO.newLine();
                if(i==5){
                    match.restartGame();
                    IO.message("Inicio da Segunda Parte");
                    IO.newLine();
                    IO.message(match.score());
                    IO.newLine();
                }
            }
            this.match.decreaseStats(5);
        }
        this.match.endGame();
        IO.newLine();
        IO.message("Fim do Jogo");
        IO.message(match.score());
    }

    public void simulation(){
        this.matchPresentation();
        this.lineUpHome();
        this.programSubstitutionsHome();
        this.lineUpAway();
        this.programSubstitutionsAway();
        this.match.startGame();
        for(int i=0; i<10; i++){
            int decision = this.decision();
            switch (decision){
                case 0:
                    this.switchAttacking();
                    break;
                case 1:
                    break;
                case 2:
                    if(this.attacking ==1)
                        this.match.goalHome();
                    else
                        this.match.goalAway();
                    this.switchAttacking();
                    break;
            }
            if(i==2 || i== 5 || i ==8) {
                if(futureSubstitutionsHome.containsKey(i))
                for(Map.Entry<Integer,Integer> me: this.futureSubstitutionsHome.get(i).entrySet())
                    try {
                        this.match.substitutionHome(me.getKey(),me.getValue());
                    }catch (SubstitutionsException e) {
                        IO.message(e.getMessage());
                    }
                if(futureSubstitutionsAway.containsKey(i))
                    for(Map.Entry<Integer,Integer> me: this.futureSubstitutionsAway.get(i).entrySet())
                        try {
                            this.match.substitutionAway(me.getKey(),me.getValue());
                        }catch (SubstitutionsException e) {
                            IO.message(e.getMessage());
                        }
            }

            if(i==5){
                match.itervall();
                if(this.attacking == 1)
                    this.switchAttacking();
                match.restartGame();
            }


            this.match.decreaseStats(5);
        }
        this.match.endGame();
        IO.newLine();
        IO.message("Resultado Final");
        IO.message(match.score());
    }



    private void selectTatic(String team){
        int[] tatic;
        if(team.equals(match.getTeamHome()))
            tatic = match.getTaticHome();
        else
            tatic = match.getTaticAway();
        int r = 0;
        for(int i=0; i<FootballMatch.tatics.length; i++)
            if(Arrays.equals(FootballMatch.tatics[i], tatic))
                r = i;
        int option = -1;
        do{
            int overall = (int) (team.equals(match.getTeamHome())? match.overallHome() : match.overallAway());
            String[] options = {"442", "433", "352"};
            options[r] += " *";
            Menu menu = new Menu(options, "Prosseguir","*** Modelo tatico ***\nOverall Equipa: " + overall );
            IO.newLine();
            menu.run();
            option = menu.getOption();
            if (option !=0)
            {
                r = option-1;
                if(team.equals(match.getTeamHome()))
                    match.setTaticHome(FootballMatch.tatics[option-1]);
                else
                    match.setTaticAway(FootballMatch.tatics[option-1]);
            }
        }while (option != 0 );

    }

    private void selectTaticHome(){
        selectTatic(match.getTeamHome());
    }

    private void selectTaticAway(){
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
            if (team.equals(match.getTeamHome())){
                playing = match.playingHome();
                bench = match.benchHome();
            }
            else{
                playing = match.playingAway();
                bench = match.benchAway();
            }
            IO.newLine();
            IO.message("*** Titulares ***");
            IO.showPlayers(playing.iterator());
            IO.newLine();
            IO.message("*** Banco ***");
            IO.showPlayers(bench.iterator());
            IO.newLine();
            menu.run();
            option = menu.getOption();
            if(option ==1){

                IO.newLine();
                IO.message("Selecione Jogador dos Titulares");
                int out = IO.chooseNumber();
                IO.message("Selecione Jogador dos Titulares/Banco");
                int in = IO.chooseNumber();
                try {
                    if(team.equals(match.getTeamHome()))
                        match.substitutionHome(in, out);
                    else
                        match.substitutionAway(in, out);

                }catch (SubstitutionsException e){
                    IO.message(e.getMessage());
                }

            }

        } while (option != 0);

    }
    private void substitutionsHome(){
        this.substitutions(match.getTeamHome());
    }

    private void substitutionsAway(){
        this.substitutions(match.getTeamAway());
    }


    private void programSubstitutions(String team){
        List<FootballPlayer> playing;
        List<FootballPlayer> bench;

        int option = -1;
        IO.message(team);
        Menu menu =  new Menu(new String[]{"Sim"},"Não", "Deseja Programar Alterações?");
        do{
            if (team.equals(match.getTeamHome())){
                playing = match.playingHome();
                bench = match.benchHome();


            }
            else{
                playing = match.playingAway();
                bench = match.benchAway();

            }
            IO.newLine();
            IO.message("*** Titulares ***");
            IO.showPlayers(playing.iterator());
            IO.newLine();
            IO.message("*** Banco ***");
            IO.showPlayers(bench.iterator());
            IO.newLine();
            IO.message("*** Substituições Programadas ***");
            if(team.equals(this.match.getTeamHome()))
                IO.showFutureSubstitutions(this.futureSubstitutionsHome.entrySet().iterator());
            else
                IO.showFutureSubstitutions(this.futureSubstitutionsAway.entrySet().iterator());

            IO.newLine();
            menu.run();
            option = menu.getOption();
            if(option ==1){

                IO.newLine();
                IO.message("Selecione Primeiro Jogador (Titulares)");
                int out = IO.chooseNumber();
                IO.message("Selecione Segundo Jogador");
                int in = IO.chooseNumber();
                Menu timeMenu = new Menu(new String[]{"Primeira Parte","Segunda Parte"},"Intervalo","Escolha Momento");
                int timOption = -1;
                do{
                    IO.newLine();
                    timeMenu.run();
                    timOption = timeMenu.getOption();
                }while (timOption <0 || timOption >2);
                int substitutionTime = 5;
                if (timOption == 1)
                    substitutionTime = 2;
                else if(timOption == 2)
                    substitutionTime = 8;
                try {
                    if(team.equals(match.getTeamHome())){
                        match.substitutionHome(in, out);
                        match.substitutionHome(out,in);
                        futureSubstitutionsHome.putIfAbsent(substitutionTime,new TreeMap<>());
                        this.cleanFutureSubstitutionHome(in,out);
                        if(this.futureSubstitutionsHome.values().stream().mapToInt(Map::size).sum() <3 && match.getPlayersHome().contains(out) && ! match.getPlayersHome().contains(in)) {
                                futureSubstitutionsHome.get(substitutionTime).put(in,out);
                            }


                    }
                    else{
                        match.substitutionAway(in, out);
                        match.substitutionAway(out,in);
                        futureSubstitutionsAway.putIfAbsent(substitutionTime,new TreeMap<>());
                        this.cleanFutureSubstitutionAway(in, out);
                        if(this.futureSubstitutionsAway.values().stream().mapToInt(Map::size).sum() <3 && match.getPlayersAway().contains(out) && ! match.getPlayersAway().contains(in)) {
                            futureSubstitutionsAway.get(substitutionTime).put(in,out);
                        }

                    }

                }catch (SubstitutionsException e){
                    IO.message(e.getMessage());
                }

            }

        } while (option != 0);

    }

    private void programSubstitutionsHome(){
        this.programSubstitutions(this.match.getTeamHome());
    }

    private void programSubstitutionsAway(){
        this.programSubstitutions(this.match.getTeamAway());
    }

    private void cleanFutureSubstitutionHome(int in, int out){
        for(Map<Integer,Integer> me : this.futureSubstitutionsHome.values()){
            me.remove(in);
            me.entrySet().removeIf(entry -> (out == (entry.getValue())));
        }

    }

    private void cleanFutureSubstitutionAway(int in, int out){
        for(Map<Integer,Integer> me : this.futureSubstitutionsHome.values()){
            me.remove(in);
            me.entrySet().removeIf(entry -> (out == (entry.getValue())));
        }

    }

    private int decision(){
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


/*
    public void calculateResult(){
        this.matchPresentation();
        this.lineUpHome();
        this.programSubstitutionsHome();
        this.lineUpAway();
        this.programSubstitutionsAway();
        List<Integer> results = new ArrayList<>();
        double overallHome = this.match.overallHome();
        double overallAway = this.match.overallAway();
        double totalOverall = overallHome + overallAway;
        double ofensiveOverallHome = this.match.ofensiveOverallHome();
        double defensiveOverallHome = this.match.defensiveOverallHome();
        double ofensiveOverallAway = this.match.ofensiveOverallAway();
        double defensiveOverallAway = this.match.defensiveOverallAway();
        overallHome *= 0.7;
        overallAway *= 0.7;

        int i = (int) (overallHome*100/totalOverall)/10;
        int j = (int) (overallAway*100/totalOverall)/10;
        int k = 10 - i - j;
        for(int l=0; l<i; l++)
            results.add(1);
        for(int l=0; l<j; l++  )
            results.add(0);
        for(int l=0; l<k; l++)
            results.add(2);
        Random random = new Random();
        int w = random.nextInt(10);
        int winner = results.get(w);


        int difHA = (int) ((ofensiveOverallHome *10) /(ofensiveOverallHome+defensiveOverallAway));
        List<Integer> possiblesGoals = new ArrayList<>();
        k = 10 - difHA;
        for(i = 0; i<k; i++)
            possiblesGoals.add(0);
        for (i = 0; i< difHA; i++)
            possiblesGoals.add(i+1);
        int r = random.nextInt(10);
        int goalsHome = possiblesGoals.get(r);



        int difAH = (int) ((ofensiveOverallAway *10) /(ofensiveOverallAway+defensiveOverallHome));
        possiblesGoals.clear();
        k = 10 - difAH;
        for(i = 0; i<k; i++)
            possiblesGoals.add(0);
        for (i = 0; i< difAH; i++)
            possiblesGoals.add(i+1);
        r = random.nextInt(10);
        int goalsAway = possiblesGoals.get(r);


        if(winner == 0 && goalsHome != goalsAway){
            goalsHome = goalsAway;
        }

        if(winner == 1 && goalsHome <=goalsAway){
            while (goalsHome <= goalsAway)
                goalsHome++;
        }


        if(winner == 2 && goalsAway <= goalsHome){
            while (goalsAway <= goalsHome)
                goalsAway++;
        }

        this.match.setScoreHome(goalsHome);
        this.match.setScoreAway(goalsAway);
        this.match.endGame();
        IO.newLine();
        IO.message("Resultado");
        IO.message(match.score());

    }
    */




}

