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
    public void addsThe2NumbersWithWhich() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 2000, 2001, 2002, 2003"), is("2003"));
    }

//    @Test
//    public void addsThe2NumbersWithWhich() throws Exception {
//        assertThat(queryProcessor.process("which of the following numbers is the largest: 2000, 2001, 2002, 2003"), is("2003"));
//    }
}
