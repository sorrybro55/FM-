import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FootballTeam
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<FootballPlayer> squad;
    public int points;
    /**
     * Constructor for objects of class Team
     */
    public FootballTeam(){
        this.name = "Sem Nome";
        this.squad = new ArrayList<FootballPlayer>();
        this.points = 0;
    }
    
    public FootballTeam(String name, ArrayList<Player> squad, int points){
        this.name = name;
        setSquad(squad);
        this.points = points;
    }
    
    public FootballTeam(FootballTeam team){
        this.name = team.getName();
        setSquad(team.getSquad());
        this.points = team.getPoints();
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public ArrayList<Player> getSquad(){
        ArrayList<Player> r = new ArrayList<Player>();
        for (Player p : squad)
            r.add(p.clone());
        return r;
    }
    
    public void setSquad(ArrayList<Player> squad){
        this.squad = new ArrayList<FootballPlayer>();
        for (Player fp : squad)
            squad.add(fp.clone());
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    public FootballTeam clone(){
        return new FootballTeam(this);
    }
    
    public boolean equals(Object o){
        if (o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        FootballTeam t = (FootballTeam) o;
        return t.getName() == this.name && t.getSquad().equals(this.getSquad());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da Equipa: ").append(this.name).append("\nPlantel:\n");
        for (Player p : squad)
            sb.append(p).append("\n");
       return sb.toString(); 
    }
    
    public void addPlayer(FootballPlayer p){
        squad.add(p.clone());
    }
    
    public void removePlayer(int index){
        if (index <squad.size())
            squad.remove(index);
    }
    
    public Player getPlayer(int index){
        if (index <squad.size())
        return squad.get(index).clone();
        else return null;
    }
    
    public void updatePlayer(int index, FootballPlayer p){
        if (index <squad.size())
            squad.set(index,p);
    }
    
    public ArrayList<FootballPlayer> filterByPosition(Position pos){
        return (ArrayList<FootballPlayer>) squad.stream().filter(p->p.getPosition() == pos).collect(Collectors.toList());
    }
    
    public int defensiveOverall(){
        ArrayList<FootballPlayer> gks = filterByPosition(Position.GOALKEEPER);
        ArrayList<FootballPlayer> dfs = filterByPosition(Position.DEFENDER);
        ArrayList<FootballPlayer> mds = filterByPosition(Position.MIDFIELDER);
        ArrayList<FootballPlayer> wgs = filterByPosition(Position.WINGER);
        ArrayList<FootballPlayer> sts = filterByPosition(Position.STRIKER);
        double g = 0, d = 0, m = 0, w = 0, s = 0;
        if(gks.size()>0)
            g = gks.stream().mapToInt(p->p.overall()).sum()/gks.size() * 0.2;
        if(dfs.size()>0)
            d = dfs.stream().mapToInt(p->p.overall()).sum()/dfs.size() * 0.3;
        if(mds.size()>0)
            m = mds.stream().mapToInt(p->p.overall()).sum()/mds.size() * 0.2;
        if(wgs.size()>0)
            w = wgs.stream().mapToInt(p->p.overall()).sum()/wgs.size() * 0.2;
        if(sts.size()>0)
            s = sts.stream().mapToInt(p->p.overall()).sum()/sts.size() * 0.1;
        return (int) (d+g+m+w+s);
    }
    
    public int ofensiveOverall(){
        ArrayList<FootballPlayer> dfs = filterByPosition(Position.DEFENDER);
        ArrayList<FootballPlayer> mds = filterByPosition(Position.MIDFIELDER);
        ArrayList<FootballPlayer> wgs = filterByPosition(Position.WINGER);
        ArrayList<FootballPlayer> sts = filterByPosition(Position.STRIKER);
        double d = 0, m = 0, w = 0, s = 0;
        if(dfs.size()>0)
            d = dfs.stream().mapToInt(p->p.overall()).sum()/dfs.size() * 0.1;
        if(mds.size()>0)
            m = mds.stream().mapToInt(p->p.overall()).sum()/mds.size() * 0.3;
        if(wgs.size()>0)
            w = wgs.stream().mapToInt(p->p.overall()).sum()/wgs.size() * 0.2;
        if(sts.size()>0)
            s = sts.stream().mapToInt(p->p.overall()).sum()/sts.size() * 0.4;
        return (int) (d+m+w+s);
    }
    
    public int totalOverall(){
        return squad.stream().mapToInt(p->p.overall()).sum()/squad.size();
    }
        
        
    
 
        
            
            
        
    
        
        
        
        

   
}
