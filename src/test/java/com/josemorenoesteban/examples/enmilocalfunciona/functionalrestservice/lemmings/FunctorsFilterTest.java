package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings;

import static com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Functions.filter;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import spark.Request;

import org.junit.Test;

public class FunctorsFilterTest {
    @Test
    public void canGetTheFilter() {
        final Request request = mock(Request.class);
        when(request.queryParams("q")).thenReturn("basher");
        assertEquals( "basher", filter.apply(request).get() );
    }
    
    @Test
    public void filterParameterIsEmpty() {
        final Request request = mock(Request.class);
        when(request.queryParams("q")).thenReturn(null);
        assertFalse( filter.apply(request).isPresent() );
    }

    public void noFilterParameter() {
        final Request request = mock(Request.class);
        assertFalse( filter.apply(request).isPresent() );
    }
}
