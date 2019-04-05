package de.exxcellent.challenge.strategy;

import de.exxcellent.challenge.dataobjects.DataObject;

import java.util.List;
import java.util.stream.Collectors;

public interface DataObjectStrategy{

    default List<String> parameters(DataObject dataObject, List<String> parameterNames){
        return parameterNames.stream().map(p -> dataObject.getDataPoint(p)).collect(Collectors.toList());
    }

    double apply(DataObject dataObject, List<String> parameterNames);
}
