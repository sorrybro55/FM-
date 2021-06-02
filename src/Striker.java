import java.util.ArrayList;

public class Striker extends FootballPlayer implements Center{



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

    public int overall(){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing()) / 7;
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
                "Sem Equipa",
                new ArrayList<>());
    }
}
