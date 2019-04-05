package de.exxcellent.challenge.read;

import de.exxcellent.challenge.dataobjects.DataObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvDataReader implements DataReader{

    @Override
    public List<DataObject> getData(String fileName) {
        List<DataObject> dataObjects = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
            String[] dataNames = line.split(cvsSplitBy);
            List<String> dataNamesList = Arrays.asList(dataNames);

            while ((line = br.readLine()) != null) {
                String[] dataObject = line.split(cvsSplitBy);
                dataObjects.add(new DataObject(Arrays.asList(dataObject), dataNamesList));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataObjects;
    }
}
