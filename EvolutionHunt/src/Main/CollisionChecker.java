package Main;

import entity.Entity;
import entity.Player;
import entity.Zombie;

public class CollisionChecker {

    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp=gp;
    }

    public void checkTile(Entity entity){

        int entityLeftX=entity.solidArea.x+ entity.x;
        int entityTopY=entity.solidArea.y+entity.y;
        int entityRightX=entity.solidArea.x+entity.solidArea.width+entity.x;
        int entityBottomY=entity.solidArea.y+entity.solidArea.height+entity.y;

        int entityLeftCol=entityLeftX/gp.tileSize;
        int entityRightCol=entityRightX/gp.tileSize;
        int entityTopRow=entityTopY/gp.tileSize;
        int entityBottomRow=entityBottomY/gp.tileSize;

       int tileNr1,tileNr2;

        switch (entity.direction){
            case "up":
                entityTopRow=(entityTopY-entity.speed)/gp.tileSize;
                tileNr1=gp.tileM.mapTileNr[entityLeftCol][entityTopRow];
                tileNr2=gp.tileM.mapTileNr[entityRightCol][entityTopRow];
                if(tileNr2>=0){
                    tileNr1=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }
                }
                else if(tileNr1>=0){
                    tileNr2=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }
                }
                break;

            case "gravity":
                entityBottomRow=(entityBottomY+entity.speed)/gp.tileSize;
                tileNr1=gp.tileM.mapTileNr[entityLeftCol][entityBottomRow];
                tileNr2=gp.tileM.mapTileNr[entityRightCol][entityBottomRow];
                if(tileNr2>=0){
                    tileNr1=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }

                }
                else if(tileNr1>=0){
                    tileNr2=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }


                }

                break;

            case "left":
                entityLeftCol=(entityLeftX-entity.speed)/gp.tileSize;
                tileNr1=gp.tileM.mapTileNr[entityLeftCol][entityTopRow];
                tileNr2=gp.tileM.mapTileNr[entityLeftCol][entityBottomRow];

                if(tileNr2>=0){
                    tileNr1=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }

                }
               else if(tileNr1>=0){
                    tileNr2=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }
                }
                break;

            case "right":
                entityRightCol=(entityRightX+entity.speed)/gp.tileSize;
                tileNr1=gp.tileM.mapTileNr[entityRightCol][entityTopRow];
                tileNr2=gp.tileM.mapTileNr[entityRightCol][entityBottomRow];

                if(tileNr2>=0){
                    tileNr1=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }
                }
                else if(tileNr1>=0){
                    tileNr2=0;
                    if(gp.tileM.tile[tileNr1].collision==true || gp.tileM.tile[tileNr2].collision==true){

                        entity.collisionOn= true;
                    }
                }
                break;


        }

    }

    public int checkObject(Entity entity,boolean player){

        int index= 99;
        for (int i=0;i<gp.obj.length;i++){
            if(gp.obj[i]!=null){

                entity.solidArea.x=entity.solidArea.x+ entity.x;
                entity.solidArea.y=entity.y+entity.solidArea.y;

                gp.obj[i].solidArea.x=gp.obj[i].wordX+gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y=gp.obj[i].wordY+gp.obj[i].solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.y-=entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                           if(gp.obj[i].collision==true){
                               entity.collisionOn=true;
                           }
                           if(player==true){
                               index=i;
                           }

                        }
                        break;
                   case "gravity":
                        entity.solidArea.y+=entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision==true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x+=entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision==true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x-=entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision==true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }
                        break;
                    case "ability":
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision==true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }
                        break;
                }
                entity.solidArea.x=entity.solidAreaDefaultX;
                entity.solidArea.y=entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x=gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y=gp.obj[i].solidAreaDefaultY;

            }
        }

        return index;
    }

    public void checkZombie(Player entity) {
        if (entity.solidArea.intersects(gp.zombie.solidArea)) {
            if(GamePanel.deathZombie==false)
                    gp.player.setDefaulValues();
        }

    }

}

