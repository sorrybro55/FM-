import java.util.Arrays;
import java.util.Random;
/**
 * Escreva a descriÃ§Ã£o da classe Player aqui.
 * 
 * @author (seu name) 
 * 
 */
public class FootballPlayer{
    private String name;
    private int age;
    private Position position;
    private String team;
    
    public FootballPlayer(){
        this.name = generateName();
        this.age = 20;
        this.position = Position.ND;
        this.team = "Sem equipa";
        
    }        
    
    public FootballPlayer(String name, int age, Position position, String team){
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
    }   
    
    public FootballPlayer(FootballPlayer p){
        this.name = p.getName(); 
        this.age = p.getAge();
        this.position = p.getPosition();
        this.team = p.getTeam();
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getTeam(){
        return this.team;
    }
    
    public void setTeam(String team){
        this.team = team;
    }
    
    public void increaseAge(){
        this.age +=1;
    }
    
    public Position getPosition(){
        return this.position;
    }
    
    public void setPosition(Position position){
        this.position = position;
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        FootballPlayer fp = (FootballPlayer) o;
        return this.name == fp.getName() && this.age == fp.getAge() && this.position == fp.getPosition() && this.team == fp.getTeam();
    }
        
        
    public String toString(){
        return "Nome: " + this.name + ". " + "\nIdade: " + this.age + "\nPosi�ao: " + this.position +"\nEquipa: " + this.team +"\n";
    }
    
    public FootballPlayer clone(){
        return new FootballPlayer(this);
    }
    
    private String generateName(){
        String[] firstName = {"Joao", "Miguel","Tiago","Rui","Jose","Luis","Daniel","Pedro","Vicente","Diogo","Oscar","Fernando"};
        String[] lastName = {"Silva", "Fernandes","Leite","Soares","Ferreira","GonÃ§alves","Lopes","Costa","Azevedo","Pinheiro","Cardoso","Abreu"};
        int f = (int) (Math.random()*firstName.length);
        int l = (int) (Math.random()*lastName.length);
        return firstName[f] + " " +lastName[l];
    }
}
   





