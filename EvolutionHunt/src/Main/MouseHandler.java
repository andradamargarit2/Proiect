package Main;

import Menu.Button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    public int x,y;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(GamePanel.instructions){

            Button button=GamePanel.launcherInstructions.button;
            if(x>=button.getX() && y>=button.getY() && x<=(button.getX()+button.getWidth()) && y<=(button.getY()+button.getHeight())){
                button.triggerEvent();
            }
        }

        else if(GamePanel.pause)
        for (int i = 0; i < GamePanel.launcherPause.buttons.length; i++) {
            Button button=GamePanel.launcherPause.buttons[i];
            if(x>=button.getX() && y>=button.getY() && x<=(button.getX()+button.getWidth()) && y<=(button.getY()+button.getHeight())){
                button.triggerEvent();
            }
        }
        else if(GamePanel.gameFinished)
            for (int i = 0; i < GamePanel.launcherEnd.buttons.length; i++) {
                Button button=GamePanel.launcherEnd.buttons[i];
                if(x>=button.getX() && y>=button.getY() && x<=(button.getX()+button.getWidth()) && y<=(button.getY()+button.getHeight())){
                    button.triggerEvent();
                }
            }
        else  if(!GamePanel.pause){

            for (int i = 0; i < GamePanel.launcher.buttons.length; i++) {
                Button button=GamePanel.launcher.buttons[i];
                if(x>=button.getX() && y>=button.getY() && x<=(button.getX()+button.getWidth()) && y<=(button.getY()+button.getHeight())){
                    button.triggerEvent();
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x=e.getX();
        y=e.getY();

    }
}
