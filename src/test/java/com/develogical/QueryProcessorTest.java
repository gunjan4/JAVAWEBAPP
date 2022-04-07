package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void whatIsMyNameKnown() throws Exception {
        assertThat(queryProcessor.process("your name"), containsString("JavaWeb-GR"));
    }

    @Test
    public void worksOutMaxNumber() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: which of the following numbers is the largest: 2000, 2001, 2002, 2003"), is("2003"));
    }

    @Test
    public void adds2Numbers() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: what is 20 plus 8"), is("28"));
    }

    @Test
    public void multiply2Numbers() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: what is 20 multiplied by 17"), is("340"));
    }

    @Test
    public void squareAndCubeQuery() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: which of the following numbers is both a square and a cube: 64, 86"), is("64"));
    }
}
