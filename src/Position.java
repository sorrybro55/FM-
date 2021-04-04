
/**
 * Enumeration class Position - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Position
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
           case STRIKER: return "Avancado";
           case WINGER: return "Lateral";
           default: return "Indefenido";
        }
    }

    public String simple(){
        switch(this){
            case GOALKEEPER: return "GR";
            case DEFENDER: return "DF";
            case MIDFIELDER: return "MD";
            case STRIKER: return "AV";
            case WINGER: return "LT";
            default: return "ND";
        }
    }
    
}


