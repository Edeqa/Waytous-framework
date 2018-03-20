package com.edeqa.waytous;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * Created 11/11/17.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignProviderTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructor() throws Exception {

        SignProvider value = SignProvider.FACEBOOK;

        System.out.println(value);
        System.out.println(value.toString());

    }

    @Test
    public void parse() {

        assertEquals(SignProvider.FACEBOOK, SignProvider.parse("facebook.com"));
        assertEquals(SignProvider.NONE, SignProvider.parse("anonymous"));
        assertEquals(SignProvider.ADMIN, SignProvider.parse("admin"));
        assertEquals(SignProvider.GOOGLE, SignProvider.parse("google.com"));
        assertEquals(SignProvider.TWITTER, SignProvider.parse("twitter.com"));
        assertEquals(SignProvider.PASSWORD, SignProvider.parse("password"));
        assertEquals(SignProvider.NONE, SignProvider.parse(null));

    }
}