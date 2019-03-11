import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{

    public Coin(int x, int y) {
        super(x,y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFF110"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "@");
    }

    public int getX()
    {
        return super.getPosition().getX();
    }

    public int getY()
    {
        return super.getPosition().getY();
    }
}
