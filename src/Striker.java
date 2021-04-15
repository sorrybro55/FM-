import java.util.ArrayList;

public class Striker extends FootballPlayer{

    public Striker(){
        super();
        super.setPosition(Position.STRIKER);
    }

    public Striker (String name, int age, int number, int speed, int stamina, int agility, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, age, Position.STRIKER, number, speed, stamina, agility, heading, finishing, passing, team, career);
    }

    public Striker(Striker st){
        super(st);
    }

    public Striker clone(){
        return new Striker(this);
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
