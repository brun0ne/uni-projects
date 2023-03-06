public class Walec extends Bryla{
    private final int r;

    public Walec(){
        super("Bazowy", 1);

        this.r = 1;
    }

    public Walec(String name, int h, int r){
        super(name, h);

        this.r = r;
    }

    @Override
    public String toString(){
        return String.format("Walec: %s [r=%d,h=%d]", this.getName(), this.r, this.getHeight());
    }

    @Override
    public double volume() {
        return (Math.PI * this.r * this.r) * this.getHeight();
    }
    @Override
    public double area() {
        return 2 * (Math.PI * this.r * this.r) + 2 * (Math.PI * this.r * this.getHeight());
    }

    public boolean isRotatedSqr(){ // obrót kwadratu?
        return (this.r == this.getHeight());
    }
}
