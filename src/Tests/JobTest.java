package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import static org.junit.Assert.*;

public class JobTest {

    Job test_job_1;
    Job test_job_2;

    @Before
    public void createJobs() {
        test_job_1 = new Job();
        test_job_2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(test_job_1, test_job_2);
    }

}
