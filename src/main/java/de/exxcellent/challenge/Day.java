package de.exxcellent.challenge;

public class Day{

    private int dayNumber;
    private DataObject dataObject;

    public Day(int dayNumber, DataObject dataObject){
        this.dayNumber = dayNumber;
        this.dataObject = dataObject;
    }

    public DataObject getDataObject() {
        return new DataObject(dataObject.getDataPoints(), dataObject.getDataNames());
    }

    public int getDayNumber(){
        return dayNumber;
    }
}
