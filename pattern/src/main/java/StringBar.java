import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {
    private boolean happyHour;
    private StringRecipe rec;

    public StringBar() {
        happyHour = false;
    }

    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    @Override
    public void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void order(StringRecipe recipe) {
        recipe.mix();
    }
}
