package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings;

import static java.util.Optional.ofNullable;
import static javax.json.Json.createObjectBuilder;

import spark.Request;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

class Functions {
    static final Function<Request, Optional<String>> filter = req -> ofNullable(req.queryParams("q"));
    
    static final Function<Request, Optional<String>> lemmingId = req -> ofNullable(req.params("id"));

    static final Function<Optional<Lemming>, JsonObject> toJson = lemming -> {
        Lemming lemmingFound = lemming.orElseThrow( () -> new RuntimeException("404") );
        return createObjectBuilder()
                .add("name",             lemmingFound.name())
                .add("isPermanentSkill", lemmingFound.isPermanentSkill())
                .add("description",      lemmingFound.description().orElse(""))
                .build();
    };

    static final Function<List<Lemming>, JsonArray> toJsonArray = requests ->
        requests.stream()
            .map( Optional::of )
            .map( toJson )
            .collect( Json::createArrayBuilder, (a, s) -> a.add(s), (b1, b2) -> b1.add(b2) )
            .build();
}
