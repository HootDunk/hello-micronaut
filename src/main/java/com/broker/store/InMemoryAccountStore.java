package com.broker.store;

import com.broker.model.WatchList;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.UUID;

@Singleton
public class InMemoryAccountStore {

    private final HashMap<UUID, WatchList> watchListsPerAccount = new HashMap<>();


    public WatchList getWatchList(final UUID accountId) {
        // returns hashmap for accountId or an empy watchlist object if it doesn't exist
        return watchListsPerAccount.getOrDefault(accountId, new WatchList());
    }

    public WatchList updateWatchList(UUID accountId, WatchList watchList) {
        watchListsPerAccount.put(accountId, watchList);
        return getWatchList(accountId);
    }

    public void deleteWatchList(UUID accountId) {
        watchListsPerAccount.remove(accountId);
    }
}
