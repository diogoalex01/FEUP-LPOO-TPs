import java.util.ArrayList;
import java.util.List;

public class StringRecipe {
    private List<StringTransformer> strs = new ArrayList<>();

    public StringRecipe(List<StringTransformer> strs) {
        this.strs = strs;
    }

    public List<StringTransformer> getStrs() {
        return strs;
    }

    public void setStrs(List<StringTransformer> strs) {
        this.strs = strs;
    }

    public void mix() {

        for(StringTransformer str : strs) {
            str.execute();
        }
    }
}
