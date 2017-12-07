package persistence;

public class FilesManager {

	/**
	 Created by Alejandro González on 5/12/2017.
	 */
	public static final String XML_FILE="xml";
	public static final String TEXT_FILE="txt";
	public static final String BINARY_FILE="bin";
	public static final String JSON_FILE="json";
	
	public IFileManger createTypeFile(String FileName) {
		if(FileName.toLowerCase().endsWith(XML_FILE)) {
			return null;
		}else if(FileName.toLowerCase().endsWith(TEXT_FILE)){
			return null;
		}else if(FileName.toLowerCase().endsWith(BINARY_FILE)) {
			return null;
		}else if(FileName.toLowerCase().endsWith(JSON_FILE)) {
			return null;
		}
		return null;
	}
}
