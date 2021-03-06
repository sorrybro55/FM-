import java.util.*;

public class Menu {

    private List<String> options;
    private int option;
    private String title;
    private String exitOption;

    public Menu(String [] options){
        this.options = Arrays.asList(options);
        this.option = 0;
        this.title = "*** Menu ***";
        this.exitOption = "Sair";
    }

    public Menu(List<String> options){
        this.options = new ArrayList<>(options);
        this.option = 0;
        this.title = "*** Menu ***";
        this.exitOption = "Sair";
    }

    public Menu(String [] options, String title){
        this.options = Arrays.asList(options);
        this.option = 0;
        this.title = title;
        this.exitOption = "Sair";
    }

    public Menu(List<String> options, String title){
        this.options = new ArrayList<>(options);
        this.option = 0;
        this.title = title;
        this.exitOption= "Sair";
    }

    public Menu(String[] options, String out, String title ){
        this.options = Arrays.asList(options);
        this.option = 0;
        this.title = title;
        this.exitOption = out;

    }



    private void showMenu(){
        System.out.println(this.title);
        for(int i = 0;i <options.size(); i++){
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(this.options.get(i));
        }
        System.out.print("0. ");
        System.out.println(exitOption);
    }
    private int readOption(){
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Opçcão: ");
        try{
            op = sc.nextInt();
        }catch (InputMismatchException e){
            op = -1;
        }
        if(op<0 || op>this.options.size()){
            System.out.println("Opçao Invalida!!!");
            op = -1;
        }
        return op;
    }

    public void run(){
        do{
            this.showMenu();
            this.option = this.readOption();
        }while (this.option == -1);
    }

    public int getOption(){
        return this.option;
    }

}
