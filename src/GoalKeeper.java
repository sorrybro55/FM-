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



    public GoalKeeper(){
        super();
        this.elasticity = 50;
        
    }
    
    public GoalKeeper(String name, int number,  int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, int elasticity, String team, ArrayList<String> career){
        super(name, number ,speed, stamina, agility, jumping, heading, finishing, passing,  team, career);
        this.elasticity = elasticity;
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

    public Position getPosition(){
        return Position.GOALKEEPER;
    }
    
    public GoalKeeper clone(){
        return new GoalKeeper(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n Elasticidade: ").append(this.elasticity);
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        GoalKeeper gk = (GoalKeeper) o;
        return super.equals(gk) && gk.getElasticity() == this.elasticity;
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
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getElasticity()) / 8;
    }
    
    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.stats()).append("\nElasticidade: ").append(this.elasticity);
        return sb.toString();
    }

    public static GoalKeeper parse(String input){
        String[] campos = input.split(",");
        return new GoalKeeper(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                "Sem Equipa",
                new ArrayList<>());
    }

}
