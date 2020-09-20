package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job testJob1;
    Job testJob2;
    Job productTester;
    Job emptyFieldTester;

    @Before
    public void createJobs() {
        testJob1 = new Job();
        testJob2 = new Job();
        productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        emptyFieldTester = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(testJob1.getId(), testJob2.getId());
        assertEquals(testJob1.getId() + 1, testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertEquals(productTester.getEmployer().getValue(), "ACME");
        assertTrue(productTester.getLocation() instanceof Location);
        assertEquals(productTester.getLocation().getValue(), "Desert");
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertEquals(productTester.getPositionType().getValue(), "Quality control");
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(productTester.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringMethod() {
        String[] splitProductTester = productTester.toString().split("\n", -1);
        assertEquals(splitProductTester[0], "");
        assertEquals(splitProductTester[splitProductTester.length - 1], "");
    }

    @Test
    public void testToStringLines() {
        String[] splitProductTester = productTester.toString().split("\n", -1);

        for (int i = 1; i < splitProductTester.length - 1; i++) {
            assertEquals(splitProductTester[i].split(": ").length, 2);
        }
    }

    @Test
    public void testToStringEmptyFields() {
        String[] splitEmptyFieldTester = emptyFieldTester.toString().split("\n", -1);

        for (int i = 2; i < splitEmptyFieldTester.length - 1; i++) {
            assertEquals(splitEmptyFieldTester[i].split(": ").length, 2);
            assertEquals(splitEmptyFieldTester[i].split(": ")[1], "Data not available");
        }
    }
}
