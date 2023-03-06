import java.util.ArrayList;
import java.util.Objects;

public class CD {
    private final int ID;
    private ArrayList<Utwor> utwory = new ArrayList<>();

    static int INC_ID = 0;

    CD(){
        this.ID = INC_ID;
        INC_ID++;
    }

    CD(ArrayList<Utwor> utwory){
        this();
        this.utwory = utwory;
    }

    public int getID() {
        return this.ID;
    }

    public ArrayList<Utwor> getUtwory() {
        return this.utwory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        CD cd = (CD) obj;
        return this.ID == cd.ID && Objects.equals(this.utwory, cd.utwory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ID, this.utwory);
    }
}
