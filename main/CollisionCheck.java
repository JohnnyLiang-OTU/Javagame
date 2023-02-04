package main;

import entity.Entity;

public class CollisionCheck {
    GamePanel gp;
    public CollisionCheck(GamePanel gp)
    {
        this.gp = gp;
    }

    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityUpRow = entityTopWorldY/gp.tileSize;
        int entityDownRow = entityBottomWorldY/gp.tileSize;

        int tile1, tile2;

        switch(entity.direction)
        {
            case "up":
                entityUpRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNumber[entityLeftCol][entityUpRow];
                tile2 = gp.tileM.mapTileNumber[entityRightCol][entityUpRow];
                if(gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true)
                {
                    entity.CollisionOn = true;
                }
                break;
            case "down":
                entityDownRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNumber[entityLeftCol][entityDownRow];
                tile2 = gp.tileM.mapTileNumber[entityRightCol][entityDownRow];
                if(gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true)
                {
                    entity.CollisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNumber[entityLeftCol][entityUpRow];
                tile2 = gp.tileM.mapTileNumber[entityLeftCol][entityDownRow];
                if(gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true)
                {
                    entity.CollisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNumber[entityRightCol][entityUpRow];
                tile2 = gp.tileM.mapTileNumber[entityRightCol][entityDownRow];
                if(gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true)
                {
                    entity.CollisionOn = true;
                }
                break;
        }
    }
}
