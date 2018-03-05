package com.learning.datastructures;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.NoSuchElementException;
public class LRUDoublyLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;
    private static int THRESHOLD=3;

    public LRUDoublyLinkedList() {
        size = 0;
    }


    /**
     * returns the size of the linked list
     * @return
     */
    public int size() { return size; }

    /**
     * return whether the list is empty or not
     * @return
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * adds element at the starting of the linked list
     * @param element
     */
    public void addFirst(String url, String element) {


        Node tmp = new Node(url,element, head, null);
        if(head != null ) {
            head.prev = tmp;
            head = tmp;
        }else{
            head = tmp;
        }

        if(tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("adding: "+element);
    }

    public void addFirst(Node newNode) {

        if(head != null ) {
            head.prev = newNode;
            head = newNode;
        }else{
            head = newNode;
        }

        if(tail == null) {
            tail = newNode;
        }
        size++;

    }


    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public String removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+tmp.cacheContent);
        return tmp.cacheContent;
    }


    public Node findNReplaceNode(String url){
        Node tmp = head;
        while(tmp != null){
            if(tmp.url ==url){
                //remove node and add at first
                removeNode(tmp);
                break;
            }
            System.out.println(tmp.cacheContent);
            tmp = tmp.next;
        }
        return null;
    }

    public void removeNode(Node currentNode){
        if(currentNode==tail){
            removeLast();
            Node node = new Node(currentNode.url,currentNode.cacheContent,head,null);
            addFirst(node);
        }
        else if(currentNode==head){
            //do nothing
        }
        else {
            Node prevNode = currentNode.prev;
            Node nextNode = currentNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
            Node tempNode = new Node(currentNode.url,currentNode.cacheContent,head,null);
            addFirst(tempNode);
        }
    }


   public void insertIntoCache(String url){
       if(findNode(url)==null){
          String content =getDataForUrl(url);
           if(size==THRESHOLD) {
               removeLast();
           }
               addFirst(url,content);
       }else{
           findNReplaceNode(url);
       }



    }

    private String getDataForUrl(String url) {
        //assumption retrives the content and returns in required format
        //dummy data
        return RandomStringUtils.random(100);
    }

    public Node findNode(String url){

        Node tmp = head;
        while(tmp != null){
            if(tmp.url ==url){
                //remove node and add at first
               return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }


    @Test
    public void insertTest(){
        this.insertIntoCache("google.com/1");
        this.insertIntoCache("google.com/2");
        this.insertIntoCache("google.com/3");
        this.insertIntoCache("google.com/2");
        this.insertIntoCache("google.com/4");
//        this.insertIntoCache("google.com/2");
//        this.insertIntoCache("google.com/3");
//        this.insertIntoCache("google.com/4");
//        this.insertIntoCache("google.com/1");
//        this.insertIntoCache("google.com/2");
//        this.insertIntoCache("google.com/1");
       this.insertIntoCache("google.com/4");
        this.insertIntoCache("google.com/3");
        this.insertIntoCache("google.com/5");


    }




}