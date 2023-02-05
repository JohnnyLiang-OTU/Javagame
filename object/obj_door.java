package object;
import java.io.IOException;
import javax.imageio.ImageIO;

public class obj_door extends superObject{
    public obj_door()
    {
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/item2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
