import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class FootballMatch implements Serializable
{
    public static final int [][] tatics = { {1,2,2,4,2}, {1,2,2,3,3}, {1,3,2,3,2}};

    private String teamHome;
    private String teamAway;
    private int scoreHome;
    private int scoreAway;
    private LocalDate date;
    private MatchState state;
    private Map<Integer, FootballPlayer> squadHome;
    private Map<Integer, FootballPlayer> squadAway;
    private List<Integer> playersHome;
    private List<Integer> playersAway;
    private Map<Integer, Integer> substitutionsHome = new HashMap<>();
    private Map<Integer, Integer> substitutionsAway = new HashMap<>();
    private int[] taticHome;
    private int[] taticAway;


    public FootballMatch(){
        this.teamHome = "Sem Nome";
        this.teamAway = "Sem Nome";
        this.scoreHome = 0;
        this.scoreAway = 0;
        this.date = LocalDate.now();
        this.state = MatchState.TOSTART;
        this.squadHome = new HashMap<>();
        this.squadAway = new HashMap<>();
        this.playersHome = new ArrayList<>();
        this.playersAway = new ArrayList<>();
        this.substitutionsHome = new HashMap<>();
        this.substitutionsAway = new HashMap<>();
        this.taticHome = new int[]{1,2,2,4,2};
        this.taticAway = new int[]{1,2,2,4,2};
    }


    public FootballMatch (String teamHome, String teamAway, int scoreHome, int scoreAway, LocalDate date,  MatchState state,
                          Map<Integer, FootballPlayer> squadHome, Map<Integer, FootballPlayer> squadAway, List<Integer> playersHome,
                          List<Integer> playersAway, Map<Integer, Integer> substitutionsHome, Map<Integer, Integer> substitutionsAway, int[] taticHome, int[] taticAway ){
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        this.date = date;
        this.state = state;
        setSquadHome(squadHome);
        setSquadAway(squadAway);
        setPlayersHome(playersHome);
        setPlayersAway(playersAway);
        setSubstitutionsHome(substitutionsHome);
        setSubstitutionsAway(substitutionsAway);
        setTaticHome(taticHome);
        setTaticAway(taticAway);
    }
    

    
    public FootballMatch(FootballMatch match){
        this.teamHome = match.getTeamHome();
        this.teamAway = match.getTeamAway();
        this.scoreHome = match.getScoreHome();
        this.scoreAway = match.getScoreAway();
        this.date = match.getDate();
        this.state = match.getState();
        setSquadHome(match.getSquadHome());
        setSquadAway(match.getSquadAway());
        setPlayersHome(match.getPlayersHome());
        setPlayersAway(match.getPlayersAway());
        setSubstitutionsHome(match.getSubstitutionsHome());
        setSubstitutionsAway(match.getSubstitutionsAway());
        setTaticHome(match.getTaticHome());
        setTaticAway(match.getTaticAway());
    }

    public FootballMatch(FootballTeam home, FootballTeam away){
        this.teamHome = home.getName();
        this.teamAway = away.getName();
        this.scoreHome = 0;
        this.scoreAway = 0;
        this.date = LocalDate.now();
        this.state = MatchState.TOSTART;
        this.squadHome = home.getSquad();
        this.squadAway = away.getSquad();
        this.playersHome = home.bestEleven();
        this.playersAway = away.bestEleven();
        this.substitutionsHome = new HashMap<>();
        this.substitutionsAway = new HashMap<>();
        this.taticHome = new int[]{1,2,2,4,2};
        this.taticAway = new int[]{1,2,2,4,2};
    }

    public String getTeamHome(){
        return this.teamHome;
    }

    public void setTeamHome(String teamHome){
        this.teamHome = teamHome;
    }

    public String getTeamAway(){
        return this.teamAway;
    }

    public void setTeamAway(String teamAway){
        this.teamHome = teamAway;
    }

    public int getScoreHome(){
        return this.scoreHome;
    }

    public void setScoreHome(int score){
        this.scoreHome = score;
    }

    public int getScoreAway(){
        return this.scoreAway;
    }
    public void setScoreAway(int score){
        this.scoreAway = score;
    }


     public LocalDate getDate(){
        return this.date;
     }

     public void setDate(LocalDate date){
        this.date = date;
     }


    public MatchState getState(){
        return this.state;
    }
    
    public void setState(MatchState state){
        this.state = state;
    }

    public Map<Integer, FootballPlayer> getSquadHome(){
        return squadHome.values().stream().collect(Collectors.toMap(v->v.getNumber(),v->v.clone()));
    }
    public void setSquadHome(Map<Integer, FootballPlayer> squadHome){
        this.squadHome = new HashMap<>();
        for(Map.Entry<Integer, FootballPlayer> m : squadHome.entrySet())
            this.squadHome.put(m.getKey(), m.getValue().clone());
    }

    public Map<Integer, FootballPlayer> getSquadAway(){
        return squadAway.values().stream().collect(Collectors.toMap(v->v.getNumber(),v->v.clone()));
    }

    public void setSquadAway(Map<Integer, FootballPlayer> squadAway){
        this.squadAway = new HashMap<>();
        for(Map.Entry<Integer, FootballPlayer> m : squadAway.entrySet())
            this.squadAway.put(m.getKey(), m.getValue().clone());
    }

    public List<Integer> getPlayersHome(){
        return new ArrayList<>(this.playersHome);
    }

    public void setPlayersHome(List<Integer> playersHome){
        this.playersHome = new ArrayList<>(playersHome);
    }

    public List<Integer> getPlayersAway(){
        return new ArrayList<>(this.playersAway);
    }

    public void setPlayersAway(List<Integer> playersAway){
        this.playersAway = new ArrayList<>(playersAway);
    }

    public Map<Integer, Integer> getSubstitutionsHome(){
        return new HashMap<>(this.substitutionsHome);
    }

    public void setSubstitutionsHome(Map<Integer, Integer> substitutionsHome){
        this.substitutionsHome = new HashMap<>(substitutionsHome);
    }

    public Map<Integer, Integer> getSubstitutionsAway(){
        return new HashMap<>(this.substitutionsAway);
    }

    public void setSubstitutionsAway(Map<Integer, Integer> substitutionsAway){
        this.substitutionsAway = new HashMap<>(substitutionsAway);
    }

    public int[] getTaticHome(){
        return this.taticHome.clone();
    }

    public int[] getTaticAway(){
        return this.taticAway.clone();
    }

    public void setTaticHome(int[] tatic){
        this.taticHome = tatic.clone();
    }

    public void setTaticAway(int[] tatic){
        this.taticAway = tatic.clone();
    }



    public String toStringSimple(){
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(date).append(" | ");
        sb.append(this.state).append(" | ");
        sb.append(this.teamHome).append(" ").append(this.getScoreHome()).append(" : ").append(this.getScoreAway()).append(" ").append(this.teamAway);
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(date).append(" | ");
        sb.append(this.state).append(" | ");
        sb.append(this.teamHome).append(" ").append(this.getScoreHome()).append(" : ").append(this.getScoreAway()).append(" ").append(this.teamAway);
        sb.append("\n\n*** Alinhamentos Finais ***\n");
        sb.append(this.teamHome).append("\n").append(this.playersHome).append("\n");
        sb.append(this.teamAway).append("\n").append(this.playersAway).append("\n\n");
        sb.append("*** Substituições ***\n");
        sb.append(this.teamHome).append("\n");
        for(Map.Entry<Integer,Integer> me : this.substitutionsHome.entrySet())
            sb.append(me.getKey()).append(" -> ").append(me.getValue()).append("   ");
        sb.append("\n");
        sb.append(this.teamAway).append("\n");
        for(Map.Entry<Integer,Integer> me : this.substitutionsAway.entrySet())
            sb.append(me.getKey()).append(" -> ").append(me.getValue()).append("   ");
        return sb.toString();
    }
    
    public FootballMatch clone(){
        return new FootballMatch(this);
    }
    
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        FootballMatch f = (FootballMatch) o;
        return this.teamHome.equals(f.getTeamHome()) && this.teamAway.equals(f.getTeamAway())
                && this.scoreHome == f.getScoreHome() && this.scoreAway == f.getScoreAway()
                && this.date.equals(f.getDate()) && this.state == f.getState()
                && this.squadHome.equals(f.getSquadHome()) && this.squadAway.equals(f.getSquadAway())
                && this.playersHome.equals(f.getPlayersHome()) && this.playersAway.equals(f.getPlayersAway())
                && this.substitutionsHome.equals(f.getSubstitutionsHome()) && this.substitutionsAway.equals(f.getSubstitutionsAway());
    }

    private List<FootballPlayer> bench(String team){
        List<FootballPlayer> result = new ArrayList<>();
        if(team.equals(teamHome)){
            for(FootballPlayer fp : squadHome.values())
                if(!playersHome.contains(fp.getNumber()) && !this.substitutionsHome.containsKey(fp.getNumber()))
                    result.add(fp.clone());
        }
        else{
            for(FootballPlayer fp : squadAway.values())
                if(!playersAway.contains(fp.getNumber()) && !this.substitutionsAway.containsKey(fp.getNumber()))
                    result.add(fp.clone());
        }
        return result;

    }

    public List<FootballPlayer> benchHome(){
        return bench(teamHome);
    }

    public List<FootballPlayer> benchAway(){
        return bench(teamAway);
    }

    public List<FootballPlayer> playingHome(){
        return playing(teamHome);
    }

    public List<FootballPlayer> playingAway(){
        return playing(teamAway);
    }


    private List<FootballPlayer> playing(String team){
        List<FootballPlayer> result = new ArrayList<>();
        if(team.equals(teamHome)){
            for (int i : this.playersHome)
                result.add(squadHome.get(i).clone());
        }
        else{
            for (int i : this.playersAway)
                result.add(squadAway.get(i).clone());
        }
        return result;
    }

    private List<FootballPlayer> playing(String team, Position pos){
        List<FootballPlayer> players = this.playing(team);
        List<FootballPlayer> resutl = new ArrayList<>();
        int taticIndex = 0, playersIndex = 0;
        int[] tatic;

        if(team.equals(teamHome))
            tatic = taticHome;
        else
            tatic = taticAway;

        switch (pos){
            case GOALKEEPER:
                taticIndex = 0;
                break;
            case DEFENDER:
                taticIndex = 1;
                break;
            case WINGER:
                taticIndex = 2;
                break;
            case MIDFIELDER:
                taticIndex = 3;
                break;
            case STRIKER:
                taticIndex = 4;
                break;
        }
        for(int i = 0; i<taticIndex; i++)
            playersIndex += tatic[i];

        for(int i = playersIndex; i<playersIndex+tatic[taticIndex]; i++)
            resutl.add(players.get(i));
        return resutl;
    }

    private double goalKeeperOverall(String team){
        List<FootballPlayer> goalKeepers = this.playing(team, Position.GOALKEEPER);
        double result = 0;
        FootballPlayer goalKeeper = goalKeepers.get(0);
        if (goalKeeper instanceof GoalKeeper)
            result += goalKeeper.overall();
        else
            result += goalKeeper.overall()*0.3;
        return result;
    }



    private double defendersOverall(String team){
        List<FootballPlayer> defenders = this.playing(team, Position.DEFENDER);
        double result = 0;
        for(FootballPlayer defender : defenders){
            if(defender instanceof Defender)
                result += defender.overall();
            else if (defender instanceof MidFielder || defender instanceof Striker)
                result += defender.overall()*0.8;
            else
                result += defender.overall()*0.5;
        }
        return result;
    }

    private double wingersOverall(String team){
        List<FootballPlayer> wingers = this.playing(team, Position.WINGER);
        double result = 0;
        for(FootballPlayer winger : wingers ){
            if(winger instanceof Winger)
                result += winger.overall();
            else if (winger instanceof MidFielder )
                result += winger.overall()*0.8;
            else
                result += winger.overall()*0.5;
        }
        return result;
    }

    private double midfieldersOverall(String team){
        List<FootballPlayer> midfielders = this.playing(team, Position.MIDFIELDER);
        double result = 0;
        for(FootballPlayer midfielder : midfielders ){
            if(midfielder instanceof MidFielder)
                result += midfielder.overall();
            else
                result += midfielder.overall()*0.8;
        }
        return result;
    }

    private double strikersOverall(String team){
        List<FootballPlayer> strikers = this.playing(team, Position.STRIKER);
        double result = 0;
        for(FootballPlayer striker : strikers ){
            if(striker instanceof Striker)
                result += striker.overall();
            else if (striker instanceof Defender || striker instanceof MidFielder)
                result += striker.overall()*0.8;
            else
                result += striker.overall()*0.5;
        }
        return result;
    }


    public double overallHome(){
        return (goalKeeperOverall(this.teamHome) + defendersOverall(this.teamHome) + wingersOverall(this.teamHome) +
                midfieldersOverall(this.teamHome) + strikersOverall(this.teamHome))/11;
    }

    public double overallAway(){
        return (goalKeeperOverall(this.teamAway) + defendersOverall(this.teamAway) + wingersOverall(this.teamAway) +
                midfieldersOverall(this.teamAway) + strikersOverall(this.teamAway))/11;
    }

    public double defensiveOverallHome(){
        return goalKeeperOverall(this.teamHome) + defendersOverall(this.teamHome) + wingersOverall(this.teamHome) +
                midfieldersOverall(this.teamHome);
    }

    public double defensiveOverallAway(){
        return goalKeeperOverall(this.teamAway) + defendersOverall(this.teamAway) + wingersOverall(this.teamAway) +
                midfieldersOverall(this.teamAway);
    }

    public double ofensiveOverallHome(){
        return wingersOverall(this.teamHome) + midfieldersOverall(this.teamHome) + strikersOverall(this.teamHome);
    }

    public double ofensiveOverallAway(){
        return wingersOverall(this.teamAway) + midfieldersOverall(this.teamAway) + strikersOverall(this.teamAway);
    }



    private void substitution(String team, int in, int out) throws SubstitutionsException{
        List<Integer> numbers;
        Map<Integer,FootballPlayer> squad;
        Map<Integer, Integer> substitutions;
        if(team.equals(teamHome)){
            numbers = this.playersHome;
            squad = this.squadHome;
            substitutions = this.substitutionsHome;
        }
        else{
            numbers = this.playersAway;
            squad = this.squadAway;
            substitutions = this.substitutionsAway;
        }
        if(numbers.contains(in) && numbers.contains(out)){
            int fst = numbers.indexOf(in);
            int snd = numbers.indexOf(out);
            Collections.swap(numbers,fst,snd);
        }
        else {

            if (this.state != MatchState.TOSTART && substitutions.keySet().size() >= 3)
                throw new SubstitutionsException("Não Pode Realizar Mais Substituições");
            if (substitutions.containsKey(in) || substitutions.containsKey(out))
                throw new SubstitutionsException("Substituição Invalida");
            if (!squad.containsKey(in) || !numbers.contains(out))
                throw new SubstitutionsException("Substituição Invalida");

            int index = numbers.indexOf(out);
            numbers.set(index, in);
            if (this.state != MatchState.TOSTART)
                substitutions.put(out, in);
        }

    }

    public void substitutionHome (int in, int out) throws SubstitutionsException{
        this.substitution(this.teamHome, in, out);
    }

    public void substitutionAway (int in, int out) throws SubstitutionsException{
        this.substitution(this.teamAway, in, out);
    }



            
    
    public void startGame(){
        if(this.state == MatchState.TOSTART){
            this.setState(MatchState.FIRSTHALF);
        }
    }
    
    public void itervall(){
        if(this.state == MatchState.FIRSTHALF){
            this.setState(MatchState.INTERVALL);
        }
    }

    
    public void restartGame(){
        if(this.state == MatchState.INTERVALL)
            this.setState(MatchState.SECONDHALF);

    }
    
    public void endGame(){
        this.setState(MatchState.FINISHED);
    }
    
    public void goalHome(){
        if(this.state == MatchState.FIRSTHALF || this.state == MatchState.SECONDHALF)
            this.scoreHome +=1;
    }
    
    public void goalAway(){
        if(this.state == MatchState.FIRSTHALF || this.state == MatchState.SECONDHALF)
            this.scoreAway +=1;
    }
    
    public String score(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.teamHome).append(" ").append(this.getScoreHome()).append(" : ").append(this.getScoreAway()).append(" ").append(this.teamAway);

        return sb.toString();
    }

    public void decreaseStats(int value){
        for(Integer number : this.playersHome){
            this.squadHome.get(number).decreaseStats(value);
        }

        for(Integer number : this.playersAway){
            this.squadAway.get(number).decreaseStats(value);
        }
    }



    public static FootballMatch parse(String input) {
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++) {
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++) {
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++) {
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++) {
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }


        for (int i = 0; i < 11; i++) {
            int num = jc.get(i);
            if (subsC.containsKey(num)) {
                jc.set(i, subsC.get(num));
            }
        }

        for (int i = 0; i < 11; i++) {
            int num = jf.get(i);
            if (subsF.containsKey(num)) {
                jf.set(i, subsF.get(num));
            }
        }


            return new FootballMatch(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                    LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), MatchState.FINISHED,
                    new HashMap<>(), new HashMap<>(), jc, jf, subsC, subsF, new int[]{1, 2, 2, 3, 3}, new int[]{1, 2, 2, 3, 3});
        }


}
