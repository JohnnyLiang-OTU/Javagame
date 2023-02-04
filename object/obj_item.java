package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class obj_item extends superObject{
    public obj_item()
    {
        name = "Item";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/item.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
