import java.util.ArrayList;

public class MidFielder extends FootballPlayer {


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
        if(recovery> 100)
            this.recovery= 100;
        else if(recovery < 0)
            this.recovery = 0;
        else
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
        return super.equals(o);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" | Recuperacao: ").append(this.recovery);
        return sb.toString();
    }

    public String toStringSimple(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringSimple()).append(" | Recuperacao: ").append(this.recovery);
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
        return (int) (this.getSpeed()*0.8 + this.getStamina()*1.5 + this.getAgility() + this.getJumping()*0.5
                + this.getHeading()*0.4 + this.getFinishing()*0.8 + this.getPassing()*1.5 + this.recovery * 1.5) / 8;
    }



    public static MidFielder parse(String input){
        String[] campos = input.split(",");
        return new MidFielder(campos[0], Integer.parseInt(campos[1]),
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
