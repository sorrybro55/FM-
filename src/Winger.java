import java.util.ArrayList;

public class Winger extends FootballPlayer{

    public Winger(){
        super();
        super.setPosition(Position.WINGER);
    }

    public Winger (String name, int age, int number, int speed, int stamina, int agility, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, age, Position.WINGER, number,  speed, stamina, agility, heading, finishing, passing, team, career);
    }

    public Winger(Winger wg){
        super(wg);
    }

    public Winger clone(){
        return new Winger(this);
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
