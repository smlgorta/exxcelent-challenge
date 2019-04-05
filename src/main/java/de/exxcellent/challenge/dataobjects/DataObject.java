package de.exxcellent.challenge.dataobjects;

import java.util.ArrayList;
import java.util.List;

public final class DataObject {

    private List<String> dataPoints;
    private List<String> dataNames;

    public DataObject(List<String> doubleDataPoints ,List<String> dataNames){
        this.dataPoints = new ArrayList<>(doubleDataPoints);
        this.dataNames = new ArrayList<>(dataNames);
        if(dataPoints.size() != dataNames.size()) throw new IllegalArgumentException("number of data points and data names are different");
    }

    public String getDataPoint(int id){
        return dataPoints.get(id);
    }


    /**
     * returns dataPoint that corresponds to the name given by parameter. return "" otherwise.
     * @param nameSought
     * @return
     */
    public String getDataPoint(String nameSought){
        int idx = 0;
        for(String name: dataNames) {
            if (name.equals(nameSought)) {
                return getDataPoint(idx);
            }
            idx++;
        }
        return "";
    }

    public List<String> getDataPoints(){
        return new ArrayList<>(dataPoints);
    }

    public List<String> getDataNames(){
        return new ArrayList<>(dataNames);
    }

}
