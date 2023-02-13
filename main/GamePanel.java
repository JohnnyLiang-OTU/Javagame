package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Player;
import object.superObject;
import tile.TileManager;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    // Screen Settings
    final int originalTileSize = 16; // 16x16 sprites
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 16 * 3 = 48 x 48 sprites
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 (48 * 16)
    public final int screenHeight = tileSize * maxScreenRow; // 576 (48 * 12)

    // WORLD PARAMETERS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // FPS
    int FPS = 60;

    // SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionCheck Checker = new CollisionCheck(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public superObject obj[] = new superObject[10];
    public UI ui = new UI(this);


    // Set player's default position

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame()
    {
        aSetter.setObject();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() 
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        player.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Tile
        tileM.draw(g2);
        //Object
        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {
                obj[i].draw(g2, this);
            }
        }
        //Player
        player.draw(g2);
        ui.draw(g2);
        g2.dispose();
    }
}
