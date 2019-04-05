package de.exxcellent.challenge;

public class Day implements DataObjectInterface{

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
