package com.broker.account;

import com.broker.model.WatchList;
import com.broker.store.InMemoryAccountStore;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Flowable;
import io.reactivex.Single;

import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Controller("/account/watchlist-reactive")
public class WatchListControllerReactive {
    private static final Logger LOG = LoggerFactory.getLogger(WatchListControllerReactive.class);
    // a static UUID for testing purposes
    public static final UUID ACCOUNT_ID = UUID.randomUUID();

    private final InMemoryAccountStore store;
    private final io.reactivex.Scheduler scheduler;
    public WatchListControllerReactive(
            @Named(TaskExecutors.IO) ExecutorService executorService,
            final InMemoryAccountStore store) {
        this.store = store;
        this.scheduler = Schedulers.from(executorService);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    @ExecuteOn(TaskExecutors.IO) // predefined thread-pool to handle blocking operations
    public WatchList get() {
        System.out.println(Thread.currentThread().getName());
        // Logger not printing to console for some reason...
        LOG.debug("getWatchList = {}", Thread.currentThread().getName());
        return store.getWatchList(ACCOUNT_ID);
    }

    @Get(
            value = "/single",
            produces = MediaType.APPLICATION_JSON
    )
    public Flowable<WatchList> getAsSingle() {
        return Single.fromCallable(() -> {
            LOG.debug("getAsSingle = {}", Thread.currentThread().getName());
            return store.getWatchList(ACCOUNT_ID);
        }).toFlowable().subscribeOn(scheduler);
    }

    // application json is the default media type so you don't hace to include it
    @Put(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    @ExecuteOn(TaskExecutors.IO)
    public WatchList update(@Body WatchList watchList){
        return store.updateWatchList(ACCOUNT_ID, watchList);
    }

    @Delete(
            value = "/{accountId}"
    )
    @ExecuteOn(TaskExecutors.IO)
    public void delete (@PathVariable UUID accountId) {
        store.deleteWatchList(accountId);
    }
}
