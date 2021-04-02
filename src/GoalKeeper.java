import java.util.ArrayList;
/**
 * Write a description of class GoalKeeper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoalKeeper extends FootballPlayer
{
    private int elasticity;

    /**
     * Constructor for objects of class FieldPlayer
     */
    public GoalKeeper(){
        super();
        super.setPosition(Position.DEFENDER);
        this.elasticity = 50;
        
    }
    
    public GoalKeeper(String name, int age,int speed, int stamina, int agility, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, age, Position.GOALKEEPER ,speed, stamina, agility, heading, finishing, passing,  team, career);
    }
    
    public GoalKeeper(GoalKeeper gk){
        super(gk);
        this.elasticity = gk.getElasticity();
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
    }
    
    public GoalKeeper clone(){
        return new GoalKeeper(this);
    }
    
    public String toString(){

        return super.toString();
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        GoalKeeper gk = (GoalKeeper) o;
        FootballPlayer f = (FootballPlayer) o;
        return super.equals(f) && gk.getElasticity() == this.elasticity;
    }
    
    public void increaseElasticity(int inc){
        setElasticity(this.elasticity + inc);
    }
    
    public void decreaseElasticity(int dec){
        setElasticity(this.elasticity - dec);
    }
    
    public void increaseStats(int inc){
        super.increaseStats(inc);
        increaseElasticity(inc);
    }
    
    public void decreaseStats(int dec){
        super.decreaseStats(dec);
        decreaseElasticity(dec);
    }
    
 
    public int overall (){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getElasticity()) / 7;
    }
    
    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.stats()).append("\nElasticidade: ").append(this.elasticity);
        return sb.toString();
    }

}
