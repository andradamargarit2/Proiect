package Main;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Evolution Hunt");

        GamePanel gamePanel = GamePanel.getInstance();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.init();
        gamePanel.setupGame();
        gamePanel.startGameThread();


    }
}

