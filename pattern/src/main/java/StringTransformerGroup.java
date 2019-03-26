import java.util.ArrayList;
import java.util.List;

public class StringTransformerGroup implements StringTransformer {

    private List<StringTransformer> strs = new ArrayList<>();

    public StringTransformerGroup(List<StringTransformer> strs) {
        this.strs = strs;
    }

    @Override
    public void execute() {
        StringRecipe recipe = new StringRecipe(strs);
        recipe.mix();
    }
}
