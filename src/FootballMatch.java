import java.time.LocalDate;
import java.util.*;


public class FootballMatch
{
    private String teamHome;
    private String teamAway;
    private int scoreHome;
    private int scoreAway;
    private Date date;
    private Timer timer;
    private MatchState state;
    private ArrayList<FootballPlayer> replacedHome;
    private ArrayList<FootballPlayer> replacedAway;


    public FootballMatch (){
        this.state = MatchState.TOSTART;
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
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
    }

/*
    public void substitutionHome(int in, int out ){
        FootballPlayer fpOut = home.startingGetPlayer(out);
        FootballPlayer fpIn = home.benchGetPlayer(in);
        if (replacedHome.size() <3 && fpIn != null && fpOut!= null && !replacedHome.contains(fpIn) ){
            home.moveToBench(out);
            home.moveToStarting(in);
            if(state != MatchState.TOSTART)
                replacedHome.add(fpOut);
        }
    }

    public void substitutionAway(int in, int out ){
        FootballPlayer fpOut = away.startingGetPlayer(out);
        FootballPlayer fpIn = away.benchGetPlayer(in);
        if (replacedAway.size() <3 && fpIn != null && fpOut!= null && !replacedAway.contains(fpIn) ){
            away.moveToBench(out);
            away.moveToStarting(in);
            if(state != MatchState.TOSTART)
                replacedAway.add(fpOut);
        }
    }

    private String showPlayer(FootballPlayer fp){
        StringBuilder sb = new StringBuilder();
        sb.append(fp.getPosition().simple()).append(" ").append(fp.getName()).append(" ").append(fp.overall());
        return  sb.toString();
    }

    private String showList(ArrayList<FootballPlayer> a){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (FootballPlayer fp : a)
            sb.append(index++).append(". ").append(showPlayer(fp)).append("\n");
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


*/
/*
    public ArrayList<FootballPlayer> getStarting() {
        ArrayList<FootballPlayer> ret = new ArrayList<FootballPlayer>();
        for (FootballPlayer fp : this.starting)
            ret.add(fp.clone());
        return ret;
    }

    public void setStarting(ArrayList<FootballPlayer> starting){
        this.starting = new ArrayList<FootballPlayer>();
        for(FootballPlayer fp : starting){
            FootballPlayer aux = getPlayerFromList(squad, fp);
            this.starting.add(aux);
        }
    }

    public ArrayList<FootballPlayer> getBench() {
        ArrayList<FootballPlayer> ret = new ArrayList<FootballPlayer>();
        for (FootballPlayer fp : this.bench)
            ret.add(fp.clone());
        return ret;
    }*/
/*
    public void setBench(ArrayList<FootballPlayer> bench){
        this.bench = new ArrayList<FootballPlayer>();
        for(FootballPlayer fp : bench){
            FootballPlayer aux = getPlayerFromList(squad, fp);
            this.bench.add(aux);
        }
    }



    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        if(points >=0)
            this.points = points;
    }

    public void increasePoints(int inc){
        if(inc == 1 || inc == 3)
            this.points += inc;
    /


    public void resetPoints(){
        this.points = 0;
    }*/


/*
    private FootballPlayer getPlayerFromList(ArrayList<FootballPlayer> a, int index){
        if(index <a.size())
            return a.get(index);
        return null;
    }
    private FootballPlayer getPlayerFromList(ArrayList<FootballPlayer> a, FootballPlayer fp){
        int index = a.indexOf(fp);
        return getPlayerFromList(a,index);
    }*/



    /*
    public FootballPlayer startingGetPlayer(int index){
        FootballPlayer ret = getPlayerFromList(starting, index);
        if(ret != null)
            return ret.clone();
        return null;
    }

    public FootballPlayer benchGetPlayer(int index){
        FootballPlayer ret = getPlayerFromList(bench, index);
        if(ret != null)
            return ret.clone();
        return null;
    }



    public void moveToBench(int index){
        FootballPlayer fp = getPlayerFromList(squad, index);
        if(fp != null && starting.contains(fp)){
            startingRemovePlayer(fp);
            benchAddPlayer(fp);
        }
    }

    public void moveToBench(FootballPlayer fp){
        int index = squad.indexOf(fp);
        moveToBench(index);
    }

    public void moveToStarting(int index){
        FootballPlayer fp = getPlayerFromList(squad, index);
        if(fp != null){
            int flag = startingAddPlayer(fp);
            if(flag == 1){
                startingRemovePlayer(fp);
                benchAddPlayer(fp);
            }
        }
    }


    public void moveToStarting (FootballPlayer fp){
        int index = squad.indexOf(fp);
        moveToStarting(index);
    }

    private int startingAddPlayer(FootballPlayer fp){
        if(!starting.contains(fp) && starting.size() <11) {
            if (fp instanceof GoalKeeper && filterByPosition(starting, Position.GOALKEEPER).size() == 0){
                starting.add(fp);
                return 1;
            }
            if(fp instanceof  Defender && filterByPosition(starting, Position.DEFENDER).size() < 2){
                starting.add(fp);
                return 1;
            }
            if(fp instanceof  Winger && filterByPosition(starting, Position.WINGER).size() < 2){
                starting.add(fp);
                return 1;
            }
            if(fp instanceof  MidFielder && filterByPosition(starting, Position.MIDFIELDER).size() < 4){
                starting.add(fp);
                return 1;
            }
            if(fp instanceof  Striker && filterByPosition(starting, Position.STRIKER).size() < 2){
                starting.add(fp);
                return 1;
            }
        }
        return 0;
    }

    private void startingRemovePlayer(FootballPlayer fp){
        starting.remove(fp);
    }


    private void benchAddPlayer(FootballPlayer fp){
        if(!bench.contains(fp))
            bench.add(fp);
    }

    private void benchRemovePlayer(FootballPlayer fp){
        bench.remove(fp);
    }

     */



/*
    private ArrayList<FootballPlayer> filterByPosition(ArrayList<FootballPlayer> a, Position pos){
        return (ArrayList<FootballPlayer>) a.stream().filter(p->p.getPosition() == pos).collect(Collectors.toList());
    }

    public int defensivePower(){
        ArrayList<FootballPlayer> gks = filterByPosition(this.starting, Position.GOALKEEPER);
        ArrayList<FootballPlayer> dfs = filterByPosition(this.starting, Position.DEFENDER);
        ArrayList<FootballPlayer> mds = filterByPosition(this.starting, Position.MIDFIELDER);
        ArrayList<FootballPlayer> wgs = filterByPosition(this.starting, Position.WINGER);
        ArrayList<FootballPlayer> sts = filterByPosition(this.starting, Position.STRIKER);
        double g = 0, d = 0, m = 0, w = 0, s = 0;
        if(gks.size()>0)
            g = (double) gks.stream().mapToInt(FootballPlayer::overall).sum()/gks.size() * 0.2;
        if(dfs.size()>0)
            d = (double) dfs.stream().mapToInt(FootballPlayer::overall).sum()/dfs.size() * 0.3;
        if(mds.size()>0)
            m = (double) mds.stream().mapToInt(FootballPlayer::overall).sum()/mds.size() * 0.2;
        if(wgs.size()>0)
            w = (double) wgs.stream().mapToInt(FootballPlayer::overall).sum()/wgs.size() * 0.2;
        if(sts.size()>0)
            s = (double) sts.stream().mapToInt(FootballPlayer::overall).sum()/sts.size() * 0.1;
        return (int) (d+g+m+w+s);
    }

    public int ofensivePower(){
        ArrayList<FootballPlayer> dfs = filterByPosition(this.starting,Position.DEFENDER);
        ArrayList<FootballPlayer> mds = filterByPosition(this.starting, Position.MIDFIELDER);
        ArrayList<FootballPlayer> wgs = filterByPosition(this.starting, Position.WINGER);
        ArrayList<FootballPlayer> sts = filterByPosition(this.starting, Position.STRIKER);
        double d = 0, m = 0, w = 0, s = 0;
        if(dfs.size()>0)
            d = (double) dfs.stream().mapToInt(FootballPlayer::overall).sum()/dfs.size() * 0.1;
        if(mds.size()>0)
            m = (double) mds.stream().mapToInt(FootballPlayer::overall).sum()/mds.size() * 0.3;
        if(wgs.size()>0)
            w = (double) wgs.stream().mapToInt(FootballPlayer::overall).sum()/wgs.size() * 0.2;
        if(sts.size()>0)
            s = (double) sts.stream().mapToInt(FootballPlayer::overall).sum()/sts.size() * 0.4;
        return (int) (d+m+w+s);
    }

    public int overallPower(){
        return starting.stream().mapToInt(FootballPlayer::overall).sum()/starting.size();
    }*/
}
