import java.util.ArrayList;
    
/**
 * Write a description of class FieldPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FieldPlayer extends FootballPlayer
{
   

    /**
     * Constructor for objects of class FieldPlayer
     */
    public FieldPlayer(){
        super();
    }
    
    public FieldPlayer(String name, int age, Position position,int speed, int stamina, int agility, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, age, position,speed, stamina, agility, heading, finishing, passing,  team, career);
  
    }
    
    public FieldPlayer(FieldPlayer fp){
        super(fp);
    }
    
    public FieldPlayer clone(){
        return new FieldPlayer(this);
    }
    
    public String toString(){
        return super.toString();
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        FieldPlayer fp = (FieldPlayer) o;
        FootballPlayer f = (FootballPlayer) o;
        return super.equals(f);
    }
    
    public int overall(){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getHeading() + this.getFinishing() + this.getPassing()) / 6;
    }
    
    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.stats()).append("\nOverall: ").append(overall());
        return sb.toString();
    }
        
        
    
   

}
