package main;

import object.obj_item;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }
    public void setObject()
    {
        gp.obj[0] = new obj_item();
        gp.obj[0].worldX = 26 * gp.tileSize;
        gp.obj[0].worldY = 31 * gp.tileSize;
    }
}
