package com.example.broker.account;


import com.broker.account.WatchListControllerReactive;
import com.broker.model.Symbol;
import com.broker.model.WatchList;
import com.broker.store.InMemoryAccountStore;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.micronaut.http.HttpRequest.*;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class WatchListControllerReactiveTest {

    private static final Logger LOG = LoggerFactory.getLogger(WatchListControllerReactiveTest.class);
    private static final UUID TEST_ACCOUNT_ID = WatchListControllerReactive.ACCOUNT_ID;


    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/account/watchlist-reactive")
    RxHttpClient client;

    @Inject
    InMemoryAccountStore store;

//    @Test
//    void returnsEmptyWatchListForAccount() {
//        final Single<WatchList> result = client.retrieve(GET("/"), WatchList.class).singleOrError();
//        // Single contains .blockingGet() which can return the element for the test
//        assertTrue(result.blockingGet().getSymbols().isEmpty());
//        assertTrue(store.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());
//    }
//
//    @Test
//    void returnsEmptyWatchListForAccountAsSingle() {
//        final Single<WatchList> result = client.retrieve(GET("/"), WatchList.class).singleOrError();
//        // Single contains .blockingGet() which can return the element for the test
//        assertTrue(result.blockingGet().getSymbols().isEmpty());
//        assertTrue(store.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());
//    }
//
//    @Test
//    void returnsWatchListForAccount() {
//        final List<Symbol> symbols = Stream.of("APPL", "AMZN", "NFLX")
//                .map(Symbol::new)
//                .collect(Collectors.toList());
//        WatchList watchList = new WatchList(symbols);
//        store.updateWatchList(TEST_ACCOUNT_ID, watchList);
//
//        final WatchList result = client.toBlocking().retrieve("/", WatchList.class);
//        assertEquals(3, result.getSymbols().size());
//        assertEquals(3, store.getWatchList(TEST_ACCOUNT_ID).getSymbols().size());
//    }
//
//    @Test
//    void canUpdateWatchListForAccount() {
//        final List<Symbol> symbols = Stream.of("APPL", "AMZN", "NFLX")
//                .map(Symbol::new)
//                .collect(Collectors.toList());
//        WatchList watchList = new WatchList(symbols);
//
//        final HttpResponse<Object> added = client.toBlocking().exchange(PUT("/", watchList));
//        // ensure http response is ok
//        assertEquals(HttpStatus.OK, added.getStatus());
//        // test new object is in the store
//        assertEquals(watchList, store.getWatchList(TEST_ACCOUNT_ID));
//    }
//
//    @Test
//    void canDeleteWatchListForAccount() {
//        final List<Symbol> symbols = Stream.of("APPL", "AMZN", "NFLX")
//                .map(Symbol::new)
//                .collect(Collectors.toList());
//        WatchList watchList = new WatchList(symbols);
//        store.updateWatchList(TEST_ACCOUNT_ID, watchList);
//        // ensure watchlist is not empty
//        assertFalse(store.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());
//
//        final HttpResponse<Object> deleted = client.toBlocking().exchange(DELETE("/" + TEST_ACCOUNT_ID));
//        // ensure http response is ok
//        assertEquals(HttpStatus.OK, deleted.getStatus());
//        // test new object is in the store
//        assertTrue(store.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());
//    }


}
