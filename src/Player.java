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
    
    
    public Player(){
        this.name = "Sem Nome";
    }        
    
    public Player(String name){
        this.name = name;
        
    }   
    
    public Player(Player p){
        this.name = p.getName();
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Player p = (Player) o;
        return this.name == p.getName();
    }
        
        
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.name);
        return sb.toString();
    }
    
    public Player clone(){
        return new Player(this);
    }

    
}
   





