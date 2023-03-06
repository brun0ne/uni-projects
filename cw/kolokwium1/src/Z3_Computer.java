public class Z3_Computer {
    private String company_name;
    private String brand;
    private int RAM;
    private Processor processor;

    Z3_Computer(String company_name, String brand, int RAM, Processor processor){
        this.company_name = company_name;
        this.brand = brand;
        this.RAM = RAM;
        this.processor = processor;
    }

    public String toString() {
        return String.format("Computer | Company: %s, Brand: %s, RAM: %d, Processor: (%s)", this.company_name, this.brand, this.RAM, this.processor.toString());
    }

    // getters
    public String getCompany_name() {
        return this.company_name;
    }
    public String getBrand() {
        return this.brand;
    }
    public Processor getProcessor() {
        return this.processor;
    }

    public int getRAM() {
        return this.RAM;
    }
    //////////////////////////////////////////////////////////

    public static Z3_Computer[] addComputer(Z3_Computer[] array, Z3_Computer new_computer){
        Z3_Computer[] new_array = new Z3_Computer[array.length+1];

        for(int i = 0; i < array.length; i++){ // copy
            new_array[i] = array[i];
        }

        new_array[new_array.length-1] = new_computer;
        return new_array;
    }

    public static void printComputers(Z3_Computer[] array){
        for(Z3_Computer computer : array){
            System.out.println(computer.toString());
        }
    }

    public static Z3_Computer[] getComputersByCompanyName(Z3_Computer[] array, String company_name){
        Z3_Computer[] res_array = new Z3_Computer[0];

        for(Z3_Computer computer : array){
            if (computer.getCompany_name().equals(company_name)){
                Z3_Computer[] temp_array = new Z3_Computer[res_array.length+1];
                for(int i = 0; i < res_array.length; i++){ // copy
                    temp_array[i] = res_array[i];
                }
                temp_array[temp_array.length-1] = computer;
                res_array = temp_array;
            }
        }

        return res_array;
    }

    public static Z3_Computer[] getComputersByBrandAndNotSlowerThan(Z3_Computer[] array, String brand, double minimal_clock_speed){
        Z3_Computer[] res_array = new Z3_Computer[0];

        for(Z3_Computer computer : array){
            if (computer.getBrand().equals(brand) && computer.getProcessor().getClock_GHz() >= minimal_clock_speed){
                Z3_Computer[] temp_array = new Z3_Computer[res_array.length+1];
                for(int i = 0; i < res_array.length; i++){ // copy
                    temp_array[i] = res_array[i];
                }
                temp_array[temp_array.length-1] = computer;
                res_array = temp_array;
            }
        }

        return res_array;
    }

    public static void main(){
        Z3_Computer[] computers = new Z3_Computer[0];

        computers = addComputer(computers,  new Z3_Computer("HP", "a3", 10, new Processor("Intel", 3, 4)));
        computers = addComputer(computers,  new Z3_Computer("Lenovo", "something", 5, new Processor("AMD", 2, 8)));
        computers = addComputer(computers,  new Z3_Computer("Lenovo", "something", 8, new Processor("AMD", 1.5, 8)));

        printComputers(computers);
        System.out.println("Print computers with company name 'HP':");
        printComputers(getComputersByCompanyName(computers, "HP"));
        System.out.println("Print computers with brand 'something' and with clocks not slower than 2GHz:");
        printComputers(getComputersByBrandAndNotSlowerThan(computers, "something", 2));
        System.out.println("Print computers with brand 'something' and with clocks not slower than 1GHz:");
        printComputers(getComputersByBrandAndNotSlowerThan(computers, "something", 1));
    }
}
