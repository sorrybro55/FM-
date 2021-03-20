
/**
 * Write a description of class PlayerStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FieldPlayerStats
{
    // instance variables - replace the example below with your own
    private int speed;
    private int stamina;
    private int agility;
    private int heading;
    private int finishing;
    private int passing;
    private int overall;
    FootballPlayer fp = new FootballPlayer();

    /**
     * Constructor for objects of class PlayerStats
     */
    public FieldPlayerStats(){
        // initialise instance variables
        this.speed = 50;
        this.stamina = 50;
        this.agility = 50;
        this.heading = 50;
        this.finishing = 50;
        this.passing = 50;
        this.overall = 50;
    }
    
    public FieldPlayerStats(int speed, int stamina, int agility, int heading, int finishing, int passing){
        // initialise instance variables
        this.speed = speed;
        this.stamina = stamina;
        this.agility = agility;
        this.heading = heading;
        this.finishing = finishing;
        this.passing = passing;
        this.overall = (this.speed + this.stamina + this.agility + this.heading + this.finishing + this.passing) / 6; //mudar mais tarde 
    }
    
    public FieldPlayerStats(FieldPlayerStats fps){
        this.speed = fps.getSpeed();
        this.stamina = fps.getStamina();
        this.agility = fps.getAgility();
        this.heading = fps.getHeading();
        this.finishing = fps.getFinishing();
        this.passing = fps.getPassing();
        this.overall = (this.speed + this.stamina + this.agility + this.heading + this.finishing + this.passing) / 6;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public int getStamina(){
        return this.stamina;
    }
    
    public int getAgility(){
        return this.agility;
    }
    
    public int getHeading(){
        return this.heading;
    }
    
    public int getFinishing(){
        return this.finishing;
    }
    
    public int getPassing(){
        return this.passing;
    }
    
    public int getOverall(){
        return this.overall;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void setStamina(int stamina){
        this.stamina = stamina;
    }
    
    public void setAgility(int agility){
        this.agility = agility;
    }
    
    public void setHeading(int heading){
        this.heading = heading;
    }
    
    public void setFinishing(int finishing){
        this.finishing = finishing;
    }
    
    public void setPassing(int passing){
        this.passing = passing;
    }
    
    public void setOverall(int speed, int stamina, int agility, int heading, int finishing, int passing){
        this.overall = (speed + stamina + agility + heading + finishing + passing) / 6;
    }
    
    public void increaseSpeed(int inc){
        this.speed += inc;
    }
    
    public void increaseStamina(int inc){
        this.stamina += inc;
    }
    
    public void increaseAgility(int inc){
        this.agility += inc;
    }
    
    public void increaseHeading(int inc){
        this.heading += inc;
    }
    
    public void increaseFinishing(int inc){
        this.finishing += inc;
    }
    
    public void increasePassing(int inc){
        this.passing += inc;
    }
    
    public void decreaseSpeed(int dec){
        this.speed -= dec;
    }
    
    public void decreaseStamina(int dec){
        this.stamina -= dec;
    }
    
    public void decreaseAgility(int dec){
        this.agility -= dec;
    }
    
    public void decreaseHeading(int dec){
        this.heading -= dec;
    }
    
    public void decreaseFinishing(int dec){
        this.finishing += dec;
    }
    
    public void decreasePassing(int dec){
        this.passing += dec;
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        FieldPlayerStats fps = (FieldPlayerStats) o;
        return this.speed == fps.getSpeed() && this.stamina == fps.getStamina() && this.agility == fps.getAgility() &&
               this.heading == fps.getHeading() && this.finishing == fps.getFinishing() && this.passing == fps.getPassing();
    }
    
    public FieldPlayerStats clone(){
        return new FieldPlayerStats(this);
    }
    
    public String toString(){
        return "Velocidade: " + this.speed + "\nResistencia: " + this.stamina + "\nDestreza: " + this.agility + 
               "\nJogo de Cabeça: " + this.heading + "\nRemate: " + this.finishing + "\nCapacidade de Passe: " + this.passing;
    }
}
