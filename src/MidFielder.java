import java.util.ArrayList;

public class MidFielder extends FootballPlayer{

    public MidFielder(){
        super();
        super.setPosition(Position.MIDFIELDER);
    }

    public MidFielder (String name, int age, int speed, int stamina, int agility, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, age, Position.MIDFIELDER, speed, stamina, agility, heading, finishing, passing, team, career);
    }

    public MidFielder(MidFielder md){
        super(md);
    }

    public MidFielder clone(){
        return new MidFielder(this);
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
