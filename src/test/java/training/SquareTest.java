package training;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    @Test
    public void testSquare()
    {
       Square TestSquare = new Square(5);

       assertEquals(25,TestSquare.getArea(),0);
    }


}