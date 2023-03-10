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
    public int checkObject(Entity entity, boolean player)
    {
        int index = 999;
        for(int i = 0; i < gp.obj.length; i++)
        {
            if(gp.obj[i] != null)
            {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y; 
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction)
                {
                    case "up": entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if(gp.obj[i].collision == true)
                        {
                            entity.CollisionOn = true;
                        }
                        if(player == true)
                        {
                            index = i;
                        }
                    }
                    break; 
                    case "down": entity.solidArea.y += entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if(gp.obj[i].collision == true)
                        {
                            entity.CollisionOn = true;
                        }
                        if(player == true)
                        {
                            index = i;
                        }
                    }
                    break; 
                    case "left": entity.solidArea.x -= entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if(gp.obj[i].collision == true)
                        {
                            entity.CollisionOn = true;
                        }
                        if(player == true)
                        {
                            index = i;
                        }
                    }
                    break; 
                    case "right": entity.solidArea.x += entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if(gp.obj[i].collision == true)
                        {
                            entity.CollisionOn = true;
                        }
                        if(player == true)
                        {
                            index = i;
                        }
                    }
                    break; 
                }
            
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
            gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
