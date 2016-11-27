package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice;

import static com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Lemming.lemmings;

import static spark.Spark.port;

import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

import com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.Lemming;
import com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings.LemmingsResource;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class Main {
    public static final int DEFAULT_HTTP_PORT = 8080;
    
    private Main(final Function<Optional<String>, Optional<Lemming>> getLemming, 
                 final Function<Optional<String>, List<Lemming>>     findLemming) {
        port(DEFAULT_HTTP_PORT);
        new LemmingsResource( getLemming, findLemming );
    }
    
    public static void main(String...args) {
        new Main( getLemming, findLemmings );
    }
    
    private static final Function<Optional<String>, Optional<Lemming>> getLemming = (id) -> {
        if ( !id.isPresent() ) {
            return empty();
        }
        return lemmings().stream()
               .filter( lemming -> Objects.equals(lemming.name(), id.get()) )
               .findFirst(); 
    };

    private static final Function<Optional<String>, List<Lemming>> findLemmings = (filter) -> { 
        return lemmings().stream()
               .filter( lemming -> filter.isPresent() ? lemming.name().contains(filter.get()) : true )
               .collect( toList() ); 
    }; 
}
