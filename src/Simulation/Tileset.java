package Simulation;

import javafx.scene.image.Image;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.WritableRenderedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Math.toIntExact;

@SuppressWarnings("deprecation")
public class Tileset {


    private BufferedImage[] tiles;
    private org.json.simple.parser.JSONParser jsonParser;
    private FileReader fileReader;
    private ArrayList<Object[]> layers;
    private File jsonFile;

    public Tileset() throws IOException, ParseException {

        this.jsonParser = new JSONParser();

        try {
            this.tiles = new BufferedImage[2715];
            this.jsonFile = new File("Resources/JSON/SchoolPlanner_withAllLayersVersion3.json");
            this.fileReader = new FileReader(jsonFile);
            BufferedImage rpgTiles = ImageIO.read(new File("Resources/Sprites/Map/RPG stuff.png"));
            BufferedImage furnitureTiles = ImageIO.read(new File("Resources/Sprites/Map/Furniture_Japanese Styled.png"));
            BufferedImage groundTiles = ImageIO.read(new File("Resources/Sprites/Map/ground_tiles.png"));
            int j = 0;
            for (int i = 0; i < 2710; i++) {

                if (i < 2016) {
                    this.tiles[i] = rpgTiles.getSubimage(32 * (j % 32), 32 * (j / 32), 32, 32);
                    j++;
                    if (i == 2015) {
                        j = 0;
                    }

                } else if (i < 2272) {
                    this.tiles[i] = furnitureTiles.getSubimage(32 * (j % 16), 32 * (j / 16), 32, 32);
                    j++;
                    if (i == 2271) {
                        j = 0;
                    }
                } else {
                    this.tiles[i] = groundTiles.getSubimage(32 * (j % 21), 32 * (j / 21), 32, 32);
                    j++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.layers = getJsonValues();
    }

    public BufferedImage getTile(int i) {
        return this.tiles[i];
    }

    public ArrayList<Object[]> getJsonValues() throws IOException, ParseException {
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
        JSONArray layers = (JSONArray) jsonObject.get("layers");
        Iterator i = layers.iterator();
        ArrayList<Object[]> dataValues = new ArrayList<>();
        while (i.hasNext()) {

            JSONObject layer = (JSONObject) i.next();
            JSONArray data = (JSONArray) layer.get("data");
            Object[] dataLong = data.toArray();
            dataValues.add(dataLong);
        }
        return dataValues;
    }

    public long getValue(int tileValue, int layer) {
        return (long) this.layers.get(layer)[tileValue];
    }

    public ArrayList<Integer> getLayerData (int firstLayer, int secondLayer) {

        ArrayList<Integer> layerDataList = new ArrayList<>();

        for (int layer = firstLayer; layer < secondLayer; layer++) {
            for (int tile = 0; tile < 10000; tile++) {
                long value = getValue(tile, layer);
                layerDataList.add((int)value);
            }
        }
        return layerDataList;
    }

}
