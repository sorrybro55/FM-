import java.util.Arrays;
import java.util.Random;
/**
 * Escreva a descriÃ§Ã£o da classe Player aqui.
 * 
 * @author (seu name) 
 * 
 */
public class Player{
    private String name;
    private int age;
    
    
    public Player(){
        this.name = generateName();
        this.age = 20;
        
        
    }        
    
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        
    }   
    
    public Player(Player p){
        this.name = p.getName(); 
        this.age = p.getAge();
        
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
    
    public void increaseAge(){
        this.age +=1;
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Player p = (Player) o;
        return this.name == p.getName() && this.age == p.getAge();
    }
        
        
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.name).append("\nIdade: ").append(this.age);
        return sb.toString();
    }
    
    public Player clone(){
        return new Player(this);
    }
    
    private String generateName(){
        String[] firstName = {"Joao", "Miguel","Tiago","Rui","Jose","Luis","Daniel","Pedro","Vicente","Diogo","Oscar","Fernando"};
        String[] lastName = {"Silva", "Fernandes","Leite","Soares","Ferreira","Araujo","Lopes","Costa","Azevedo","Pinheiro","Cardoso","Abreu"};
        int f = (int) (Math.random()*firstName.length);
        int l = (int) (Math.random()*lastName.length);
        return firstName[f] + " " +lastName[l];
    }
}
   





