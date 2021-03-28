import java.util.ArrayList;
/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Team
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<FootballPlayer> squad;
    /**
     * Constructor for objects of class Team
     */
    public Team(){
        this.name = "Sem Nome";
        this.squad = new ArrayList<FootballPlayer>();
    }
    
    public Team(String name, ArrayList<FootballPlayer> squad){
        this.name = name;
        setSquad(squad);
    }
    
    public Team(Team team){
        this.name = team.getName();
        setSquad(team.getSquad());
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public ArrayList<FootballPlayer> getSquad(){
        ArrayList<FootballPlayer> r = new ArrayList<FootballPlayer>();
        for (FootballPlayer fp : squad)
            r.add(fp.clone());
        return r;
    }
    
    public void setSquad(ArrayList<FootballPlayer> squad){
        this.squad = new ArrayList<FootballPlayer>();
        for (FootballPlayer fp : squad)
            squad.add(fp.clone());
    }
    
    public Team clone(){
        return new Team(this);
    }
    
    public boolean equals(Object o){
        if (o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Team t = (Team) o;
        return t.getName() == this.name && t.getSquad().equals(this.getSquad());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        GoalKeeper gk;
        FieldPlayer fp;
        sb.append(this.name).append("\n");
        for (FootballPlayer f : squad){
            sb.append(f.getPosition()).append(" | ").append(f.getName()).append(" | ").append(f.getAge()).append(" Anos | Nivel: ");
            if (f instanceof GoalKeeper){
                gk = (GoalKeeper) f;
                sb.append(gk.overall());
            }
            else{
                fp = (FieldPlayer) f;
                sb.append(fp.overall());
            }
            sb.append("\n");  
        }
       return sb.toString(); 
    }
    
    public void addFootballPlayer(FootballPlayer fp){
        squad.add(fp.clone());
    }
    
    public void removeFootballPlayer(FootballPlayer fp){
        squad.remove(fp);
    }
        
        
        

   
}
