public class Kwadrat {
    public int a;

    public Kwadrat(int a){
        this.a = a;
    }

    public int pole(){
        return this.a*this.a;
    }

    public int obwod(){
        return this.a * 4;
    }

    public double przekatna(){
        return this.a * Math.sqrt(2);
    }
}
