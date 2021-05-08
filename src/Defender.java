import java.util.ArrayList;



public class Defender extends FootballPlayer{

    public Defender(){
        super();

    }

    public Defender (String name,  int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name, number, speed, stamina, agility, jumping, heading, finishing, passing, team, career);
    }

    public Defender(Defender df){
        super(df);
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
        return super.equals(o);
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
                "Sem Equipa",
                new ArrayList<>());
    }
}
