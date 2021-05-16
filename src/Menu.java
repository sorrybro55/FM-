import java.util.*;

public class Menu {

    private List<String> options;
    private int option;
    private String title;

    public Menu(String [] options){
        this.options = Arrays.asList(options);
        this.option = 0;
        this.title = "*** Menu ***";
    }

    public Menu(List<String> options){
        this.options = new ArrayList<>(options);
        this.option = 0;
        this.title = "*** Menu ***";
    }

    public Menu(String [] options, String title){
        this.options = Arrays.asList(options);
        this.option = 0;
        this.title = title;
    }

    public Menu(List<String> options, String title){
        this.options = new ArrayList<>(options);
        this.option = 0;
        this.title = title;
    }



    private void showMenu(){
        System.out.println("\n" + this.title);
        for(int i = 0;i <options.size(); i++){
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(this.options.get(i));
        }
        System.out.println("0. Sair");
    }
    private int readOption(){
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Opçcão: ");
        try{
            op = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Opçao Invalida!!!");
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
