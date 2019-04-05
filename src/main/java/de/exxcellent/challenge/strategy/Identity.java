package de.exxcellent.challenge.strategy;

import de.exxcellent.challenge.dataobjects.DataObject;

import java.util.List;
import java.util.stream.Collectors;

public enum Identity implements DataObjectStrategy{

    INSTANCE;

    @Override
    public double apply(DataObject dataObject, List<String> parameterNames) {
        return Double.parseDouble(parameters(dataObject, parameterNames).get(0));
    }

}
