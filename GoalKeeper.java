
/**
 * Write a description of class GoalKeeper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoalKeeper extends FootballPlayer
{
    // instance variables - replace the example below with your own
    private GoalKeeperStats stats;

    /**
     * Constructor for objects of class FieldPlayer
     */
    public GoalKeeper(){
        super();
        setPosition(Position.GOALKEEPER);
        stats = new GoalKeeperStats();
    }
    
    public GoalKeeper(String name, int age, Position position, GoalKeeperStats stats, String team){
        super(name, age, Position.GOALKEEPER, team);
        this.stats = stats.clone();
    }
    
    public GoalKeeper(GoalKeeper gk){
        super(gk.getName(), gk.getAge(), gk.getPosition(), gk.getTeam());
        this.stats = gk.getStats().clone();
    }
    
    public GoalKeeperStats getStats(){
        return this.stats;
    }
    
    public void setStats(GoalKeeperStats stats){
        this.stats = stats.clone();
    }
    
    public GoalKeeper clone(){
        return new GoalKeeper(this);
    }
    
    public String toString(){
        return super.toString() + stats;
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        GoalKeeper gk = (GoalKeeper) o;
        FootballPlayer f = (FootballPlayer) o;
        return super.equals(f) && this.stats.equals(gk.getStats());
    }
}
