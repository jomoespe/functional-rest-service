package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings;

import static com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Functions.toJson;
import static com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Lemming.*;

import static org.junit.Assert.*;

import static java.util.Optional.of;

import javax.json.JsonObject;

import org.junit.Test;

public class FunctorsToJsonTest {
    @Test
    public void canGetTheFilter() {
        JsonObject json = toJson.apply( of(basher()) );
        assertNotNull( json );
        assertEquals( basher().name(),             json.getString("name") );
        assertEquals( basher().isPermanentSkill(), json.getBoolean("isPermanentSkill") );
    }
}
