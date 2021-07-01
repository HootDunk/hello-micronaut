package com.broker;


import com.broker.error.CustomError;
import com.broker.model.Quote;
import com.broker.store.InMemoryStore;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.Optional;

@Controller("/quotes")
public class QuotesController {
    private final InMemoryStore store;

    public QuotesController(final InMemoryStore store) {
        this.store = store;
    }

    // passing the symbol as a path parameter
    @Get("/{symbol}")
    public HttpResponse getQuotes(@PathVariable String symbol){
        final Optional<Quote> maybeQuote = store.fetchQuote(symbol);
        if (maybeQuote.isEmpty()){
            final CustomError notFound = CustomError.builder()
                    .status(HttpStatus.NOT_FOUND.getCode())
                    .error(HttpStatus.NOT_FOUND.name())
                    .message("Quote not available")
                    .path("/quotes/" + symbol)
                    .build();

            return HttpResponse.notFound(notFound);
        }
        // .ok() gives http response status 200
        return HttpResponse.ok(maybeQuote.get());
    }
}
