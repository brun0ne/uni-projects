public class Zegar {
    private int time;

    Zegar(){
        this.time = 0; // midnight
    }

    Zegar(int hh, int mm, int ss){
        this.time = this.to_seconds(hh, mm, ss);
    }

    private int to_seconds(int hh, int mm, int ss){
        return (ss + mm*60 + hh*60*60) % (24*60*60);
    }

    public void przesun(int hh, int mm, int ss){
        this.time += this.to_seconds(hh, mm, ss);
    }

    public void wypisz(){
        System.out.printf("Czas w sekundach od północy: %d%n", this.time);
        System.out.printf("Czas w formacie (hh:mm:ss): %02d:%02d:%02d%n", (this.time / (60*60)), (this.time % (60*60)) / 60, (this.time % 60));
    }
}
