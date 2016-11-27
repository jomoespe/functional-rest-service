package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings;

import static com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Functions.lemmingId;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import spark.Request;

import org.junit.Test;

public class FunctorsLemingsIdTest {
    @Test
    public void canTheLemmingId() {
        final Request request = mock(Request.class);
        when(request.params("id")).thenReturn("basher");
        assertEquals("basher", lemmingId.apply(request).get());
    }
    
    @Test
    public void thereIsNoLemmingIdInRequest() {
        final Request request = mock(Request.class);
        when(request.queryParams("id")).thenReturn(null);
        assertFalse( lemmingId.apply(request).isPresent() );
    }

    @Test
    public void LemmingIdRequestParameterDoesNotExist() {
        final Request request = mock(Request.class);
        assertFalse( lemmingId.apply(request).isPresent() );
    }
}
