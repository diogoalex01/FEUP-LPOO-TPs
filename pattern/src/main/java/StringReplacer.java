public class StringReplacer implements StringTransformer {
    private StringDrink drink;
    private char c1;
    private char c2;

    public StringReplacer(StringDrink drink, char c1, char c2) {
        this.drink = drink;
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void execute() {
        String str = drink.getText().replace(c1, c2);
        drink.setText(str);
    }
}
