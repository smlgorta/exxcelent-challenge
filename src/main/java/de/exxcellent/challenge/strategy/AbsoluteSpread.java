package de.exxcellent.challenge.strategy;

import de.exxcellent.challenge.dataobjects.DataObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Strategy that calculates the absolute difference between first and second parameter
 */
public enum AbsoluteSpread implements DataObjectStrategy{

    INSTANCE;

    @Override
    public double apply(DataObject dataObject, List<String> parameterNames) {
        List<Double> parameters = parameters(dataObject, parameterNames).stream()
                .map(p -> Double.parseDouble(p)).collect(Collectors.toList());
        return Math.abs(parameters.get(0) - parameters.get(1));
    }

}
