import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;
    private int height;
    private List<Wall> walls;
    private  List<Coin> coins;
    private  List<Monster> monsters;


    Position position = new Position(10, 10);
    Hero hero = new Hero(position);

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins= createCoins();
        this.monsters = createMonsters();

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private boolean heroEntersWall(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position))
                return true;
        }

        return false;
    }

    private boolean MonsterEntersWall(Position position) {
        for (Wall wall : walls) {
            for(Monster monster : monsters) {

                if (wall.getPosition().equals(monster.getPosition()))
                    return true;
            }
        }

        return false;
    }

    private void retrieveCoins()
    {
        for (Coin coin : coins) {
            if (coin.getX() == hero.getPosition().getX() && coin.getY() == hero.getPosition().getY())
                coins.remove(this);
        }
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() < width && position.getX() >= 0 &&
                position.getY() < height && position.getY() >= 0 &&
                !heroEntersWall(position)) {
            return true;
        }

        return false;
    }

    private boolean canMonsterMove(Position position) {
        if (position.getX() < width && position.getX() >= 0 &&
                position.getY() < height && position.getY() >= 0 &&
                !MonsterEntersWall(position)) {
            return true;
        }

        return false;
    }


    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void moveMonster(Position position) {
        if (canMonsterMove(position))
        {
            for( Monster monster : monsters)
            {
                monster.setMonsterPosition(position);
            }
        }

    }

    public void processKey(KeyStroke key) {

        for( Monster monster : monsters)
        moveMonster(monster.move());

        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }

    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#AA1111"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls)
            wall.draw(graphics);

        for(Coin coin: coins){
                retrieveCoins();
                coin.draw(graphics);
            }

        for (Monster monster : monsters)
            monster.draw(graphics);

        hero.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }


    private List<Coin> createCoins() {

        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            if((random.nextInt((height - 2) + 1) != hero.getPosition().getY() && (random.nextInt(width - 2) + 1) != hero.getPosition().getX()))
                coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters()
    {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for(int i = 0; i<2;i++)
        {
            monsters.add(new Monster(random.nextInt(width -2) + 1, random.nextInt(height-2) +1));
        }

        return monsters;
    }
}
