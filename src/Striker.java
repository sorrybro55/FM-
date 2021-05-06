import java.util.ArrayList;

public class Striker extends FootballPlayer{



    public Striker(){
        super();
    }

    public Striker (String name, int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
    }

    public Striker(Striker s){
        super(s);
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
}
