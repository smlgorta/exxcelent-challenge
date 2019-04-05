package de.exxcellent.challenge.dataobjects;

public class TeamStats implements ObjectWithData {

    private String name;
    private DataObject dataObject;

    public TeamStats(String name, DataObject dataObject){
        this.name = name;
        this.dataObject = dataObject;
    }


    public String getName(){
        return name;
    }

    @Override
    public DataObject getDataObject() {
        return new DataObject(dataObject.getDataPoints(), dataObject.getDataNames());
    }
}
