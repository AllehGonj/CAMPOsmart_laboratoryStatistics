package controller;

import utils.ManageModels;
import utils.Utilities;
import view.IOManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{

    private ManageModels manageModels;
    private Utilities utilities;
    private IOManager io;

    private static Control control;
    public static  int instance;

    public Control() {
        manageModels = new ManageModels();
        utilities = new Utilities();
        io = new IOManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static Control getInstance(int instances) {
        if(instance==0) {
            instance=instances;
            control= new Control();
        }
        return control;
    }

    public void menu() {
        int option = 0;
        do {
            option = io.readMenu();
            switch (option) {
                case 1:
                    addOneCrop();
                    break;
                case 2:
                    
                    break;
                case 3:
                    showCropsData();
                    break;
                case 4:
                    certainCrop();
                    break;
                case 5:
                    orderData();
                    break;
                case 6:

                    break;
                case 7:
                    dismissOrResignationEmployeeInChain();
                    break;
                case 8:
                    countEmployees();
                    break;
                case 9:

                    break;
                case 10:
                    break;
                default:
                    io.showMessage("Error, incorrect option");
            }
        } while (option != 10);
    }

    private void countEmployees() {
        io.showMessage("You has: " + utilities.countCrops() + "crops.");
    }

    public void dismissOrResignationEmployeeInChain(){
        utilities.dismissOrResignationEmployeeInChain(utilities.findIdCrop(io.readInt("")),
                utilities.findIdCrop(io.readInt("")));
    }

    private void orderData() {
        utilities.organizeArray();
    }

    private void certainCrop() {
        io.showMessage(utilities.certainCrop(utilities.findIdCrop(io.readInt("Enter the id to search"))));
    }

    private void showCropsData() {
        io.showMessage(utilities.showCropsData());
    }

    private void addOneCrop() {
        utilities.addOneCrop(io.readString("Enter the name"), io.readString("Enter texture"),
                io.readString("Enter sand value"), io.readByte("Enter ph value"), io.readByte("Enter p vlaue"),
                io.readByte("Enter ca Value"), io.readByte("Enter na value"), io.readByte("Enter k value"),
                io.readByte("Enter Fe value"), io.readByte("Enter humidity value"), io.readByte("Enter temperaure value"),
                io.readShort("Enter the duration in days of the cultivation"), io.readInt("Enter an Id for the crop"),
                io.readShort("Enter the plantation day"), io.readShort("Enter the plantation month"),
                io.readShort("Enter the plantation year"));

        manageModels.saveXml();
    }
}
