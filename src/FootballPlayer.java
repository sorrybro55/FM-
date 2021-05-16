
import java.io.Serializable;
import java.util.ArrayList;
public class FootballPlayer extends Player implements  Comparable<FootballPlayer>
{


    private int number;
    private int speed;
    private int stamina;
    private int agility;
    private int jumping;
    private int heading;
    private int finishing;
    private int passing;
    private String team;
    private ArrayList<String> career;


    
    public FootballPlayer(){
        super();
        this.number = -1;
        this.speed = 50;
        this.stamina = 50;
        this.agility = 50;
        this.jumping = 50;
        this.heading = 50;
        this.finishing = 50;
        this.passing = 50;
        this.team = "Sem Equipa";
        this.career = new ArrayList<String>();
        
    }        
    
    public FootballPlayer(String name,  int number, int speed, int stamina, int agility, int jumping, int heading, int finishing, int passing, String team, ArrayList<String> career){
        super(name);
        this.number = number;
        this.speed = speed;
        this.stamina = stamina;
        this.agility = agility;
        this.jumping = jumping;
        this.heading = heading;
        this.finishing = finishing;
        this.passing = passing;
        this.team = team;
        setCareer(career);
    }   
    
    public FootballPlayer(FootballPlayer p){
        super(p);
        this.number = p.getNumber();
        this.speed = p.getSpeed();
        this.stamina = p.getStamina();
        this.agility = p.getAgility();
        this.jumping = p.getJumping();
        this.heading = p.getHeading();
        this.finishing = p.getFinishing();
        this.passing = p.getPassing();
        this.team = p.getTeam();
        setCareer(p.getCareer());
    }
    
    public String getTeam(){
        return this.team;
    }
    
    public void setTeam(String team){
        this.team = team;
    }
    
    public Position getPosition(){
        return Position.ND;
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public int getStamina(){
        return this.stamina;
    }
    
    public int getAgility(){
        return this.agility;
    }

    public int getJumping(){
        return this.jumping;
    }
    
    public int getHeading(){
        return this.heading;
    }
    
    public int getFinishing(){
        return this.finishing;
    }
    
    public int getPassing(){
        return this.passing;
    }
    
    public void setSpeed(int speed){
        if (speed > 100)
            this.speed = 100;
        else if (speed <0)
            this.speed = 0;
        else
            this.speed = speed;
    }
    
    public void setStamina(int stamina){
        if (stamina > 100)
            this.stamina = 100;
        else if (stamina <0)
            this.stamina = 0;
        else
            this.stamina = stamina;
    }
    
    public void setAgility(int agility){
        if (agility > 100)
            this.agility = 100;
        else if (agility <0)
            this.agility = 0;
        else
            this.agility = agility;
    }

    public void setJumping(int jumoing){
        this.jumping = jumping;
    }
    
    public void setHeading(int heading){
        if (heading > 100)
            this.heading = 100;
        else if (heading <0)
            this.heading = 0;
        else
            this.heading = heading;
    }
    
    public void setFinishing(int finishing){
        if (finishing > 100)
            this.finishing = 100;
        else if (finishing <0)
            this.finishing = 0;
        else
            this.finishing = finishing;
    }
    
    public void setPassing(int passing){
        if (passing > 100)
            this.passing = 100;
        else if (passing <0)
            this.passing = 0;
        else
            this.passing = passing;
    }
    
    public ArrayList<String> getCareer(){
        return (ArrayList<String>) this.career.clone();
    }
    
    public void setCareer(ArrayList<String> career){
        this.career = (ArrayList<String>) career.clone();
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        FootballPlayer fp = (FootballPlayer) o;
        return super.equals(fp)  && this.getPosition() == fp.getPosition() && this.number == fp.getNumber() && this.team == fp.getTeam();
    }
        
        
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" | Posição: ").append(this.getPosition())
        .append("\nClube Atual: ").append(this.team).append(" | Clubes Anteiores: ");
        for (String c : career)
            sb.append(c);
        sb.append("\nVelocidade: ").append(this.speed).append(" | Resistencia: ").append(this.stamina).append(" | Destreza: ").append(this.agility);
        sb.append(" | Jogo de Cabeca: ").append(this.heading).append(" | Remate: ").append(this.finishing);
        sb.append(" | Capacidade de Passe: ").append(this.passing);

        return sb.toString();
    }



    
    public FootballPlayer clone(){
        return new FootballPlayer(this);
    }

    public int compareTo(FootballPlayer fp){
        int aux;
        aux = this.getPosition().compareTo(fp.getPosition());
        if (aux != 0)
            return aux;

        return this.getName().compareTo(fp.getName());

    }
    
    public void increaseSpeed(int inc){
        setSpeed(this.speed+inc);
    }
    
    public void increaseStamina(int inc){
        setStamina(this.stamina + inc);
    }

    public void increaseJumping(int inc){
        setJumping(this.jumping + inc);
    }
    
    public void increaseAgility(int inc){
        setAgility(this.agility + inc);
    }
    
    public void increaseHeading(int inc){
        setHeading(this.heading + inc);
    }
    
    public void increaseFinishing(int inc){
        setFinishing(this.finishing + inc);
    }
    
    public void increasePassing(int inc){
        setPassing(this.passing + inc);
    }
    
    public void decreaseSpeed(int dec){
        setSpeed(this.speed - dec);
    }
    
    public void decreaseStamina(int dec){
        setStamina(this.stamina - dec);
    }

    public void decreaseJumping(int dec){
        setJumping(this.jumping - dec);
    }
    
    public void decreaseAgility(int dec){
        setAgility(this.agility - dec);
    }
    
    public void decreaseHeading(int dec){
        setHeading(this.heading - dec);
    }
    
    public void decreaseFinishing(int dec){
        setFinishing(this.finishing - dec);
    }
    
    public void decreasePassing(int dec){
        setPassing(this.passing - dec);
    }
    
    public void increaseStats(int inc){
        increaseSpeed(inc);
        increaseStamina(inc);
        increaseAgility(inc);
        increaseJumping(inc);
        increaseHeading(inc);
        increaseFinishing(inc);
        increasePassing(inc);
    }
    
    public void decreaseStats(int dec){
        decreaseSpeed(dec);
        decreaseStamina(dec);
        decreaseAgility(dec);
        decreaseJumping(dec);
        decreaseHeading(dec);
        decreaseFinishing(dec);
        decreasePassing(dec);
    }
        
    
    public int overall(){
        return (this.getSpeed() + this.getStamina() + this.getAgility() + this.getJumping() + this.getHeading() + this.getFinishing() + this.getPassing()) / 7;
    }
    
    public void switchTeam(String team){
        if(!this.team.equals("Sem Equipa"))
            career.add(this.team);
        this.team = team;
    }

    public String stats(){
        StringBuilder sb = new StringBuilder();
        sb.append("Velocidade: ").append(this.speed).append(" | Resistencia: ").append(this.stamina).append(" | Destreza: ").append(this.agility);
        sb.append(" | Impulsao: ").append(this.jumping).append(" | Jogo de Cabeca: ").append(this.heading).append(" | Remate: ").append(this.finishing);
        sb.append(" | Capacidade de Passe: ").append(this.passing);
        return sb.toString();
    }
    

        
        
   
        
}
