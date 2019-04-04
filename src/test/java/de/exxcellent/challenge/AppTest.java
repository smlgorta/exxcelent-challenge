package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                DataObjectStrategy.Spread.apply(dataObject, Arrays.asList("a", "b")));
    }


}