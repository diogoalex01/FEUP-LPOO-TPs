import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {

    private int x;
    private int y;

    public Wall(int width, int height) {
        this.x = width;
        this.y = height;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF10"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(x, y), "$");
    }
}
