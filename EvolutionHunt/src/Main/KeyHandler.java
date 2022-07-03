package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, leftPressed, rightPressed, abilityPressed;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code= e.getKeyCode();

        if(code==KeyEvent.VK_A) {
            leftPressed= true;
        }
        if(code==KeyEvent.VK_D) {
            rightPressed= true;
        }
        if(code==KeyEvent.VK_W) {
            upPressed= true;
        }
        if(code==KeyEvent.VK_E) {
            abilityPressed= true;
        }
        if(code==KeyEvent.VK_ESCAPE) {
            GamePanel.pause=true;
            GamePanel.playing=false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code= e.getKeyCode();

        if(code==KeyEvent.VK_A) {
            leftPressed= false;
        }
        if(code==KeyEvent.VK_D) {
            rightPressed= false;
        }
        if(code==KeyEvent.VK_W) {
            upPressed= false;
        }
        if(code==KeyEvent.VK_E) {
            abilityPressed= false;
        }

    }
}
