package de.exxcellent.challenge.dataobjects;

public class Day implements ObjectWithData {

    private int dayNumber;
    private DataObject dataObject;

    public Day(int dayNumber, DataObject dataObject){
        this.dayNumber = dayNumber;
        this.dataObject = dataObject;
    }


    public int getDayNumber(){
        return dayNumber;
    }

    @Override
    public DataObject getDataObject() {
        return new DataObject(dataObject.getDataPoints(), dataObject.getDataNames());
    }
}
