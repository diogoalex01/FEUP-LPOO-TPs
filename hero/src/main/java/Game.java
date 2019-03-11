import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    Arena arena = new Arena(40,20);


    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    private void draw() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run () throws IOException {

        KeyStroke key;

        do {
            draw();
            key = screen.readInput();

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }

            if (key.getKeyType() == KeyType.EOF){
                break;
            }

            processKey(key);

        } while (true);
    }

    private void processKey(KeyStroke key) {
        //System.out.println(key);
        arena.processKey(key);
    }
}
