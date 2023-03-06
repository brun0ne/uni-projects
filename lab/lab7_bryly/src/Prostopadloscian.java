public class Prostopadloscian extends Bryla{
    private final int a;
    private final int b;

    public Prostopadloscian(){
        super("Bazowy", 1);

        this.a = 1;
        this.b = 1;
    }

    public Prostopadloscian(String name, int a, int b, int h){
        super(name, h);

        this.a = a;
        this.b = b;
    }

    @Override
    public double volume(){ // objętość
        return this.a * this.b * this.getHeight();
    }

    @Override
    public double area(){ // pole
        return (2 * this.a * this.b) + (2 * this.a * this.getHeight()) + (2 * this.b * this.getHeight());
    }

    @Override
    public String toString(){
        return String.format("Prostopadłościan: %s [a=%d,b=%d,h=%d]", this.getName(), this.a, this.b, this.getHeight());
    }

    public boolean isCube(){ // jest sześcianem?
        return ( this.a == this.b && this.b == this.getHeight() );
    }
}
