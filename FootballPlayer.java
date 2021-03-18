import java.util.Arrays;
import java.util.Random;
/**
 * Escreva a descrição da classe Player aqui.
 * 
 * @author (seu name) 
 * Falta Implementar GK, Atualizar Overall para as posiçoes (diferentes pesos percentuais), apresentar clube de que o player faz parte;  
 */
public class FootballPlayer{
    private String name;
    private int age;
    //private FootballTeam team;
    
    public FootballPlayer(){
        this.name = generateName();
        this.age = 20; 
    }        
    
    public FootballPlayer(String name, int age){
        this.name = name;
        this.age = age;
    }   
    
    public FootballPlayer(FootballPlayer p){
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
    
    public String toString(){
        return "Nome: " + this.name + ". " + "Idade: " + this.age + ".";
    }
    
    public FootballPlayer clone(){
        return new FootballPlayer(this);
    }
    
    private String generateName(){
        String[] firstName = {"Joao", "Miguel","Tiago","Rui","Jose","Luis","Daniel","Pedro","Vicente","Diogo","Oscar","Fernando"};
        String[] lastName = {"Silva", "Fernandes","Leite","Soares","Ferreira","Gonçalves","Lopes","Costa","Azevedo","Pinheiro","Cardoso","Abreu"};
        int f = (int) (Math.random()*firstName.length);
        int l = (int) (Math.random()*lastName.length);
        return firstName[f] + " " +lastName[l];
    }
   
    /*
    public void setStats(int[] s){
        for(int i = 0; i<7 ; i++) this.player_stats[i] = s[i];
    }
    
    public int getOverall(){
        return this.overall;
    }
    
    public void setOverall(){
        int sum = Arrays.stream(player_stats).sum();
        int ovr = sum/7;
        this.overall= ovr;
        return this.overall;
    }
    
    public boolean equals(Object o){
        if(this == o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        FootballPlayer c = (FootballPlayer) o;
        return (this.name == c.getName() && this.age == c.getAge());
    }
    
    public String toString(){
        return ("Name: " + this.player_name + "\nAge: " + this.age + "\nPosition: " + this.position + "\nStats: .Velocidade: " + this.player_stats[0]+ "; .Resistencia: " + this.player_stats[1]+
                "; .Destreza: " + this.player_stats[2] + "; .Impulsao: " + this.player_stats[3] + "; .Jogo de cabeca: "+ this.player_stats[4] + "; .Remate: " +this.player_stats[5] + 
                "; Capacidade de passe: " + this.player_stats[6] + ";\n" + "Overall: "+ this.overall);
                
}*/



}    
