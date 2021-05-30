import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class FootballMatch implements Serializable
{

    private String teamHome;
    private String teamAway;
    private int scoreHome;
    private int scoreAway;
    private LocalDate date;
    private Timer timer;
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
        this.timer = new Timer();
        this.state = MatchState.TOSTART;
        this.squadHome = new HashMap<>();
        this.squadAway = new HashMap<>();
        this.playersHome = new ArrayList<>();
        this.playersAway = new ArrayList<>();
        this.substitutionsHome = new HashMap<>();
        this.substitutionsAway = new HashMap<>();
        this.taticHome = new int[]{1,4,3,3};
        this.taticAway = new int[]{1,4,3,3};
    }


    public FootballMatch (String teamHome, String teamAway, int scoreHome, int scoreAway, LocalDate date, Timer timer, MatchState state,
                          Map<Integer, FootballPlayer> squadHome, Map<Integer, FootballPlayer> squadAway, List<Integer> playersHome,
                          List<Integer> playersAway, Map<Integer, Integer> substitutionsHome, Map<Integer, Integer> substitutionsAway ){
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        this.date = date;
        setTimer(timer);
        this.state = state;
        setSquadHome(squadHome);
        setSquadAway(squadAway);
        setPlayersHome(playersHome);
        setPlayersAway(playersAway);
        setSubstitutionsHome(substitutionsHome);
        setSubstitutionsAway(substitutionsAway);
        this.taticHome = new int[]{1,2,2,3,3};
        this.taticAway = new int[]{1,2,2,3,3};
    }
    

    
    public FootballMatch(FootballMatch match){
        this.teamHome = match.getTeamHome();
        this.teamAway = match.getTeamAway();
        this.scoreHome = match.getScoreHome();
        this.scoreAway = match.getScoreAway();
        this.date = match.getDate();
        setTimer(match.getTimer());
        this.state = match.getState();
        setSquadHome(match.getSquadHome());
        setSquadAway(match.getSquadAway());
        setPlayersHome(match.getPlayersHome());
        setPlayersAway(match.getPlayersAway());
        setSubstitutionsHome(match.getSubstitutionsHome());
        setSubstitutionsAway(match.getSubstitutionsAway());
        this.taticHome = new int[]{1,4,3,3};
        this.taticAway = new int[]{1,4,3,3};
    }

    public FootballMatch(FootballTeam home, FootballTeam away){
        this.teamHome = home.getName();
        this.teamAway = away.getName();
        this.scoreHome = 0;
        this.scoreAway = 0;
        this.date = LocalDate.now();
        this.timer = new Timer();
        this.state = MatchState.TOSTART;
        this.squadHome = home.getSquad();
        this.squadAway = away.getSquad();
        this.playersHome = new ArrayList<>();
        this.playersAway = new ArrayList<>();
        this.substitutionsHome = new HashMap<>();
        this.substitutionsAway = new HashMap<>();
        this.taticHome = new int[]{1,4,3,3};
        this.taticAway = new int[]{1,4,3,3};
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

     public Timer getTimer(){
        return this.timer.clone();
     }
     public void setTimer(Timer timer){
        this.timer = timer.clone();
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



    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(date).append(" | ");
        sb.append(this.state).append(" | ");
        sb.append(this.teamHome).append(" ").append(this.getScoreHome()).append(" : ").append(this.getScoreAway()).append(" ").append(this.teamAway);
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
                && this.date.equals(f.getDate()) && this.state == f.getState() && this.timer.equals(f.getTimer())
                && this.squadHome.equals(f.getSquadHome()) && this.squadAway.equals(f.getSquadAway())
                && this.playersHome.equals(f.getPlayersHome()) && this.playersAway.equals(f.getPlayersAway())
                && this.substitutionsHome.equals(f.getSubstitutionsHome()) && this.substitutionsAway.equals(f.getSubstitutionsAway());
    }

    /*public double overallHome(){
        double result = 0;
        int number, position = 0;
        number = this.playersHome.get(position);
        position++;
        result += squadHome.get(number).overall();

        for(int i = 0; i<taticHome[1]; i++){
            number = this.playersHome.get(position);
            if(squadHome.get(number) instanceof center)
            position++;
        }


        return result;
    }*/

    public double clock(){
        return this.timer.elapsedTimeTime();
    }
            
    
    public void startGame(){
        if(this.state == MatchState.TOSTART){
            this.setState(MatchState.FIRSTHALF);
            timer.start();
        }
    }
    
    public void pauseGameForIntervall(){
        if(this.state == MatchState.FIRSTHALF){
            this.setState(MatchState.INTERVALL);
            timer.stop();
        }
    }

    public void pauseGameForSubstitution(){
        if(this.state == MatchState.FIRSTHALF || this.state == MatchState.SECONDHALF ){
            this.timer.stop();
        }
    }
    
    public void restartGame(){
        if(this.state == MatchState.INTERVALL)
            this.setState(MatchState.SECONDHALF);
        this.timer.start();
    }
    
    public void endGame(){
        this.timer.stop();
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
        sb.append(this.teamHome).append(" ").append(this.getScoreHome()).append(" : ").append(this.teamAway).append(this.getScoreAway());
        return sb.toString();
    }


    
    public MatchResult result(){
        if (scoreHome == scoreAway) 
            return MatchResult.DRAW;
        if (scoreHome > scoreAway) 
            return MatchResult.WIN;
        else
            return MatchResult.LOSS;
        
    }


    public static FootballMatch parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new FootballMatch(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), new Timer(), MatchState.FINISHED,
                new HashMap<>(), new HashMap<>(), jc, jf, subsC, subsF);
    }


}
