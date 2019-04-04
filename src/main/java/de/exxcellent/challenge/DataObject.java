package de.exxcellent.challenge;

import java.util.List;

public final class DataObject {

    private List<String> dataPoints;
    private List<String> dataNames;

    public DataObject(List<String> doubleDataPoints ,List<String> dataNames){
        this.dataPoints = doubleDataPoints;
        this.dataNames = dataNames;
    }

    public String getDataPoint(int id){
        return dataPoints.get(id);
    }


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

}
