import static java.lang.Character.*;

public class StringCaseChanger implements StringTransformer {
    private StringDrink drink;

    public StringCaseChanger(StringDrink drink) {

        this.drink = drink;
    }

    @Override
    public void execute() {
        String str = "";
        for (int i = 0; i < drink.getText().length(); i++) {
            if (isUpperCase(drink.getText().charAt(i)))
                str += toLowerCase(drink.getText().charAt(i));
            else
                str += toUpperCase(drink.getText().charAt(i));
        }

        drink.setText(str);
    }
}
