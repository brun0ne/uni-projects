public class Prostakat {
    public int a;
    public int b;

    public Prostakat(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int pole(){
        return this.a*this.b;
    }

    public int obwod(){
        return this.a*2 + this.b*2;
    }

    public double przekatna(){
        return Math.sqrt(this.a*this.a + this.b*this.b);
    }
}
