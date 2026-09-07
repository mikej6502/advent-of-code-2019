package day01;

import static org.junit.jupiter.api.Assertions.*;

import fileutils.FileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RocketEquationTest
{
    @ParameterizedTest
    @CsvSource({
            "12, 2",
            "14, 2",
            "1969, 654",
            "100756, 33583",
    })
    void shouldCalculateRocketFuelRequiredFromMass( int mass, int expectedFuel )
    {
        final RocketEquation rocketEquation = new RocketEquation();

        final int result = rocketEquation.calculateFuelRequirement( mass );

        assertEquals( expectedFuel, result );
    }

    @Test
    public void shouldCalculateTotalFuelRequirementsForEachModule()
    {
        final RocketEquation rocketEquation = new RocketEquation();

        final int result = rocketEquation.calculateTotalFuelRequirement( List.of( 12, 14, 1969, 100756 ) );

        assertEquals( 34241, result );
    }

    @Test
    public void part1()
    {
        final FileReader reader = new FileReader();

        var input = reader.readIntegersFromResource( "/day1_part1.txt" );
        final RocketEquation rocketEquation = new RocketEquation();

        final int result = rocketEquation.calculateTotalFuelRequirement( input );

        assertEquals( 3266053, result );
    }
}