package com.broker.account;


import com.broker.model.WatchList;
import com.broker.store.InMemoryAccountStore;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Controller("/account/watchlist")
public class WatchListController {

    private static final Logger LOG = LoggerFactory.getLogger(WatchListController.class);

    // a static UUID for testing purposes
    public static final UUID ACCOUNT_ID = UUID.randomUUID();

    private final InMemoryAccountStore store;

    public WatchListController(final InMemoryAccountStore store) {
        this.store = store;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public WatchList get() {
        LOG.debug("getWatchList - {}", Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        return store.getWatchList(ACCOUNT_ID);
    }

    // application json is the default media type so you don't hace to include it
    @Put(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public WatchList update(@Body WatchList watchList){
        return store.updateWatchList(ACCOUNT_ID, watchList);
    }

    @Delete(
            value = "/{accountId}"
    )
    public void delete (@PathVariable UUID accountId) {
        store.deleteWatchList(accountId);
    }
}
