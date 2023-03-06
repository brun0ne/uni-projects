public class Ksiazka {
    private final int signature;
    private final double punishment;
    private final boolean returned_in_time;

    Ksiazka(){
        this.signature = 0;
        this.punishment = 0;
        this.returned_in_time = true;
    }

    Ksiazka(int signature, double punishment, boolean returned){
        this.signature = signature;
        this.returned_in_time = returned;

        if(returned)
            this.punishment = 0;
        else
            this.punishment = punishment;
    }

    @Override
    public String toString(){
        return String.format("Sygnatura: %d | Kara: %.2f | Zwrócona: %b", this.signature, this.punishment, this.returned_in_time);
    }

    public int getSignature() {
        return this.signature;
    }

    public double getPunishment() {
        return this.punishment;
    }
}
