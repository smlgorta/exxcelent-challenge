package de.exxcellent.challenge;

import de.exxcellent.challenge.dataobjects.DataObject;
import de.exxcellent.challenge.dataobjects.Day;
import de.exxcellent.challenge.dataobjects.ObjectWithData;
import de.exxcellent.challenge.read.CsvDataReader;
import de.exxcellent.challenge.read.DataReader;
import de.exxcellent.challenge.strategy.DataObjectStrategy;
import de.exxcellent.challenge.strategy.Spread;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {


        // Your preparation code …
        DataReader dataReader = new CsvDataReader();

        List<DataObject> dataObjects = dataReader.getData("src/main/resources/de/exxcellent/challenge/weather.csv");

        List<Day> days = dataObjects.stream().map(p -> new Day(Integer.parseInt(p.getDataPoint("Day")), p)).collect(Collectors.toList());

        String dayWithSmallestTempSpread = ObjectsStats.findObjectWithMinValue(days, Arrays.asList("MxT", "MnT"), Spread.INSTANCE, Day.class).getDayNumber() + "";

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }


}
