import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element {

    public Hero(Position position){
        super(position.getX(), position.getY());
    }

    public void setPosition(Position position) {
        super.setPosition(position);
    }

    public Position getPosition() {
        return super.getPosition();
    }

    public Position moveUp() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
    }

    public Position moveLeft() {
        return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
    }

    public Position moveDown() {
        return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF10"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");
    }
}
