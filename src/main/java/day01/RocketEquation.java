package day01;

import java.util.List;

public class RocketEquation
{
    public int calculateTotalFuelRequirement( final List<Integer> moduleMasses)
    {
        return moduleMasses.stream().mapToInt( this::calculateFuelRequirement ).sum();
    }

    public int calculateFuelRequirement( final int mass )
    {
        // Round down by discarding the remainder
        int fuel = mass / 3;
        fuel -= 2;

        return fuel;
    }
}
