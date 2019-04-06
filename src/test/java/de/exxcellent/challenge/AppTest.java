package de.exxcellent.challenge;

import de.exxcellent.challenge.dataobjects.DataObject;
import de.exxcellent.challenge.dataobjects.Day;
import de.exxcellent.challenge.strategy.AbsoluteSpread;
import de.exxcellent.challenge.strategy.Identity;
import de.exxcellent.challenge.strategy.Spread;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    public void setUp() {
        successLabel = "successful";
    }

    @Test
    public void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    public void runFootball() {
        App.main("--football", "football.csv");
    }


    @Test
    public void getDataGivenNameTest(){
        List<String> dataPoints = Arrays.asList("2.5", "3.4", "5.6", "0.0");
        List<String> dataNames = Arrays.asList("a", "b", "c", "d");
        DataObject dataObject = new DataObject(dataPoints, dataNames);
        assertEquals(dataPoints.get(0), dataObject.getDataPoint("a"));
    }

    @Test
    public void spreadTest(){
        List<String> dataPoints = Arrays.asList("2.5", "3.4");
        List<String> dataNames = Arrays.asList("a", "b");
        DataObject dataObject = new DataObject(dataPoints, dataNames);
        assertEquals(Double.parseDouble(dataPoints.get(0)) - Double.parseDouble(dataPoints.get(1)),
                Spread.INSTANCE.apply(dataObject, Arrays.asList("a", "b")));
    }

    @Test
    public void absoluteSpreadTest(){
        List<String> dataPoints = Arrays.asList("-2.5", "3.4");
        List<String> dataNames = Arrays.asList("a", "b");
        DataObject dataObject = new DataObject(dataPoints, dataNames);
        assertEquals(Math.abs(Double.parseDouble(dataPoints.get(0)) - Double.parseDouble(dataPoints.get(1))),
                AbsoluteSpread.INSTANCE.apply(dataObject, Arrays.asList("a", "b")));
        assertEquals(Math.abs(Double.parseDouble(dataPoints.get(0)) - Double.parseDouble(dataPoints.get(1))),
                AbsoluteSpread.INSTANCE.apply(dataObject, Arrays.asList("b", "a")));

    }

    @Test
    public void spreadTestNegativeValues(){
        List<String> dataPoints = Arrays.asList("-2.5", "3.4");
        List<String> dataNames = Arrays.asList("a", "b");
        DataObject dataObject = new DataObject(dataPoints, dataNames);
        assertEquals(Double.parseDouble(dataPoints.get(0)) - Double.parseDouble(dataPoints.get(1)),
                Spread.INSTANCE.apply(dataObject, Arrays.asList("a", "b")));
    }


    @Test
    public void findObjectWithMinTest(){
        List<Day> days = new ArrayList<>();

        List<String> dataPoints = Arrays.asList("2.5", "-3.4");
        List<String> dataNames = Arrays.asList("a", "b");
        DataObject dataObject = new DataObject(dataPoints, dataNames);
        days.add(new Day(0, dataObject));

        dataPoints = Arrays.asList("-2.5", "3.4");
        dataNames = Arrays.asList("a", "b");
        dataObject = new DataObject(dataPoints, dataNames);
        days.add(new Day(1, dataObject));

        dataPoints = Arrays.asList("8", "3.4");
        dataNames = Arrays.asList("a", "b");
        dataObject = new DataObject(dataPoints, dataNames);
        days.add(new Day(2, dataObject));

        assertEquals(days.get(1), ObjectsStats.findObjectWithMinValue(days, Arrays.asList("a"), Identity.INSTANCE, Day.class));
        assertEquals(days.get(0), ObjectsStats.findObjectWithMinValue(days, Arrays.asList("b"), Identity.INSTANCE, Day.class));

    }

}