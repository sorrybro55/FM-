
/**
 * Write a description of class FieldPalyerStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FieldPlayerStats extends PlayerStats
{
    // instance variables - replace the example below with your own
    private int overall;

    /**
     * Constructor for objects of class FieldPalyerStats
     */
    public FieldPlayerStats(){
        super();
        setOverall();
    }
    
    public FieldPlayerStats(int speed, int stamina, int agility, int heading, int finishing, int passing){
        super(speed, stamina, agility, heading, finishing, passing);
        setOverall();
    }
    
    public FieldPlayerStats(FieldPlayerStats fp){
        super(fp.getSpeed(), fp.getStamina(), fp.getAgility(), fp.getHeading(), fp.getFinishing(), fp.getPassing());
        setOverall();
    }
    
    private void setOverall(){
        this.overall = (this.getSpeed() + this.getStamina() + this.getAgility() + this.getHeading() + this.getFinishing() + this.getPassing()) / 6;
    }

    public int getOverall(){
        return this.overall;
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
        return super.equals(ps);
    }
    
    public FieldPlayerStats clone(){
        return new FieldPlayerStats(this);
    }
    
    public String toString(){
        //String aux = this.toString();
        return super.toString() +  "\nOverall: " +this.overall; 
    }
}


