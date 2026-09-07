package fileutils;

import java.io.IOException;
import java.util.List;
import java.io.UncheckedIOException;
import java.util.Objects;


public class FileReader
{
    public List<Integer> readIntegersFromResource( final String resourceName )
    {
        try ( var inputStream = Objects.requireNonNull( getClass().getResourceAsStream( resourceName ) ) )
        {
            return new java.io.BufferedReader(
                    new java.io.InputStreamReader( inputStream ) )
                    .lines()
                    .map( Integer::parseInt )
                    .toList();

        }
        catch ( IOException e )
        {
            throw new UncheckedIOException( e );
        }
    }
}
