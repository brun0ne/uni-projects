import java.util.Random;

public class Konto {
    private int nr_konta;
    private double saldo;
    static Random rand = new Random();

    Konto(){
        this.nr_konta = rand.nextInt(0, 101);
        this.saldo = 0;
    }

    Konto(double saldo){
        this();
        this.saldo = saldo;
    }

    Konto(double saldo, int nr_konta){
        this(saldo);
        this.nr_konta = nr_konta;
    }

    // getters & setters
    public double getSaldo() {
        return this.saldo;
    }
    public int getNr_konta() {
        return this.nr_konta;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setNr_konta(int nr_konta) {
        this.nr_konta = nr_konta;
    }

    // getStan
    public String getStan(){
        return String.format("Konto: {nr_konta: %3d, saldo: %.2f}", this.nr_konta, this.saldo);
    }
}
