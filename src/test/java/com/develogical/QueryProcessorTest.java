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

    @Test
    public void yearTheresaMayWasPrimeMinister() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: which year was Theresa May first elected as the Prime Minister of Great Britain"), is("2016"));
    }

    @Test
    public void playedJamesBondInDrNo() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: who played James Bond in the film Dr No"), is("Sean Connery"));
    }

    @Test
    public void colourOnBanana() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: what colour is a banana"), is("yellow"));
    }

    @Test
    public void minusNumber() throws Exception {
        assertThat(queryProcessor.process("71ba53e0: what is 10 minus 17"), is("-7"));
    }
}


//0which of the following numbers are primes: 77, 702, 313, 457" host=javawebdb.herokuapp.com request_id=37047949-d55b-4787-9800-cd2d67ae98ec fwd="34.254.146.190" dyno=web.1 connect=0ms service=1ms status=200 bytes=173 protocol=http
//2022-04-07T14:54:09.894308+00:00 heroku[router]: at=info method=GET path="/api?

//20what%20is%20the%2018th%20number%20in%20the%20Fibonacci%20sequence" host=javawebdb.herokuapp.com request_id=477de8d3-99f9-44fc-899a-a9e056012692 fwd="34.254.146.190" dyno=web.1 connect=0ms service=2ms status=200 bytes=173 protocol=http
//        2022-04-07T15:09:36.417772+00:00 heroku[router]: at=info method=GET path="/api?q=a9617480:%20who%20played%20James%20Bond%20in%20the%20film%20Dr%20No" host=javawebdb.herokuapp.com request_id=48405648-80bd-45bf-bf2d-e206a2dc801b fwd="34.254.146.190" dyno=web.1 connect=0ms service=1ms status=200 bytes=186 protoc