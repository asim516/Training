package training;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
public void testRectangle()
{
    Rectangle  TestRectangle = new Rectangle(5,5);

    assertEquals(25,TestRectangle.getArea(),0);
}


}