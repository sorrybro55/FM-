
/**
 * Write a description of class GoalKeeperStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoalKeeperStats extends FieldPlayerStats
{
    // instance variables - replace the example below with your own
    private int elasticity;

    /**
     * Constructor for objects of class GoalKeeperStats
     */
    public GoalKeeperStats(){
        super();
        this.elasticity = 50;
    }
    
     public GoalKeeperStats(int speed, int stamina, int agility, int heading, int finishing, int passing, int elasticity){
        super(speed, stamina, agility, heading, finishing, passing);
        this.elasticity = elasticity;
    }
    
    public GoalKeeperStats(GoalKeeperStats gks){
        super(gks.getSpeed(), gks.getStamina(), gks.getAgility(), gks.getHeading(), gks.getFinishing(), gks.getPassing());
        this.elasticity = gks.getElasticity();
    }
    
    public int getElasticity(){
        return this.elasticity;
    }
    
    public void setElasticity(int elasticity){
        this.elasticity = elasticity;
    }
    
    public void increaseElasticity(int inc){
        this.elasticity += inc;
    }
    
    public void decreaseElasticity(int dec){
        this.elasticity -= dec;
    }
    
    
    public String toString(){
        //String aux = this.toString();
        return super.toString() + "\nElasticidade: " + this.elasticity; 
    }

    
}
