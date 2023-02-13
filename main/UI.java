package main;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import object.obj_item;

public class UI{
    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageTimer = 0;

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        obj_item key = new obj_item();
        keyImage = key.image;
    }

    public void showMessage(String text)
    {
        messageOn = true;
        message = text;
    }

    public void draw(Graphics2D g2)
    {
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.hasKey, 74, 55);
        
        // MESSAGE
        if(messageOn == true)
        {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

            messageTimer++;
            if(messageTimer > 120)
            {
                messageTimer = 0;
                messageOn = false;
            }
        }
    }
}
