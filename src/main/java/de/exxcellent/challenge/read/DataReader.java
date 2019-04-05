package de.exxcellent.challenge;

import java.util.List;

public interface DataReader {
    List<DataObject> getData(String fileName);
}
