public class AreaStringOutputter {

    private SumProvider sum;

    public AreaStringOutputter(SumProvider sum) {
        this.sum = sum;
    }

    public String output() {
        return "Sum of areas: " + sum.sum();
    }
}
