package bjonas;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.Entries;
//import com.github.davidmoten.rtree.internal.EntryDefault;
import com.github.davidmoten.rtree.geometry.Circle;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.logging.Logger;

import static com.github.davidmoten.rtree.geometry.Geometries.circle;

@Component
public class Example {
    private static Logger LOGGER = Logger.getLogger(Example.class.getName());
    private static final double PRECISION = 0.001;

    @Activate
    public void activate() {
        LOGGER.info("activating");
        testDistance();
        testMbr();
        LOGGER.info("entries");
        Circle circle = circle(1, 2, 3);
        Entry<Circle, Circle> entry = Entries.entry(circle, circle);
        // EntryDefault.entry(circle, circle);
    }


    public void testDistance() {
        LOGGER.info("Testing Circle::distance");
        Circle circle = circle(0, 0, 1);
        Rectangle r = Geometries.rectangle(1, 1, 2, 2);
        assertEquals(Math.sqrt(2) - 1, circle.distance(r), PRECISION);
    }

    public void testMbr() {
        LOGGER.info("Testing Geometries::rectangle");
        Circle circle = circle(1, 2, 3);
        Rectangle r = Geometries.rectangle(-2, -1, 4, 5);
        assertEquals(r, circle.mbr());
    }

    private void assertEquals(Rectangle expected, Rectangle actual) {
        assertEquals(expected.x1(), actual.x1(), PRECISION);
        assertEquals(expected.y1(), actual.y1(), PRECISION);
        assertEquals(expected.x2(), actual.x2(), PRECISION);
        assertEquals(expected.y2(), actual.y2(), PRECISION);
    }

    private static void assertEquals(double expected, double actual, double precision) {
        if(Math.abs(expected - actual)< precision)  {
            LOGGER.info(String.format("OK\texpected: %f, and got %f", expected, actual));
        }
        else {
            LOGGER.info(String.format("NOK\texpected: %f, but got %f", expected, actual));
        }
    }
}
