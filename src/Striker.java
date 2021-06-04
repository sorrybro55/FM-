import java.util.ArrayList;

public class Striker extends FootballPlayer {

    private int positioning;

    public Striker(){
        super();
        this.positioning = 50;
    }

    public Striker (String name, int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, int positioning, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
        this.positioning = positioning;
    }

    public Striker(Striker s){
        super(s);
        this.positioning = s.getPositioning();
    }

    public void setPositioning(int positioning){
        if(positioning > 100)
            this.positioning = 100;
        else if(positioning < 0)
            this.positioning =0;
        else
            this.positioning = positioning;
    }

    public int getPositioning(){
        return this.positioning;
    }

    public void increasePositioning(int inc){
        setPositioning(this.positioning + inc);
    }

    public void decreasePositioning(int inc){
        setPositioning(this.positioning - inc);
    }

    public void increaseStats(int inc){
        super.increaseStats(inc);
        increasePositioning(inc);
    }

    public void decreaseStats(int inc){
        super.decreaseStats(inc);
        decreasePositioning(inc);
    }


    public Position getPosition(){
        return Position.STRIKER;
    }

    public Striker clone(){
        return new Striker(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        return super.equals(o);
    }

    public int overall(){
        return (int) (this.getSpeed() + this.getStamina()*0.8 + this.getAgility() + this.getJumping()
                + this.getHeading() + this.getFinishing()*1.2 + this.getPassing()*0.8 + this.positioning*1.2) / 8;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" | Posicionamento: ").append(this.positioning);
        return sb.toString();
    }

    public String toStringSimple(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringSimple()).append(" | Posicionamento: ").append(this.positioning);
        return sb.toString();
    }

    public static Striker parse(String input) {
        String[] campos = input.split(",");
        return new Striker(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                50,
                "Sem Equipa",
                new ArrayList<>());
    }
}
