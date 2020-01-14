package training;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void testCircle()
    {
        Circle  TestCircle=new Circle(7);

        assertEquals(154,TestCircle.getArea(),0);
    }
}