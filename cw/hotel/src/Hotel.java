import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hotel {
    private final Room[] rooms;
    private final ArrayList<Person> people;

    Hotel(int number_of_rooms){
        this.rooms = new Room[number_of_rooms];

        for (int i = 0; i < this.rooms.length; i++){
            this.rooms[i] = new Room();
        }

        this.people = new ArrayList<Person>();
    }

    public void print_rooms(){
        for (Room room : this.rooms){
            System.out.println(room.getNumber());
        }
    }

    public Room get_room_by_number(int number) throws Exception {
        for (Room room : this.rooms) {
            if (room.getNumber() == number)
                return room;
        }

        throw new Exception();
    }

    public Person addPerson(Person person){
        this.people.add(person);
        return person;
    }

    public void print_people() {
        for (Person person : this.people){
            person.print_info();
        }
    }
}
