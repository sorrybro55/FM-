import java.util.ArrayList;



public class Defender extends FootballPlayer{

    private int marking;

    public Defender(){
        super();
        this.marking = 50;

    }

    public Defender (String name,  int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, int marking, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
        this.marking = marking;
    }

    public Defender(Defender df){
        super(df);
        this.marking = df.getMarking();
    }

    public int getMarking(){
        return this.marking;
    }

    public void setMarking(int marking){
        if(marking > 100)
            this.marking = 100;
        else if(marking < 0)
            this.marking =0;
        else
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

    public void decreaseStats(int dec){
        super.decreaseStats(dec);
        decreaseMarking(dec);
    }

    public Position getPosition(){
        return Position.DEFENDER;
    }

    public Defender clone(){
        return new Defender(this);
    }

    public int overall(){
        return (int) (this.getSpeed()*0.8 + this.getStamina()*0.7 + this.getAgility()*0.8 + this.getJumping()*1.5
                + this.getHeading()*1.5 + this.getFinishing()*0.4 + this.getPassing()*0.8 + this.marking*1.5) / 8;
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
        sb.append(super.toString()).append(" | Marcação: ").append(this.marking);
        return sb.toString();
    }

    public String toStringSimple(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringSimple()).append(" | Marcação: ").append(this.marking);
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
                50,
                "Sem Equipa",
                new ArrayList<>());
    }
}
