import java.util.ArrayList;

public class Striker extends FootballPlayer{

    private int positioning;

    public Striker(){
        super();
    }

    public Striker (String name, int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing,int positioning, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
        this.positioning = positioning;
    }

    public Striker(Striker s){
        super(s);
        this.positioning = s.getPositioning();
    }

    public Position getPosition(){
        return Position.STRIKER;
    }
    
    public void setPositioning(int pos){
        this.positioning = pos;
    }
    
    public int getPositioning(){
        return this.positioning;
    }

    public Striker clone(){
        return new Striker(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Striker s = (Striker) o;
        return super.equals(o) && this.positioning == s.getPositioning();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\nPosicionamento: ").append(this.positioning);
        return sb.toString();
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
    
   public int overall (){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getPositioning()) / 8;
   }
   
   public String stats(){
       StringBuilder sb = new StringBuilder();
       sb.append(super.stats()).append("\nPosicionamento: ").append(this.getPositioning());
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
               Integer.parseInt(campos[9]),
               "Sem Equipa",
               new ArrayList<>());
   }
}
