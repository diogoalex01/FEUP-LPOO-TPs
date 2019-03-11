import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.Random;

public class Monster extends Element {


    public Monster(int x, int y) {
        super(x,y);
    }


    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF3310"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "Z");
    }

    public void setMonsterPosition(Position position)
    {
        super.setPosition(move());
    }

    public Position move()
    {
        int random = (int) (Math.random() *(3+1) +1);

        switch(random)
        {
            case 1:
            {
                return new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
            }
            case 2:
            {
                return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
            }
            case 3:
            {
                return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
            }
            case 4:
            {
                return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
            }
        }
        return new Position(0,0);
    }
}

