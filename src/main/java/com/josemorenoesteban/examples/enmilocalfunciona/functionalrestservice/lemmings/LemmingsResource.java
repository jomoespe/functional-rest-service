package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings;

import static com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Functions.*;

import static spark.Spark.path;
import static spark.Spark.get;
import static spark.Spark.exception;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class LemmingsResource {
    public LemmingsResource(final Function<Optional<String>, Optional<Lemming>> getLemming,
                            final Function<Optional<String>, List<Lemming>>     findLemmings) {
        exception(RuntimeException.class, (exception, req, res) -> {
            res.status(404);
        });
        path("/api/v1", () -> {
            get("/lemmings",     (req, res) -> toJsonArray.compose(findLemmings).compose(filter).apply(req) );
            get("/lemmings/:id", (req, res) -> toJson.compose(getLemming).compose(lemmingId).apply(req) );
        });
    }
}
