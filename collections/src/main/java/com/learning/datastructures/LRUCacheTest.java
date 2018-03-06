package com.learning.datastructures;

import org.junit.Test;

/**
 * Created by santoshk on 3/6/18.
 */
public class LRUCacheTest {

    LRUDoublyLinkedList lruCache = new LRUDoublyLinkedList();



    @Test
    public void insertTest(){
        lruCache.insertIntoCache("fakeurl.com/1");
        lruCache.insertIntoCache("fakeurl.com/2");
        lruCache.insertIntoCache("fakeurl.com/3");
        lruCache.insertIntoCache("fakeurl.com/2");
        lruCache.insertIntoCache("fakeurl.com/4");
        lruCache.insertIntoCache("fakeurl.com/2");
        lruCache.insertIntoCache("fakeurl.com/3");
        lruCache.insertIntoCache("fakeurl.com/4");
        lruCache.insertIntoCache("fakeurl.com/1");
        lruCache.insertIntoCache("fakeurl.com/2");
        lruCache.insertIntoCache("fakeurl.com/1");
        lruCache.insertIntoCache("fakeurl.com/4");
        lruCache.insertIntoCache("fakeurl.com/3");
        lruCache.insertIntoCache("fakeurl.com/5");
    }


}
