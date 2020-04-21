package training;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class ItemsCreatorTest {

    @Test public void Testitems() {

        ItemsCreator test = new ItemsCreator();
        assertNotNull("items inserted",test.putItem());
    }
}