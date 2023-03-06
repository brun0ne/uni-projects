
public class Main {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel(100);

        Person x = hotel.addPerson(new Person("Jan", "Kowalski"));
        Person y = hotel.addPerson(new Person("Natalka", "uwu"));
        x.rent_room(hotel.get_room_by_number(0));

        y.rent_room(hotel.get_room_by_number(1));
        y.rent_room(hotel.get_room_by_number(4));

        //hotel.print_rooms();
        hotel.print_people();

        y.leave_all();

        y.rent_room(hotel.get_room_by_number(14));
        hotel.print_people();
    }
}