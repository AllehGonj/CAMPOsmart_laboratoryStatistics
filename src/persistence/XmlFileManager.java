package persistence;

import models.Crop;
import models.Date;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class XmlFileManager implements IFileManger {

    /**
     Created by Alejandro González on 5/12/2017.
     */
	public static String PATH_FILE1="files/laboratoryResults.xml";
	@Override
	public ArrayList<Double> readFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void writeFile(String name, ArrayList arrayList) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = null;

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null,"crops", null);
        document.setXmlVersion("1.0");


        Element root = document.getDocumentElement();

        for(Object crop:arrayList){

            Element itemNode = document.createElement("crops");
            Crop cropAux= (Crop) crop;

            Element cultivationNode = document.createElement("cultivation");
            Text nodeCultivationValue = document.createTextNode(cropAux.getCultivation());
            cultivationNode.appendChild(nodeCultivationValue);

            Element phNode = document.createElement("ph");
            Text nodePhValue = document.createTextNode(Byte.toString(cropAux.getPh()));
            phNode.appendChild(nodePhValue);
            
            Element pNode = document.createElement("p");
            Text nodePValue = document.createTextNode(Byte.toString(cropAux.getP()));
            pNode.appendChild(nodePValue);

            Element caNode = document.createElement("ca");
            Text nodeCaValue = document.createTextNode(Byte.toString(cropAux.getCa()));
            caNode.appendChild(nodeCaValue);

            Element naNode = document.createElement("na");
            Text nodeNaValue = document.createTextNode(Byte.toString(cropAux.getNa()));
            naNode.appendChild(nodeNaValue);

            Element kNode = document.createElement("k");
            Text nodeKValue = document.createTextNode(Byte.toString(cropAux.getK()));
            kNode.appendChild(nodeKValue);

            Element FeNode = document.createElement("fe");
            Text nodeFeValue = document.createTextNode(Byte.toString(cropAux.getFe()));
            FeNode.appendChild(nodeFeValue);

            Element textureNode = document.createElement("texture");
            Text nodeTextureValue = document.createTextNode(cropAux.getTexture());
            textureNode.appendChild(nodeTextureValue);

            Element sandNode = document.createElement("sand");
            Text nodeSandValue = document.createTextNode(cropAux.getSand());
            sandNode.appendChild(nodeSandValue);

            Element humidityNode = document.createElement("humidity");
            Text nodeHumidityValue = document.createTextNode(Byte.toString(cropAux.getHumidity()));
            humidityNode.appendChild(nodeHumidityValue);

            Element temperatureNode = document.createElement("temperature");
            Text nodeTemperatureValue = document.createTextNode(Byte.toString(cropAux.getTemperature()));
            temperatureNode.appendChild(nodeTemperatureValue);

            Element dateNode = document.createElement("plantingDate");
            Text nodeDateValue = document.createTextNode(String.valueOf(cropAux.getPlantingDate()));
            dateNode.appendChild(nodeDateValue);

            Element cultivationTimeNode = document.createElement("cultivationTimeInDays");
            Text nodeCultivationTimeValue = document.createTextNode(String.valueOf(cropAux.getPlantingDate()));
            cultivationTimeNode.appendChild(nodeCultivationTimeValue);

            Element idNode = document.createElement("plantingDate");
            Text nodeIdValue = document.createTextNode(String.valueOf(cropAux.getPlantingDate()));
            idNode.appendChild(nodeIdValue);

            itemNode.appendChild(cultivationNode);
            itemNode.appendChild(phNode);
            itemNode.appendChild(pNode);
            itemNode.appendChild(caNode);
            itemNode.appendChild(naNode);
            itemNode.appendChild(kNode);
            itemNode.appendChild(FeNode);
            itemNode.appendChild(textureNode);
            itemNode.appendChild(sandNode);
            itemNode.appendChild(humidityNode);
            itemNode.appendChild(temperatureNode);
            itemNode.appendChild(dateNode);
            itemNode.appendChild(cultivationTimeNode);
            itemNode.appendChild(idNode);

            root.appendChild(itemNode);
        }                

        Source source = new DOMSource(document);

        Result result = new StreamResult(new java.io.File(PATH_FILE1));
        Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerFactoryConfigurationError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
