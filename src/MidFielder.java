import java.util.ArrayList;

public class MidFielder extends FootballPlayer{


    private int recovery;


    public MidFielder(){
        super();

    }

    public MidFielder (String name, int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, int recovery, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
        this.recovery = recovery;
    }

    public MidFielder(MidFielder md){
        super(md);
        this.recovery = md.getRecovery();
    }

    public int getRecovery(){
        return this.recovery;
    }

    public void setRecovery(int recovery){
        this.recovery = recovery;
    }

    public Position getPosition(){
        return Position.MIDFIELDER;
    }

    public MidFielder clone(){
        return new MidFielder(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        MidFielder md = (MidFielder) o;
        return super.equals(md) && this.recovery == md.getRecovery();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\nRecuperacao: ").append(this.recovery);
        return sb.toString();
    }


    public void increaseRecovery(int inc){
        setRecovery(this.recovery+ inc);
    }

    public void decreaseRecovery(int dec){
        setRecovery(this.recovery- dec);
    }

    public void increaseStats(int inc){
        super.increaseStats(inc);
        increaseRecovery(inc);
    }

    public void decreaseStats(int dec){
        super.decreaseStats(dec);
        decreaseRecovery(dec);
    }


    public int overall (){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getRecovery()) / 8;
    }

    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.stats()).append("\nRecuperacao: ").append(this.recovery);
        return sb.toString();
    }
}
