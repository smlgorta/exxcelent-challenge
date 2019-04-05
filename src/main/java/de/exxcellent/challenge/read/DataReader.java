package de.exxcellent.challenge.read;

import de.exxcellent.challenge.dataobjects.DataObject;

import java.util.List;

public interface DataReader {
    List<DataObject> getData(String fileName);
}
