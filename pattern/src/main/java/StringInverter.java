public class StringInverter implements StringTransformer {
    private StringDrink drink;

    public StringInverter(StringDrink drink) {
        this.drink = drink;
    }

    @Override
    public void execute() {
        /*String s = "";
        for (int i = drink.getText().length() - 1; i >= 0 ; i--) {
            s += drink.getText().charAt(i);
        }
        drink.setText(s);*/

        StringBuffer s = new StringBuffer(drink.getText());
        s.reverse();
        drink.setText(s.toString());
    }
}
