package org.rawdoughnuts.http;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ParameterizedRequestLineTest {
    private String testData;
    private Method expectedMethod;
    private String expectedTarget;
    private String expectedVersion;
    private BufferedRequestParser parser;

    public ParameterizedRequestLineTest(String testLine, Method expectedMethod, String expectedTarget, String expectedVersion) {
        this.testData = testLine;
        this.expectedMethod = expectedMethod;
        this.expectedTarget = expectedTarget;
        this.expectedVersion = expectedVersion;
    }

    @Parameterized.Parameters (name="{index}")
    public static Collection<Object[]> makeData () {
        ArrayList<Object[]> data = new ArrayList();
        for (Method m : Method.values()) {
            data.add(new Object[] {m.name() + " /test http1/1", m, "/test", "http1/1"});
        }
        return data;
    }

    @Before
    public void setup () throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn(testData);
        parser = new BufferedRequestParser(reader);
    }

    @Test
    public void testParseRequestLine () throws Exception {
        RequestLine line = parser.parseRequestLine();
        assertNotNull(line);
        assertNotNull(line.getTarget());
        assertNotNull(line.getMethod());
        assertNotNull(line.getVersion());
        assertEquals(line.getTarget(), expectedTarget);
        assertEquals(line.getMethod(), expectedMethod);
        assertEquals(line.getVersion(), expectedVersion);
    }
}