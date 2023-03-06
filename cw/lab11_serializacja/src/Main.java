public class Main {
    public static void main(String[] args) {
        Pies[] psy = new Pies[]{
          new Pies(11, "Burek"),
          new Pies(25, "Łatek"),
          new Pies(8, "Szczekacz")
        };

        savePsy(psy);
    }

    public static void loadPsy(Pies[] psy){
        for(int i = 0; i < psy.length; i++){
            psy[i] = psy[i].load(String.format("%d", i));
        }
        System.out.println("Odczytano psy");
    }

    public static void savePsy(Pies[] psy){
        for(int i = 0; i < psy.length; i++){
            psy[i].save(String.format("%d", i));
        }
        System.out.println("Zapisano psy");
    }
}