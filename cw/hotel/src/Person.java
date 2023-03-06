import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    private final String name;
    private final String surname;
    private final ArrayList<Room> rooms;


    Person(String name, String surname){
        this.name = name;
        this.surname = surname;

        this.rooms = new ArrayList<Room>();
    }

    public boolean rent_room(Room room){
        if (!room.isFree())
            return false;

        this.rooms.add(room);

        return true;
    }

    public int leave_all(){
        int num = this.rooms.size();

        this.rooms.clear();

        return num;
    }

    public void print_info(){
        System.out.printf("%s %s has: ", this.name, this.surname);

        for(Room room : this.rooms){
            System.out.printf("%d ", room.getNumber());
        }

        System.out.printf("%n");
    }
}
