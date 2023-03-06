public abstract class Bryla {
    private final String name;
    private final int h;

    public Bryla(){
        this.name = "";
        this.h = 0;
    }

    public Bryla(String name, int height){
        this.name = name;
        this.h = height;
    }
    @Override
    public String toString(){
        return String.format("Bryła o nazwie: %s", this.name);
    }

    public String getName(){
        return this.name;
    }

    public int getHeight(){
        return this.h;
    }

    public abstract double volume();

    public abstract double area();
}
