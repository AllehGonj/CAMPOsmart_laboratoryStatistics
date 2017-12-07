package models;

import java.util.ArrayList;

public class CropList {

    private ArrayList<Crop> cropsArray = new ArrayList<>();

    public CropList() {

    }

    public ArrayList<Crop> getCropsArray() {
        return cropsArray;
    }

    public void setCropsArray(ArrayList<Crop> cropsArray) {
        this.cropsArray = cropsArray;
    }
}
