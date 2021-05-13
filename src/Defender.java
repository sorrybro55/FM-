import java.util.ArrayList;



public class Defender extends FootballPlayer{
    
    private int marking;

    public Defender(){
        super();

    }

    public Defender (String name,  int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, int marking, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
        this.marking = marking;
    }

    public Defender(Defender df){
        super(df);
        this.marking = df.getMarking();
    }

    public Position getPosition(){
        return Position.DEFENDER;
    }

    public Defender clone(){
        return new Defender(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Defender d = (Defender) o;    
        return super.equals(o) && this.marking == d.getMarking();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Marcacao: ").append(this.marking);
        return sb.toString();
    }
    
    public int getMarking(){
        return this.marking;
    }
    
    public void setMarking(int marking){
        this.marking = marking;
    }
    
    public void increaseMarking(int inc){
        setMarking(this.marking + inc);
    }
    
    public void decreaseMarking(int inc){
        setMarking(this.marking - inc);
    }
    
    public void increaseStats(int inc){
        super.increaseStats(inc);
        increaseMarking(inc);
    }
    
    public void decreaseStats(int inc){
        super.decreaseStats(inc);
        decreaseMarking(inc);
    }
    
    public int overall (){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing() + this.getMarking()) / 8;
    }
    
    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.stats()).append("\nMarcacao: ").append(this.marking);
        return sb.toString();
    }

    public static Defender parse(String input) {
        String[] campos = input.split(",");
        return new Defender(campos[0], Integer.parseInt(campos[1]),
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
