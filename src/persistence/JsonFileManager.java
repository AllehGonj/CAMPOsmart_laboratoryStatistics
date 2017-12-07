package persistence;

import models.Crop;
import models.Date;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Statistics;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonFileManager  implements IFileManger<Crop> {

	/**
	 Created by Alejandro González on 5/12/2017.
	 */

	private Statistics statistics = new Statistics();

	public JsonFileManager() {
		readFile("files/laboratoryResults.json");
	}

	@Override
	public ArrayList<Crop> readFile(String name) {
		ArrayList<Crop> personList= new ArrayList<>();
		JSONParser parser= new JSONParser();
		Object object = null;
		try {
			object = parser.parse(new FileReader(name));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.json.simple.JSONObject jsonObject=(org.json.simple.JSONObject) object;
		
		JSONArray listOfPersons = (JSONArray) jsonObject.get("crops");
		Iterator<Object> iteratorPersons=listOfPersons.iterator();

		while (iteratorPersons.hasNext()) {
			Crop crop = null;

			org.json.simple.JSONObject personObject=(org.json.simple.JSONObject)iteratorPersons.next();

			String cultivation = (String)personObject.get("cultivation");
			String ph = (String)personObject.get("ph");
			String p = (String)personObject.get("p");
			String ca = (String)personObject.get("ca");
			String na = (String)personObject.get("na");
			String k = (String)personObject.get("k");
			String fe = (String)personObject.get("fe");
			String texture = (String)personObject.get("texture");
			String sand = (String)personObject.get("sand");
			String humidity = (String)personObject.get("humidity");
			String temperature = (String)personObject.get("temperature");
			String date = (String)personObject.get("plantingDate");

			String[] partsDate = date.split("/");
				String day = partsDate[0];
				String month = partsDate[1];
				String year = partsDate[2];

				Date dateObj = new Date(Short.parseShort(year), Short.parseShort(month), Short.parseShort(day));

			String cultivationTimeInDays = (String)personObject.get("cultivationTimeInDays");
			String id = (String)personObject.get("id");

			if (statistics.filterCrops(Byte.parseByte(ph), Byte.parseByte(p), Byte.parseByte(ca), Byte.parseByte(na),
					Byte.parseByte(k), Byte.parseByte(fe))){
				crop = new Crop(cultivation, Byte.parseByte(ph), Byte.parseByte(p), Byte.parseByte(ca), Byte.parseByte(na),
						Byte.parseByte(k), Byte.parseByte(fe), texture, sand, Byte.parseByte(humidity), Byte.parseByte(temperature),
						dateObj, Short.parseShort(cultivationTimeInDays), Integer.parseInt(id));

				personList.add(crop);
			}
		}
		return personList;
	}


	@Override
	public void writeFile(String name, ArrayList<Object> arrayList) {
		// TODO Auto-generated method stub
		
	}
}
