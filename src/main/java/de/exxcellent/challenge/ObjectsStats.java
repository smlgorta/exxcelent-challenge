package de.exxcellent.challenge;

import de.exxcellent.challenge.dataobjects.ObjectWithData;
import de.exxcellent.challenge.strategy.DataObjectStrategy;

import java.util.Comparator;
import java.util.List;

public class ObjectsStats {

    /**
     * Finds object with minimum value after applying strategy to the parameters given.
     * It casts the returned object to type
     * objects within objectList must implement the ObjectWithData interface
     * @param objectList
     * @param parameters
     * @param strategy
     * @param type
     * @param <T>
     * @return
     */
    static <T extends ObjectWithData> T findObjectWithMinValue(List<? extends ObjectWithData> objectList,
                                                               List<String> parameters,
                                                               DataObjectStrategy strategy,
                                                               Class<T> type){
        ObjectWithData object = objectList.stream()
                .min(Comparator.comparing(p -> strategy.apply(p.getDataObject(), parameters)))
                .get();
        return type.cast(object);
    }
}
