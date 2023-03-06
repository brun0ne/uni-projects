import java.util.ArrayList;

public class Room {
    private static int inc_number = 0;
    private final int number;
    private final boolean free;

    Room(){
        this.number = inc_number;
        inc_number += 1;

        this.free = true;
    }

    public int getNumber(){
        return this.number;
    }

    public boolean isFree(){
        return this.free;
    }
}
