import java.util.ArrayList;
import java.util.List;

public abstract class Bar {

    private List<BarObserver> observers = new ArrayList<>();

    public abstract boolean isHappyHour();
    public abstract void startHappyHour();
    public abstract void endHappyHour();

    void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
