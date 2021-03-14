import java.util.Arrays;
/**
 * Escreva a descrição da classe Player aqui.
 * 
 * @author (seu name) 
 * Falta Implementar GK, Atualizar Overall para as posiçoes (diferentes pesos percentuais), apresentar clube de que o player faz parte;  
 */
public class Player{
    private String player_name;
    private int age;
    private String position;
    private int[] player_stats;
    private int overall; 
    
    
    public Player(){
        this.player_name = "---";
        this.age = 0;
        this.position = "---";
        this.player_stats = new int[] {0, 0, 0, 0, 0, 0, 0};   
    }        
    
    public Player(String name, int nAge, String nPos, int[] v){
        this.player_name = name;
        this.age = nAge;
        this.position = nPos;
        for(int i=0; i<7; i++) this.player_stats[i] = v[i];
    }   
    
    public Player(Player p){
        this.player_name = p.player_name; 
        this.age = p.age;
        this.position = p.position;
        for(int i=0; i<7;i++) this.player_stats[i] = p.player_stats[i];
    }
    
    public String getName(){
        return this.player_name;
    }
    
    public void setName(String n){
        this.player_name = n;
    }
    
    public Int getAge(){
        return this.age;
    }
    
    public void setAge(int a){
        this.age = a;
    }
    
    public String getPosition(){
        return this.position;
    }
    
    public void setPosition(String pos){
        this.position = pos;
    }
    
    public int[] getStats(){
        return this.player_stats;
    }
    
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
        Player c = (Player) o;
        return (this.getName() == c.getName && this.getAge() == c.getAge);
    }
    
    public String toString(){
        return ("Name: " + this.player_name + "\nAge: " + this.age + "\nPosition: " + this.position + "\nStats: .Velocidade: " + this.player_stats[0]+ "; .Resistencia: " + this.player_stats[1]+
                "; .Destreza: " + this.player_stats[2] + "; .Impulsao: " + this.player_stats[3] + "; .Jogo de cabeca: "+ this.player_stats[4] + "; .Remate: " +this.player_stats[5] + 
                "; Capacidade de passe: " + this.player_stats[6] + ";\n" + "Overall: "+ this.overall);
                
}


public Goalkeeper extends Player {
    private int[] gk_stats;
}    
