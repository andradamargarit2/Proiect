package tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Exception.InvalidMapException;


public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNr[][];

    public TileManager(GamePanel gp){

        this.gp=gp;

        tile=new Tile[3];
        mapTileNr=new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/Map/map1.txt");


    }

    public void getTileImage(){
        int height=52;
        try {

            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/res/lvl1_spritesheet.png")).getSubimage(3*height,0,height,height);
            tile[0].collision=true;

            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/res/lvl2_spritesheet.png")).getSubimage(4*height,0,height,height/2);
            tile[1].collision=true;


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void loadMap(String s) {
        try {
            try {

                InputStream is = getClass().getResourceAsStream(s);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                int col = 0;
                int row = 0;

                while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                    String line = br.readLine();

                    while (col < gp.maxScreenCol) {

                        String numbers[] = line.split(" ");

                        int nr = Integer.parseInt(numbers[col]);
                        if (nr < -1 || nr > 0) {
                            throw new InvalidMapException("Nu exista tile cu acest indice");
                        }

                        mapTileNr[col][row] = nr;
                        col++;

                    }
                    if (col == gp.maxScreenCol) {
                        col = 0;
                        row++;
                    }

                }
                br.close();

            } catch (IOException e) {
            }

        }
        catch (InvalidMapException e){
            System.out.println(e);
        }
    }
    public void draw(Graphics2D g2){

        int col=0;
        int row=0;
        int x=0;
        int y=0;

        while(col<gp.maxScreenCol && row<gp.maxScreenRow) {

            int tileNr=mapTileNr[col][row];
            if(tileNr!=-1) {

                g2.drawImage(tile[tileNr].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            col++;
            x+= gp.tileSize;

            if(col==gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+= gp.tileSize;
            }


        }


    }

}

