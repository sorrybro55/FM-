import java.io.Serializable;

/**
 * Enumeration class Position - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Position implements Serializable
{
    GOALKEEPER,
    DEFENDER,
    MIDFIELDER,
    STRIKER,
    WINGER,
    ND;
    
    
   public String toString(){
       switch(this){
           case GOALKEEPER: return "Guarda-Redes";
           case DEFENDER: return "Defesa";
           case MIDFIELDER: return "Medio";
           case STRIKER: return "Avançaado";
           case WINGER: return "Lateral";
           default: return "Indefinido";
        }
    }

    
}


