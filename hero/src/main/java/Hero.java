import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private int x;
    private int y;

    public Hero(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void moveUp(){
        y--;
    }

    public void moveLeft(){
        x--;
    }

    public void moveDown(){
        y++;
    }

    public void moveRight(){
        x++;
    }

    public void draw(Screen screen){
        screen.setCharacter(getX(), getY(), new TextCharacter('X'));
    }
}
