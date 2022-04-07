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

    @Test
    public void cityIsEiffelTowerIn() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: which city is the Eiffel tower in"), is("Paris"));
    }
}
// who played James Bond in the film Dr No" host=javawebdb.herokuapp.com request_id=153258fa-983e-4d9d-a5b3-6060f8091e98 fwd="34.254.146.190" dyno=web.1 connect=0ms service=2ms status=200 bytes=173 protocol=http
//2022-04-07T14:47:51.379924+00:00 heroku[router]: at=info method=GET path="/api?q=9f8340c0: which city is the Eiffel tower in" host=javawebdb.herokuapp.com request_id=a112467e-b79e-4cbe-b78d-5524ab1cdeca fwd="34.25

//
//=8e3ef2f0: which city is the Eiffel tower in" host=javawebdb.herokuapp.com request_id=fc48f4e8-1bb8-4513-b6db-dc07c1361160 fwd="34.254.146.190" dyno=web.1 connect=0ms service=1ms status=200 bytes=173 protocol=http
//

//2-04-07T14:49:04.079168+00:00 heroku[router]: at=info method=GET path="/api?q=cada1b60: which year was Theresa May first elected as the Prime Minister of Great Britain" host=javawebdb.herokuapp.com request_id=f1d67fb8-6ecc-44ae-b778-8d620c4678b8 fwd="34.254.146.190" dyno=web.1 connect=0ms service=2ms status=200 bytes=173 protocol=http