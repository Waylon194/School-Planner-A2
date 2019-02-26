package Simulation;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.toIntExact;

@SuppressWarnings("deprecation")
public class Tileset {

    private BufferedImage tilesImage;
    private BufferedImage[] tiles;
    private File tilesFile;
    private org.json.simple.parser.JSONParser jsonParser;
    private File jsonFile;
    private FileReader fileReader;
    private ArrayList<Object[]> layers;

    public Tileset() throws FileNotFoundException, ParseException{

        this.jsonParser = new JSONParser();
        try{
            this.jsonFile = new File("sources/fourLayers.json");
            this.tilesFile = new File("sources/sprites/RPG stuff.png");
            this.fileReader = new FileReader(jsonFile);
            this.tilesImage = ImageIO.read(tilesFile);
            this.tiles = new BufferedImage[2016];
            this.layers = getJsonValues();

            for(int i = 0; i < 2016; i++) {
                this.tiles[i] = tilesImage.getSubimage(32 * (i % 32), 32 * (i / 32), 32, 32);

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


    public BufferedImage getTile(int i){
        return this.tiles[i];
    }

    public ArrayList<Object[]> getJsonValues() throws IOException, ParseException {

        JSONObject jsonObject = (JSONObject)jsonParser.parse(fileReader);
        JSONArray layers = (JSONArray) jsonObject.get("layers");
        Iterator i = layers.iterator();
        ArrayList<Object[]> dataValues = new ArrayList<>();
        while (i.hasNext()){

            JSONObject layer = (JSONObject)i.next();
            JSONArray data = (JSONArray) layer.get("data");
            Object[] dataLong = data.toArray();
            dataValues.add(dataLong);

        }

        return dataValues;
    }

    public int getValue(int tileValue, int layer){

        return toIntExact((long)this.layers.get(layer)[tileValue]);

    }










}
