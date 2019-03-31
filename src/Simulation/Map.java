package Simulation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Map {

    BufferedImage cacheImage;
    Simulation simulation;
    Tileset tileset;
    Camera camera;

    public Map(Simulation simulation, Camera camera) throws Exception
    {
        this.camera = camera;
        this.tileset = new Tileset();
        this.simulation = simulation;
        redrawCache();
    }

    public void redrawCache()
    {
        cacheImage = new BufferedImage(3840, 3840, BufferedImage.TYPE_INT_ARGB);
        Graphics2D imageGraphics = cacheImage.createGraphics();
        drawCache(imageGraphics);
    }


    public void draw(Graphics2D graphics)
    {
        AffineTransform affineTransform = new AffineTransform();
        graphics.setTransform(affineTransform);
        graphics.clearRect(0, 0, (int) simulation.getCanvas().getWidth(), (int) simulation.getCanvas().getHeight());
        graphics.setTransform(camera.getTransform((int) simulation.getCanvas().getWidth() / 2, (int) simulation.getCanvas().getHeight() / 2));
        graphics.drawImage(cacheImage, affineTransform, null);
        graphics.setTransform(camera.getTransform((int) simulation.getCanvas().getWidth(), (int) simulation.getCanvas().getHeight()));
    }

    public void drawCache(Graphics2D graphics)
    {
        int y = 0;
        int x = 0;
        int scaleFactor = 32;
        for (int layer = 0; layer < 4; layer++) {
            for (int tile = 0; tile < 10000; tile++) {
                long value = tileset.getValue(tile, layer);
                if (value != 0) {
                    if (value < 2715) {
                        AffineTransform tx = new AffineTransform();
                        tx.translate(x * scaleFactor, y * scaleFactor);
                        graphics.drawImage(tileset.getTile((int) value - 1), tx, null);
                    } else {
                        AffineTransform tx = new AffineTransform();
                        tx.translate(x * scaleFactor, y * scaleFactor);
                        graphics.drawImage(tileset.getTile((int) calculateRotatedValue(value) - 1), tx, null);
                    }

                }
                if ((tile != 0) && ((tile + 1) % 100 == 0) && tile != 9999) {
                    x = 0;
                    y++;
                } else if (tile == 9999) {
                    x = 0;
                    y = 0;

                } else {
                    x++;
                }
            }
        }

    }

    private long calculateRotatedValue(long value) {

        long FLIPPED_HORIZONTALLY_FLAG = 0x80000000;
        long FLIPPED_VERTICALLY_FLAG = 0x40000000;
        long FLIPPED_DIAGONALLY_FLAG = 0x20000000;
        long JOHANS_CONSTANTEXD = ~0xE0000000;


        return value & JOHANS_CONSTANTEXD;


    }
}
