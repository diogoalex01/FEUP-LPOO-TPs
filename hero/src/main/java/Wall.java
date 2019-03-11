import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    public Wall(int x, int y) {

        super(x,y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF10"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "$");
    }

    public Position getPosition() {

        Position p = new Position(super.getPosition().getX(), super.getPosition().getY());

        return p;
    }
}
