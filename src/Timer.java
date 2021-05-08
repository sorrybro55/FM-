
public class Timer {

    private double beginning;
    private double counter;

    public Timer(){
        this.beginning = 0;
        this.counter = 0;
    }

    public Timer(double beginning, double counter){
        this.beginning = beginning;
        this.counter = counter;

    }

    public Timer(Timer timer){
        this.beginning = timer.getBeginning();
        this.counter = timer.getCounter();

    }

    public double getBeginning(){
        return this.beginning;
    }

    public void setBeginning(double beginning){
        this.beginning = beginning;
    }

    public double getCounter(){
        return this.counter;
    }

    public void setCounter(double counter){
        this.counter = counter;
    }

    public Timer clone(){
        return new Timer(this);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if(o==null || this.getClass() != o.getClass())
            return false;
        Timer timer = (Timer) o;
        return this.beginning == timer.getBeginning() && this.counter == timer.getCounter();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Inicio: ").append(this.beginning).append(" Contador: ").append(this.counter);
        return sb.toString();
    }




    public void start(){
            this.beginning += System.currentTimeMillis();
    }

    public void stop(){
            this.counter += beginning - System.currentTimeMillis();
    }

    public void reset(){
        this.beginning = 0;
        this.counter = 0;
    }

    public double elapsedTimeTime(){
        return System.currentTimeMillis() + this.counter - this.beginning;
    }




}
