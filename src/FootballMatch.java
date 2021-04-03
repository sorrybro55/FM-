import java.util.ArrayList;

/**
 * Write a description of class FootballMatch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FootballMatch
{
    private MatchState state;
    private double beginning;
    private double elapsedTime;
    private int scoreHome;
    private int scoreAway;
    private FootballTeam home;
    private FootballTeam away;
    private ArrayList<FootballPlayer> replacedHome;
    private ArrayList<FootballPlayer> replacedAway;


    public FootballMatch (){
        this.state = MatchState.TOSTART;
        this.beginning = 0;
        this.elapsedTime = 0;
        this.scoreHome = 0;
        this.scoreAway = 0;
    }
    
    public FootballMatch(MatchState state, double beginning, double elapsedTime, int scoreH, int scoreA, FootballTeam home, FootballTeam away, ArrayList<FootballPlayer> replacedHome, ArrayList<FootballPlayer> replacedAway){
        this.state = state;
        this.beginning = beginning;
        this.elapsedTime = elapsedTime;
        this.scoreHome = scoreH;
        this.scoreAway = scoreA;
        this.home = home.clone();
        this.away = away.clone();
        setReplacedHome(replacedHome);
        setReplacedAway(replacedAway);
    }
    
    public FootballMatch(FootballMatch match){
        this(match.getState(), match.getBeginning(), match.getElapsedTime(), match.getScoreHome(), match.getScoreAway(), match.getHome(), match.getAway(), match.getReplacedHome(), match.getReplacedAway());
    }
    
    public MatchState getState(){
        return this.state;
    }
    
    public void setState(MatchState state){
        this.state = state;
    }

    public double getBeginning(){
        return this.beginning;
    }

    public void setBeginning(int beginning){
        this.beginning = beginning;
    }

    public double getElapsedTime(){
        return this.elapsedTime;
    }
    public void setElapsedTime(int elapsedTime){
        this.elapsedTime = elapsedTime;
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
    
    public FootballTeam getHome(){
        return this.home.clone();
    }
    
    public void setHome(FootballTeam home){
        this.home = home.clone();
    }
    
    public FootballTeam getAway(){
        return this.away.clone();
    }
    
    public void setAway(FootballTeam away){
        this.away = away.clone();
    }

    public ArrayList<FootballPlayer> getReplacedHome(){
        ArrayList<FootballPlayer> ret = new ArrayList<>();
        for(FootballPlayer fp : replacedHome)
            ret.add(fp.clone());
        return ret;
    }

    public void setReplacedHome(ArrayList<FootballPlayer> replacedHome){
        this.replacedHome = new ArrayList<>();
        for(FootballPlayer fp : replacedHome)
            this.replacedHome.add(fp.clone());
    }

    public ArrayList<FootballPlayer> getReplacedAway(){
        ArrayList<FootballPlayer> ret = new ArrayList<>();
        for(FootballPlayer fp : replacedAway)
            ret.add(fp.clone());
        return ret;
    }

    public void setReplacedAway(ArrayList<FootballPlayer> replacedAway){
        this.replacedAway = new ArrayList<>();
        for(FootballPlayer fp : replacedAway)
            this.replacedAway.add(fp.clone());
    }
   
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Estado do Encontro: ").append(this.state);
        sb.append(this.home).append(" ").append(this.getScoreHome()).append(" : ").append(this.away).append(this.getScoreAway());
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
        return this.state == f.getState() && this.scoreHome == f.getScoreHome() && this.scoreAway == f.getScoreAway() &&
                this.home.equals(f.getHome()) && this.away.equals(f.getAway());
    }
            
    
    public void startGame(){
        if(this.state == MatchState.TOSTART){
            this.setState(MatchState.FIRSTHALF);
            this.beginning += System.currentTimeMillis();
        }
    }
    
    public void pauseGame(){
        if(this.state == MatchState.FIRSTHALF){
            this.setState(MatchState.INTERVALL);
            this.elapsedTime += beginning - System.currentTimeMillis();
        }
    }

    public void stopGame(){
        if(this.state == MatchState.FIRSTHALF || this.state == MatchState.SECONDHALF ){
            this.setState(MatchState.STOPED);
            this.elapsedTime += beginning - System.currentTimeMillis();
        }
    }
    
    public void restartGame(){
        if(this.state == MatchState.INTERVALL) {
            this.setState(MatchState.SECONDHALF);
            this.beginning = System.currentTimeMillis();
        }
        if (this.state == MatchState.STOPED){
            if (this.elapsedTime <= 1200000)
                this.setState(MatchState.FIRSTHALF);
            else
                this.setState(MatchState.SECONDHALF);
            this.beginning = System.currentTimeMillis();
        }
    }
    
    public void endGame(){
        this.setState(MatchState.FINISHED);
        this.elapsedTime += beginning - System.currentTimeMillis();
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
        sb.append(this.home).append(" ").append(this.getScoreHome()).append(" : ").append(this.away).append(this.getScoreAway());
        return sb.toString();
    }

    public double clock(){
        if(this.state == MatchState.FIRSTHALF || this.state == MatchState.SECONDHALF)
            return this.elapsedTime + this.beginning - System.currentTimeMillis();
        else return elapsedTime;
    }
    
    public MatchResult result(){
        if (scoreHome == scoreAway) 
            return MatchResult.DRAW;
        if (scoreHome > scoreAway) 
            return MatchResult.WIN;
        else
            return MatchResult.LOSS;
        
    }

    public void substitutionHome(int in, int out ){
        FootballPlayer fpOut = home.startingGetPlayer(out);
        FootballPlayer fpIn = home.benchGetPlayer(in);
        if (replacedHome.size() <3 && fpIn != null && fpOut!= null && !replacedHome.contains(fpIn) ){
            home.moveToBench(out);
            home.moveToStarting(in);
            replacedHome.add(fpOut);
        }
    }

    public void substitutionAway(int in, int out ){
        FootballPlayer fpOut = away.startingGetPlayer(out);
        FootballPlayer fpIn = away.benchGetPlayer(in);
        if (replacedAway.size() <3 && fpIn != null && fpOut!= null && !replacedAway.contains(fpIn) ){
            away.moveToBench(out);
            away.moveToStarting(in);
            replacedAway.add(fpOut);
        }
    }

    public String showPlayer(FootballPlayer fp){
        StringBuilder sb = new StringBuilder();
        sb.append(fp.getPosition()).append(" ").append(fp.getName()).append(" ").append(fp.overall());
        return  sb.toString();
    }

    private String showList(ArrayList<FootballPlayer> a){
        StringBuilder sb = new StringBuilder();
        for (FootballPlayer fp : a)
            sb.append(showPlayer(fp)).append("\n");
        return sb.toString();
    }

    public String showStartingHome(){
        return showList(home.getStarting());
    }
    public String showStartingAway(){
        return showList(away.getStarting());
    }

    public String showBenchHome(){
        return showList(home.getBench());
    }
    public String showBenchAway(){
        return showList(away.getBench());
    }
}
