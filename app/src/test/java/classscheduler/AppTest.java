/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package classscheduler;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

public class AppTest {
    InputStream sysInBackup;
    PrintStream sysOutBackup;

    @Before
    public void backupSystem() {
        sysInBackup = System.in;
        sysOutBackup = System.out;
    }

    public void replaceSystemIn(String simInput) {
        ByteArrayInputStream in = new ByteArrayInputStream(simInput.getBytes());
        System.setIn(in);
    }

    public ByteArrayOutputStream replaceSystemOut() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @Test 
    public void testAddsOneBlock() {
        replaceSystemIn(CommonFixtures.classDatabase+"add\r\n0\r\nviewSchedule\r\n");
        ByteArrayOutputStream outContent = replaceSystemOut();
        try {
            App.main(null);
        } catch (NoSuchElementException e) {
            
        }
        System.err.println(outContent.toString());
        assertTrue(outContent.toString().contains("Block 1: AP Lang"));
        assertTrue(outContent.toString().contains("Block 2: empty"));
        assertTrue(outContent.toString().contains("Block 3: empty"));
        assertTrue(outContent.toString().contains("Block 4: empty"));
    }

    @After
    public void restoreSystem() {
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }
}
