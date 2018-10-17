package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import org.junit.Test;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

import static org.junit.Assert.*;

public class ItemsTest {

    @Test
    public void getAvailableItem() {
        Items items=new Items();
        ActiveItem activeItem=items.getAvailableItem();
        assertEquals(null,activeItem);

        GameSetting gameSetting = new GameSetting(500, 500);
        gameSetting.put("holeNumber",3);
        Scene scene = new ClassicFroggerScene(gameSetting);
        Lane lane = new Lane(true, 50, 100, new Cars(scene), 200, scene);

        activeItem=new Car(lane,scene);

        items.addToPool(activeItem);
        assertEquals(activeItem,items.getAvailableItem());

    }

    @Test
    public void addToPool() {
        Items items=new Items();

        GameSetting gameSetting = new GameSetting(500, 500);
        gameSetting.put("holeNumber",3);
        Scene scene = new ClassicFroggerScene(gameSetting);
        Lane lane = new Lane(true, 50, 100, new Cars(scene), 200, scene);




        ArrayList<ActiveItem> activeItems=new ArrayList<>();
        for(int i=0;i<35;i++){
            ActiveItem activeItem=new Car(lane,scene);
            items.addToPool(activeItem);
            activeItems.add(activeItem);
        }
        for(int i=0;i<30;i++){
            ActiveItem activeItem=items.getAvailableItem();
            assertTrue(activeItems.contains(activeItem));
            activeItems.remove(activeItem);
        }
        for (ActiveItem activeItem:activeItems){
            assertEquals(null,items.getAvailableItem());
        }

    }
}