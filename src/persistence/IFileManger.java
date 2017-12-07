package persistence;

import java.util.ArrayList;

public interface IFileManger<E> {

	/**
	 Created by Alejandro González on 5/12/2017.
	 */
	abstract ArrayList<E> readFile(String name);
	abstract void writeFile(String name, ArrayList<Object> arrayList);
}
