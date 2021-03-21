
/**
 * Write a description of class PlayerStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerStats
{
    // instance variables - replace the example below with your own
    private int speed;
    private int stamina;
    private int agility;
    private int heading;
    private int finishing;
    private int passing;
   
    /**
     * Constructor for objects of class PlayerStats
     */
    public PlayerStats(){
        // initialise instance variables
        this.speed = 50;
        this.stamina = 50;
        this.agility = 50;
        this.heading = 50;
        this.finishing = 50;
        this.passing = 50;
    }
    
    public PlayerStats(int speed, int stamina, int agility, int heading, int finishing, int passing){
        // initialise instance variables
        this.speed = speed;
        this.stamina = stamina;
        this.agility = agility;
        this.heading = heading;
        this.finishing = finishing;
        this.passing = passing;
        //this.overall = (this.speed + this.stamina + this.agility + this.heading + this.finishing + this.passing) / 6; //mudar mais tarde 
    }
    
    public PlayerStats(PlayerStats fps){
        this.speed = fps.getSpeed();
        this.stamina = fps.getStamina();
        this.agility = fps.getAgility();
        this.heading = fps.getHeading();
        this.finishing = fps.getFinishing();
        this.passing = fps.getPassing();
        //this.overall = (this.speed + this.stamina + this.agility + this.heading + this.finishing + this.passing) / 6;
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
    
    public void setSpeed(int speed){
        if (speed > 100)
            this.speed = 100;
        else if (speed <0)
            this.speed = 0;
        else
            this.speed = speed;
    }
    
    public void setStamina(int stamina){
        if (stamina > 100)
            this.stamina = 100;
        else if (stamina <0)
            this.stamina = 0;
        else
            this.stamina = stamina;
    }
    
    public void setAgility(int agility){
        if (agility > 100)
            this.agility = 100;
        else if (agility <0)
            this.agility = 0;
        else
            this.agility = agility;
    }
    
    public void setHeading(int heading){
        if (heading > 100)
            this.heading = 100;
        else if (heading <0)
            this.heading = 0;
        else
            this.heading = heading;
    }
    
    public void setFinishing(int finishing){
        if (finishing > 100)
            this.finishing = 100;
        else if (finishing <0)
            this.finishing = 0;
        else
            this.finishing = finishing;
    }
    
    public void setPassing(int passing){
        if (passing > 100)
            this.passing = 100;
        else if (passing <0)
            this.passing = 0;
        else
            this.passing = passing;
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
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        PlayerStats ps = (PlayerStats) o;
        return this.speed == ps.getSpeed() && this.stamina == ps.getStamina() && this.agility == ps.getAgility() &&
               this.heading == ps.getHeading() && this.finishing == ps.getFinishing() && this.passing == ps.getPassing();
    }
    
    public PlayerStats clone(){
        return new PlayerStats(this);
    }
    
    public String toString(){
        return "Velocidade: " + this.speed + "\nResistencia: " + this.stamina + "\nDestreza: " + this.agility + 
               "\nJogo de Cabeca: " + this.heading + "\nRemate: " + this.finishing + "\nCapacidade de Passe: " + this.passing;
    }
}
