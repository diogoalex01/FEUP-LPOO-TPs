public class HumanClient implements Client {
    private boolean happyHour;
    private StringRecipe recipe;
    private StringBar bar;
    private OrderingStrategy strategy;

    public HumanClient() {
        this.happyHour = false;
    }

    public HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        this.recipe = recipe;
        this.bar = bar;
    }

    @Override
    public void happyHourStarted(Bar bar) {
        if (bar.isHappyHour())
            this.happyHour = true;
    }

    @Override
    public void happyHourEnded(Bar bar) {
        if (!bar.isHappyHour())
            this.happyHour = false;
    }
}
