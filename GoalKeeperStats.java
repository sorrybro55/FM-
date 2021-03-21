
/**
 * Write a description of class GoalKeeperStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoalKeeperStats extends PlayerStats
{
    // instance variables - replace the example below with your own
    private int elasticity;
    private int overall;
    /**
     * Constructor for objects of class GoalKeeperStats
     */
    public GoalKeeperStats(){
        super();
        this.elasticity = 50;
        setOverall();
    }
    
     public GoalKeeperStats(int speed, int stamina, int agility, int heading, int finishing, int passing, int elasticity){
        super(speed, stamina, agility, heading, finishing, passing);
        this.elasticity = elasticity;
        this.overall = (speed + stamina + agility + heading + finishing + passing+ elasticity) / 7;
    }
    
    public GoalKeeperStats(GoalKeeperStats gks){
        super(gks.getSpeed(), gks.getStamina(), gks.getAgility(), gks.getHeading(), gks.getFinishing(), gks.getPassing());
        this.elasticity = gks.getElasticity();
    }
    public int getElasticity(){
        return this.elasticity;
    }
    
    public void setElasticity(int elasticity){
        if (elasticity > 100)
            this.elasticity = 100;
        else if (elasticity <0)
            this.elasticity = 0;
        else
            this.elasticity = elasticity;
        setOverall();
    }
    
    
    public void setSpeed(int speed){
        super.setSpeed(speed);
        setOverall();
    }
    
    public void setStamina(int stamina){
        super.setStamina(stamina);
        setOverall();
    }
    
    public void setAgility(int agility){
        super.setAgility(agility);
        setOverall();
    }
    
    public void setHeading(int heading){
        super.setHeading(heading);
        setOverall();
    }
    
    public void setFinishing(int finishing){
        super.setFinishing(finishing);
        setOverall();
    }
    
    public void setPassing(int passing){
        super.setPassing(passing);
        setOverall();
    }
    
    public void increaseElasticity(int inc){
        setElasticity( getElasticity() + inc);
    }
    
    public void decreaseElasticity(int dec){
        setElasticity( getElasticity() - dec);
    }
    
    public void increaseSpeed(int inc){
        setSpeed(getSpeed()+inc);
    }
    
    public void increaseStamina(int inc){
        setStamina(getStamina() + inc);
    }
    
    public void increaseAgility(int inc){
        setAgility(getAgility() + inc);
    }
    
    public void increaseHeading(int inc){
        setHeading(getHeading() + inc);
    }
    
    public void increaseFinishing(int inc){
        setFinishing(getFinishing() + inc);
    }
    
    public void increasePassing(int inc){
        setPassing(getPassing() + inc);
    }
    
    public void decreaseSpeed(int dec){
        setSpeed(getSpeed() - dec);
    }
    
    public void decreaseStamina(int dec){
        setStamina(getStamina() - dec);
    }
    
    public void decreaseAgility(int dec){
        setAgility(getAgility() - dec);
    }
    
    public void decreaseHeading(int dec){
        setHeading(getHeading() - dec);
    }
    
    public void decreaseFinishing(int dec){
        setFinishing(getFinishing() - dec);
    }
    
    public void decreasePassing(int dec){
        setPassing(getPassing() - dec);
    }
    
    public int getOverall(){
        return this.overall;
    }
    
    public void setOverall(){
        this.overall = (this.getSpeed() + this.getStamina() + this.getAgility() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getElasticity()) / 7;
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        GoalKeeperStats gks = (GoalKeeperStats) o;
        PlayerStats ps = (PlayerStats) o;
        return super.equals(ps) && this.elasticity == gks.getElasticity();
    }
    
    
    
    public GoalKeeperStats clone(){
        return new GoalKeeperStats(this);
    }
    
    
    public String toString(){
        return super.toString() + "\nElasticidade: " + this.elasticity + "\nOverall: " +this.overall; 
    }

    
}
