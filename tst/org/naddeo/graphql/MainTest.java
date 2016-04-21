package org.naddeo.graphql;

import lombok.Builder;
import org.junit.Test;
import org.naddeo.graphql.test.data.DocumentInput;

import java.io.File;
import java.io.PrintWriter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    private static final String JAR = "./bin/graphql-parser.jar";

    @Test
    public void test_happyPath() throws Exception
    {
        TestOutput testOutput = testParser(DocumentInput.HAPPY_PATH.getTest().getParserInput());
        assertThat(testOutput.exitValue, equalTo(0));
    }

    @Test
    public void test_invalidInput() throws Exception
    {
        TestOutput testOutput = testParser("!! some nonsense");
        assertThat(testOutput.exitValue, equalTo(1));
    }

    /**
     * Fork a subprocesss to run sample input using the compiled jar.
     * @param input The GraphQL query input.
     * @return An object containing any stdout from the subprocess, as well as the exit value.
     * @throws Exception Parsing and process related errors. If this happens, the jar may not
     * have been built yet.
     */
    public TestOutput testParser(String input) throws Exception
    {
        File jar = new File(JAR);
        assertThat("Jar doesn't exist. You have to build this project with ant to produce the jar", jar.exists(), is(true));

        Process main = Runtime.getRuntime().exec("java -jar " + JAR);

        PrintWriter out = new PrintWriter(main.getOutputStream());
        out.write(input);
        out.flush();
        out.close();

        while(main.isAlive()){
            Thread.sleep(1000);
        }

        return TestOutput.builder()
                .exitValue(main.exitValue())
                .output(convertStreamToString(main.getInputStream()))
                .build();
    }

    @Builder
    static class TestOutput {
        public final String output;
        public final int exitValue;
    }

    /**
     * Helper function from "Stupid scanner tricks" to convert input streams into strings.
     * @param is An input stream to convert.
     * @return A string representation of the input stream content.
     */
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}