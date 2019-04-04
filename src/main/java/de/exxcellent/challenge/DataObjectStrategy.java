package de.exxcellent.challenge;

import java.util.List;
import java.util.stream.Collectors;

public class DataObjectStrategy{

    private static List<String> parameters(DataObject dataObject, List<String> parameterNames){
        return parameterNames.stream().map(p -> dataObject.getDataPoint(p)).collect(Collectors.toList());
    }

    static class Spread{

        public static double apply(DataObject dataObject, List<String> parameterNames) {
            List<Double> parameters = parameters(dataObject, parameterNames).stream()
                    .map(p -> Double.parseDouble(p)).collect(Collectors.toList());
            return parameters.get(0) - parameters.get(1);
        }
    }
}
