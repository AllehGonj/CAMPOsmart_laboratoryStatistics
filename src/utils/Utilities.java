package utils;

import exceptions.DuplicateException;
import exceptions.ValidateException;
import models.Crop;
import models.CropList;
import models.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utilities {

    private CropList cropList;
    private Calendar calendar;
    private Date date;

    public Utilities() {
        cropList = new CropList();
    }

    public void addCrop(Crop cropObj) {
        cropList.getCropsArray().add(cropObj);
    }

    public void dismissCrop(int position) {
        cropList.getCropsArray().remove(position);
    }

    public void organizeArray() {
        Collections.sort(cropList.getCropsArray());
    }

    public String getDuration(short day, short month, short year, short durationInDays){

        calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_YEAR, durationInDays);

        return dateFormat.format(calendar.getTime());
    }

    public void addOneCrop(String cultivation, String texture, String sand, byte ph, byte p, byte ca, byte na, byte k,
                           byte fe, byte humidity, byte temperature, short cultivationTimeInDays, int id,
                           short year, short month, short day) {
        try {
            addCrop(createAcrop(id, cultivation, ph, p, ca, na, k, fe, texture, sand, humidity, temperature,
                    cultivationTimeInDays, year, month, day));
        } catch (DuplicateException e) {
            //io.showMessage(e.getMessage());
        }
    }

    public String showCropsData() {
        ArrayList<Crop> cropsArray = cropList.getCropsArray();
        String output = "";
        int i = 0;
        Iterator<Crop> iterator = cropsArray.iterator();

        while (iterator.hasNext()) {
            Crop crop = iterator.next();
            output += crop.toString() + "\n";
        }

        return output;
    }

    public String certainCrop(int position) {
        String reply = "";

        if (position >= 0) {
            reply = "" + cropList.getCropsArray().get(position);
        } else {
            reply = "Crop not found";
        }

        return reply;
    }

    public int findidcrop(int request) {

        int position = -1;
        for (int i = 0; i < cropList.getCropsArray().size(); i++) {
            if (request == cropList.getCropsArray().get(i).getId()) {
                position = i;
            }
        }
        return position;
    }

    public int findIdCrop(int id) {

        int position = -1;
        for (int i = 0; i < cropList.getCropsArray().size(); i++) {
            if (id == cropList.getCropsArray().get(i).getId()) {
                position = i;
            }
        }
        return position;
    }

    public Crop[] dismissInChain(int from, int to) {
        Crop dismiss[] = new Crop[(to - from) + 1];
        int j = 0;
        for (int i = from; i <= to; i++) {
            dismiss[j] = cropList.getCropsArray().get(i);
            j++;
        }
        cropList.getCropsArray().subList(from, to+1).clear();
        return dismiss;
    }

    public String dismissOrResignationEmployeeInChain(int from, int to) {
        String reply;

        if (from >= 0) {
            reply = "" + showArrays(dismissInChain(from, to));
        } else {
            //io.showMessage("Employee no found");
            reply = "Employee no found";
        }

        return reply;
    }

    public String dismissOrResignationEmployee(int position) {
        String reply = "";

        if (position >= 0) {
            dismissCrop(position);
        } else {
            reply = "Employee no found";
            //io.showMessage("Employee no found");
        }

        return reply;
    }


    public String showArrays(Crop[] array) {
        String arrays = "";

        for (int i = 0; i < array.length; i++) {
            arrays += array[i] + "\n";
        }

        return arrays;
    }


    public int countCrops() {
        return cropList.getCropsArray().size();
    }

    public Date createDate(String message, short day, short month, short year) {
        //io.showMessage(message);

        short dayAux = day;
        short monthAux = month;
        short yearAux = year;

        return new Date(yearAux, monthAux, dayAux);
    }

    public Crop createAcrop(int id, String cultivation, byte ph, byte p, byte ca, byte na, byte k, byte fe,
                            String texture, String sand, byte humidity, byte temperature,
                            short cultivationTime, short day, short month, short year) throws DuplicateException {

        int idAux = 0;
        String exceptions;
        //io.showMessage("Enter the following Data");
        do {
            try {
                //idAux = io.readInt("Code (Between  10-99)");
                if (idAux < 10 || idAux > 99)
                    throw new ValidateException("The code must be between 10 y 99");
            } catch (InputMismatchException e) {
                //io.showMessage("it's has to be a number");
                exceptions = "it's has to be a number";
                //io.clear();
            } catch (ValidateException e) {
                //io.showMessage(e.getMessage());
            }
        } while (id < 10 || id > 99);
        if (findidcrop(id) != -1) {
            throw new DuplicateException("The code already exists");
        } else {

            String cultivationAux = cultivation;
            byte phAux = ph;
            byte pAux = p;
            byte caAux = ca;
            byte naAux = na;
            byte kAux = k;
            byte feAux = fe;
            String textureAux = texture;
            String sandAux = sand;
            byte humidityAux = humidity;
            byte temperatureAux = temperature;
            short cultivationTimeAux = cultivationTime;

            Crop cropObj = new Crop(cultivationAux, textureAux, sandAux, phAux, pAux, caAux, naAux, kAux, feAux,
                    humidityAux, temperatureAux, cultivationTimeAux, idAux);

            Date dateObj = new Date();
                dateObj = createDate("Enter the plantation date", day, month, year);
                cropObj.setPlantingDate(dateObj);


            return cropObj;
        }
    }
}
