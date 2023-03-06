package Observable;

import Observers.Observer;

import java.util.ArrayList;
import java.util.Random;

public class InputReader implements Observable {

    private String text;
    private final ArrayList<Observer> observers = new ArrayList<>();

    public InputReader(){
        this.text = "";
    }

    public void changeText(String text){
        this.text = text;
        this.notifyObservers();
    }

    public void randomText(){
        Random random = new Random();

        this.text = random.ints((int) 'a', (int) 'z' + 1)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        this.notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers){
            observer.update(this.text);
        }
    }
}
