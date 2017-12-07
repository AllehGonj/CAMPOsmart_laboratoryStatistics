package utils;

import models.Crop;
import models.CropList;
import persistence.JsonFileManager;
import persistence.XmlFileManager;

public class ManageModels {

    private CropList cropList;
    private XmlFileManager xmlFileManager;
    private JsonFileManager jsonFileManager;
    private Utilities utilities;

    public ManageModels() {
        cropList = new CropList();
        xmlFileManager = new XmlFileManager();
        jsonFileManager = new JsonFileManager();
        utilities = new Utilities();
        cropList.setCropsArray(jsonFileManager.readFile("files/laboratoryResults.json"));
        saveXml();
    }

    public static String[] employeeToArray(Crop crop) {
        String[] array = new String[10];

            array[0] = "" + crop.getCultivation();
            array[1] = "" + crop.getPh();
            array[2] = "" + crop.getP();
            array[3] = "" + crop.getCa();
            array[4] = "" + crop.getNa();
            array[5] = "" + crop.getK();
            array[6] = "" + crop.getFe();
            array[7] = "" + crop.getTexture();
            array[8] = "" + crop.getSand();
            array[9] = "" + crop.getHumidity();
            array[10] = "" + crop.getTemperature();

        return array;
    }

    public void saveXml() {
        try {
            xmlFileManager.writeFile(":)", cropList.getCropsArray());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
