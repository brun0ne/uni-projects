public class Processor {
    private final String name;
    private final double clock_GHz;
    private final int number_of_cores;

    Processor(String name, double clock_GHz, int number_of_cores){
        this.name = name;
        this.clock_GHz = clock_GHz;
        this.number_of_cores = number_of_cores;
    }

    public String getName() {
        return name;
    }

    public double getClock_GHz() {
        return clock_GHz;
    }

    public int getNumber_of_cores() {
        return number_of_cores;
    }

    public String toString() {
        return String.format("%s, Clock: %.2f, Cores: %d", this.name, this.clock_GHz, this.number_of_cores);
    }

    public boolean equals(Processor processor){
        return (processor.name.equals(this.name) && processor.clock_GHz == this.clock_GHz && processor.number_of_cores == this.number_of_cores);
    }
}
