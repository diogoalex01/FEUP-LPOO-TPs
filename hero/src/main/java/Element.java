import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    private Position position = new Position(0,0);

    public Element(int x, int y){

        position.setX(x);
        position.setY(y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void draw(TextGraphics graphics);
}
