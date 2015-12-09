import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by user on 12/9/15.
 */
public class ClosestPointsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testClosestPointsInSet() throws Exception {
        ClosestPoints closestPoints = new ClosestPoints();
        Set<Point> Q = closestPoints.fileToPointSet("sample.data");
        Set<Point> closestPointsInQ = closestPoints.closestPointsInSet(Q);
        String closestPointsInQString = closestPoints.pointSetToString(closestPointsInQ);

        assertEquals("(5.790731, 1.129818) (5.7916884, 1.1280184) ", closestPointsInQString);
    }
}