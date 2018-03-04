package com.learning.datastructures;
public class Node {
    String url;
    String cacheContent;
    Node next;
    Node prev;

    public Node(String url, String cacheContent, Node next, Node prev) {
        this.url = url;
        this.cacheContent = cacheContent;
        this.next = next;
        this.prev = prev;
    }
}