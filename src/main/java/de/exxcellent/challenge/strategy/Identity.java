package de.exxcellent.challenge.strategy;

import de.exxcellent.challenge.dataobjects.DataObject;

import java.util.List;
import java.util.stream.Collectors;

public enum Spread implements DataObjectStrategy{

    INSTANCE;

    @Override
    public double apply(DataObject dataObject, List<String> parameterNames) {
        List<Double> parameters = parameters(dataObject, parameterNames).stream()
                .map(p -> Double.parseDouble(p)).collect(Collectors.toList());
        return parameters.get(0) - parameters.get(1);
    }

}
