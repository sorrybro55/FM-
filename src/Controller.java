import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Controller {
    State state;

    public Controller(State state){
        this.state = state;
    }

    public  void run() {

        int option = -1;
        Menu menu = new Menu(new String[]{"Fazer Jogo", "Ver Resultados", "Gerir Jogadores", "Gerir Equipas","Guardar Estado", "Carregar Estado"});
        do {
            IO.newLine();
            menu.run();
            option = menu.getOption();
            switch (option) {
                case 1:
                    try{
                        this.makeGame();
                    }catch (NoTeamsException e){
                        IO.message(e.getMessage());
                    }
                    break;
                case 2:
                    this.showGames();
                    break;

                case 3:
                    this.managePlayers();
                    break;
                case 4:
                    this.manageTeams();
                    break;
                case 5:
                    this.save();
                    break;
                case 6:
                    this.load();
                    break;
            }
        } while (option != 0) ;
    }

    private void makeGame () throws NoTeamsException{
        Predicate<FootballTeam> p = FootballTeam::isComplete;
        if (this.state.getTeams().values().stream().filter(p).count() <1) {
            throw new NoTeamsException();
        }

        Menu menu = new Menu(new String[]{"Jogo Completo", "Simular Resultado"},"*** Tipo de Jogo ***");
        int option = -1;

        do{
            IO.newLine();
            menu.run();
            option = menu.getOption();
        }while (option <0 || option>2);

        if(option !=0){

            String teamHome = this.selectTeam(p);
            if(teamHome == null)
                return;
            String teamAway = this.selectTeam(p);
            if(teamAway == null)
                return;
            FootballTeam home = this.state.getTeam(teamHome);
            FootballTeam away = this.state.getTeam(teamAway);
            FootballMatch fm = new FootballMatch(home, away);
            MatchController mc = new MatchController(fm);

            if (option == 1)
                mc.run();
            else
                mc.simulation();
            this.state.addGame(mc.getMatch());

        }

    }
    private void showGames(){
        List<String> games = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(FootballMatch fm : this.state.getGames()){
            sb.append(fm.getTeamHome()).append(" - ").append(fm.getTeamAway());
            games.add(sb.toString());
            sb.setLength(0);

        }
        Menu menu = new Menu(games, "*** Selecione Jogo ***");
        int option = -1;
        do {

            IO.newLine();
            menu.run();
            option = menu.getOption();
            if(option !=0) {
                FootballMatch fm = this.state.getGames().get(option-1);
                IO.newLine();
                IO.showGame(fm);
                IO.newLine();
                IO.pressEnter();
            }

        }while (option != 0);

    }

    private void managePlayers(){

        Menu menu = new Menu(new String[]{"Ver Jogadores","Transferir Jogador","Criar Jogador","Apagar Jogador"},"*** Selecione Opção ***");
        int option = -1;
        do{
            IO.newLine();
            menu.run();
            option = menu.getOption();
            switch (option){
                case 1:
                    IO.newLine();
                    this.showPlayers();
                    break;
                case 2:
                    IO.newLine();
                    this.transferPlayer();
                    break;
                case 3:
                    IO.newLine();
                    this.createPlayer();
                    break;
                case 4:
                    IO.newLine();
                    this.deletePlayers();
                    break;
            }

        }while (option !=0);

    }


    private void showPlayers(){
        List<String> players = new ArrayList<>(this.state.getPlayers().keySet());
        Menu menu = new Menu(players, "*** Selecione Jogador ***");
        int option = -1;
        do {

            menu.run();
            option = menu.getOption();
            if(option !=0) {
                String playerName = players.get(option-1);
                    FootballPlayer player = this.state.getPlayer(playerName);
                    IO.newLine();
                    IO.showPlayer(player);
                    IO.pressEnter();
            }

        }while (option != 0);
    }

    private void transferPlayer(){
        String player = this.selectPlayer();
        if(player == null)
            return;
        String team = this.selectTeam();
        if(team == null)
            return;
        state.transferPlayer(player,team);
    }

    private void createPlayer(){
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
        int marking = 0;
        int recovery = 0;
        int crossing = 0;
        int positioning = 0;
        if(position == Position.GOALKEEPER)
            elasticity = IO.chooseAbility("Elasticidade");
        if (position == Position.DEFENDER)
            marking = IO.chooseAbility("Marcação");
        if(position == Position.MIDFIELDER)
            recovery = IO.chooseAbility("Recuperacao");
        if(position == Position.STRIKER)
            positioning = IO.chooseAbility("Posicionamento");
        if(position == Position.WINGER)
            recovery = IO.chooseAbility("Cruzamento");
        String team = "Sem Equipa";

        switch (position){
            case GOALKEEPER:
                state.addPlayer(new GoalKeeper(name, number, speed, stamina, agility, jumping, heading, finishing, passing, elasticity, team, new ArrayList<String>()));
                break;
            case DEFENDER:
                state.addPlayer(new Defender(name, number, speed, stamina, agility, jumping, heading, finishing, passing, marking,team, new ArrayList<String>()));
                break;
            case WINGER:
                state.addPlayer(new Winger(name, number, speed, stamina, agility, jumping, heading, finishing, passing, crossing, team, new ArrayList<String>()));
                break;
            case MIDFIELDER:
                state.addPlayer(new MidFielder(name, number, speed, stamina, agility, jumping, heading, finishing, passing, recovery, team, new ArrayList<String>()));
                break;
            case STRIKER:
                state.addPlayer(new Striker(name, number, speed, stamina, agility, jumping, heading, finishing, passing, positioning, team, new ArrayList<String>()));
                break;
        }
    }


    private void deletePlayers(){
        int option = -1;
        do {
            List<String> players = new ArrayList<>(this.state.getPlayers().keySet());
            Menu menu = new Menu(players, "*** Selecione Jogador ***");
            menu.run();
            option = menu.getOption();
            if(option !=0) {
                String playerName = players.get(option-1);
                this.state.removePlayer(playerName);
            }

        }while (option != 0);
    }



    private void manageTeams(){

        Menu menu = new Menu(new String[]{"Ver Equipas","Criar Equipas","Apagar Equipa"},"*** Selecione Opção ***");
        int option = -1;
        do{
            IO.newLine();
            menu.run();
            option = menu.getOption();
            switch (option){
                case 1:
                    this.showTeams();
                    break;
                case 2:
                    this.createTeam();
                    break;
                case 3:
                    this.deleteTeams();
                    break;
            }

        }while (option !=0);

    }





    private void showTeams(){
        List<String> teams = new ArrayList<>(this.state.getTeams().keySet());
        Menu menu = new Menu(teams, "*** Selecione Equipa ***");
        int option = -1;
        do {

            IO.newLine();
            menu.run();
            option = menu.getOption();
            if(option !=0) {
                String teamName = teams.get(option-1);
                    FootballTeam team = this.state.getTeam(teamName);
                    IO.newLine();
                    IO.showTeam(team);
                    IO.pressEnter();
            }

        }while (option != 0);

    }



    private void createTeam(){
        IO.newLine();
        String name = IO.chooseName();
        FootballTeam team = new FootballTeam();
        team.setName(name);
        state.addTeam(team);
    }

    private void deleteTeams(){
        int option = -1;
        do {
            List<String> teams = new ArrayList<>(this.state.getTeams().keySet());
            Menu menu = new Menu(teams, "*** Selecione Equipa ***");

            IO.newLine();
            menu.run();
            option = menu.getOption();
            if(option !=0) {
                String teamName = teams.get(option-1);
                this.state.removeTeam(teamName);
            }

        }while (option != 0);
    }


    private String selectPlayer(){
        List<String> players = new ArrayList<>(this.state.getPlayers().keySet());
        Menu menu = new Menu(players, "*** Selecione Jogador ***");
        int option = -1;
        do{
            menu.run();
            option = menu.getOption();
        }while (option<0 || option>players.size());
        if(option !=0)
            return players.get(option-1);
        return null;
    }



    private String selectTeam(){
        List<String> teams = new ArrayList<>(state.getTeams().keySet());
        Menu menu = new Menu(teams,"*** Escolha Equipa ***");
        int option = -1;
        do{
            IO.newLine();
            menu.run();
            option = menu.getOption();
        }while (option <0 || option >teams.size());
        if(option!=0)
            return teams.get(option-1);
        return null;
    }

    private String selectTeam(Predicate<FootballTeam> p){
        List<String> teams = state.getTeams().entrySet().stream().filter(team -> p.test(team.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
        Menu menu = new Menu(teams,"*** Escolha Equipa ***");
        int option = -1;
        do{
            IO.newLine();
            menu.run();
            option = menu.getOption();
        }while (option <0 || option >teams.size());
        if(option!=0)
            return teams.get(option-1);
        return null;
    }



    private void save(){
        IO.newLine();
        String fileName = IO.getFileName();
        try{
            this.state.save(fileName);
            IO.message("Guardado Com Sucesso!");

        }catch (IOException e){
            IO.message("Ficheiro Não Encontrado!");
        }
    }

    private void load(){
        IO.newLine();
        String fileName = IO.getFileName();
        try{
            this.state = State.load(fileName);
            IO.message("Carregado Com Sucesso!");
        }catch (IOException | ClassNotFoundException e){
            IO.message("Ficheiro Não Encontrado!");
        }
    }

}









