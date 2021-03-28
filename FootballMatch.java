
/**
 * Write a description of class FootballMatch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FootballMatch
{
    private MatchState state;
    private int scoreHome;
    private int scoreAway;
    private FootballTeam home;
    private FootballTeam away;
    
    public FootballMatch (){
        this.state = MatchState.TOSTART;
        this.scoreHome = 0;
        this.scoreAway = 0;
    }
    
    public FootballMatch(MatchState state, int scoreH, int scoreA, FootballTeam home, FootballTeam away){
        this.state = state;
        this.scoreHome = scoreH;
        this.scoreAway = scoreA;
        this.home = home.clone();
        this.away = away.clone();
    }
    
    public FootballMatch(FootballMatch match){
        this(match.getState(), match.getScoreHome(), match.getScoreAway(), match.getHome(), match.getAway());
    }
    
    public MatchState getState(){
        return this.state;
    }
    
    public void setState(MatchState state){
        this.state = state;
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
        if(this.state == MatchState.TOSTART)
            this.setState(MatchState.FIRSTHALF);
    }
    
    public void pauseGame(){
        if(this.state == MatchState.FIRSTHALF)
            this.setState(MatchState.INTERVALL);
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
        sb.append(this.home).append(" ").append(this.getScoreHome()).append(" : ").append(this.away).append(this.getScoreAway());
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
}
