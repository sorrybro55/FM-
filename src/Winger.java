import java.util.ArrayList;


public class Winger extends FootballPlayer {

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
        if(crossing> 100)
            this.crossing = 100;
        else if(crossing < 0)
            this.crossing =0;
        else
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
        return super.equals(o);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" | Cruzamento: ").append(this.crossing);
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
        return (int) (this.getSpeed()*1.5 + this.getStamina()*1.5 + this.getAgility()*1.5 + this.getJumping()*0.2
                + this.getHeading()*0.2 + this.getFinishing()*0.8 + this.getPassing()*0.8 + this.crossing*1.5) / 8;
    }

    public String toStringSimple(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringSimple()).append(" | Cruzamento: ").append(this.crossing);
        return sb.toString();
    }

    public static Winger parse(String input){
        String[] campos = input.split(",");
        return new Winger(campos[0], Integer.parseInt(campos[1]),
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
