import java.util.ArrayList;

public class Defender extends FootballPlayer{

    public Defender(){
        super();
        super.setPosition(Position.DEFENDER);
    }

    public Defender (String name, int age, int speed, int stamina, int agility, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, age, Position.DEFENDER, speed, stamina, agility, heading, finishing, passing, team, career);
    }

    public Defender(Defender df){
        super(df);
    }

    public Defender clone(){
        return new Defender(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        FootballPlayer f = (FootballPlayer) o;
        return super.equals(f);
    }
}
