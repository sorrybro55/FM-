
    
/**
 * Write a description of class FieldPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FieldPlayer extends FootballPlayer
{
    // instance variables - replace the example below with your own
    private FieldPlayerStats stats;

    /**
     * Constructor for objects of class FieldPlayer
     */
    public FieldPlayer(){
        super();
        stats = new FieldPlayerStats();
    }
    
    public FieldPlayer(String name, int age, Position position, FieldPlayerStats stats, String team){
        super(name, age, position, team);
        this.stats = stats.clone();
    }
    
    public FieldPlayer(FieldPlayer fp){
        super(fp.getName(), fp.getAge(), fp.getPosition(), fp.getTeam());
        this.stats = fp.getStats().clone();
    }
    
    public FieldPlayerStats getStats(){
        return this.stats;
    }
    
    public void setStats(FieldPlayerStats stats){
        this.stats = stats.clone();
    }
    
    public FieldPlayer clone(){
        return new FieldPlayer(this);
    }
    
    public String toString(){
        return super.toString() + stats;
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        FieldPlayer fp = (FieldPlayer) o;
        FootballPlayer f = (FootballPlayer) o;
        return super.equals(f) && this.stats.equals(fp.getStats());
    }
        
    
   

}
