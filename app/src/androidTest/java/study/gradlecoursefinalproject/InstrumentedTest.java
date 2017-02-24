package study.gradlecoursefinalproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("study.gradlecoursefinalproject", appContext.getPackageName());
    }

    @Test
    public void testEndpointTask() throws ExecutionException, InterruptedException {
        String result = new EndpointAsyncTask().execute().get();
        assertNotNull(result);
        assertNotEquals(result,"error");
        assertTrue(result.length()>0);
    }
}
