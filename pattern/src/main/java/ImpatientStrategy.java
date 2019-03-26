public class ImpatientStrategy implements OrderingStrategy  {
    private StringRecipe recipe;
    private StringBar bar;
    private boolean happyHour;

    public ImpatientStrategy() {
        this.happyHour = false;
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        bar.order(recipe);
        this.recipe = recipe;
        this.bar = bar;
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        if (bar.isHappyHour())
            this.happyHour = true;
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        if (!bar.isHappyHour())
            this.happyHour = false;
    }
}
