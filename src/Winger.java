import java.util.ArrayList;


public class Winger extends FootballPlayer{

    private int crossing;

    public Winger(){
        super();

    }

    public Winger (String name, int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, int crossing, String team, ArrayList<String> career){
        super(name, number,  speed, stamina, agility, jumping, heading, finishing, passing, team, career);
        this.crossing = crossing;
    }

    public Winger(Winger w){
        super(w);
        this.crossing = w.getCrossing();
    }

    public int getCrossing(){
        return this.crossing;
    }

    public void setCrossing(int crossing){
        this.crossing = crossing;
    }

    public Position getPosition(){
        return Position.WINGER;
    }

    public Winger clone(){
        return new Winger(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Winger w = (Winger) o;
        return super.equals(w) && this.crossing == w.getCrossing();
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\nCruzamento: ").append(this.crossing);
        return sb.toString();
    }


    public void increaseCrossing(int inc){
        setCrossing(this.crossing + inc);
    }

    public void decreaseCrossing(int dec){
        setCrossing(this.crossing - dec);
    }

    public void increaseStats(int inc){
        super.increaseStats(inc);
        increaseCrossing(inc);
    }

    public void decreaseStats(int dec){
        super.decreaseStats(dec);
        decreaseCrossing(dec);
    }


    public int overall (){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getCrossing()) / 8;
    }

    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.stats()).append("\nCruzamento: ").append(this.crossing);
        return sb.toString();
    }
}
