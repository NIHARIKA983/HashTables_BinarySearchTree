package com.datastructures;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
    private final int numBuckets;
    ArrayList<MyLinkedList<K>> myBucketArray;

    public MyLinkedHashMap() {
        this.numBuckets = 10;
        this.myBucketArray = new ArrayList<>(numBuckets);
        //create empty linked list
        for(int i=0 ; i<numBuckets ; i++)
            this.myBucketArray.add(null);
    }
    //method to get value of node for given key
    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) return null;
        MyMapNode<K,V> myMapNode= (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }
    //This implements hash function to find index for a key
    private int getBucketIndex(K key) {
        int hashcode = Math.abs(key.hashCode());
        int index = hashcode % numBuckets;
        System.out.println("Key :"+key+" hashcode :"+hashcode+" index :"+index);
        return index;
    }
    //method to add key,value to node in linkedList at found index
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index,myLinkedList);
        }
        MyMapNode<K,V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        if(myMapNode == null) {
            myMapNode=new MyMapNode<>(key,value);
            myLinkedList.append(myMapNode);
        }else{
            myMapNode.setValue(value);
        }
    }
    @Override
    public String toString() {
        return "MyLinkedHashMap List{"+myBucketArray+"}";
    }

    public INode remove(K deleteKey) {
        int index = this.getBucketIndex(deleteKey);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) return null;
        MyMapNode<K,V> previousNode = (MyMapNode<K, V>) myLinkedList.head;
        MyMapNode<K,V> currentNode = (MyMapNode<K, V>) myLinkedList.head;
        INode tempNode=null;
        if(currentNode != null && currentNode.getKey().equals(deleteKey)) {
            tempNode=currentNode;
            myLinkedList.head=currentNode.getNext();
            return tempNode;
        }
        while(currentNode != null && !(currentNode.getKey().equals(deleteKey))) {
            previousNode=currentNode;
            currentNode= (MyMapNode<K, V>) currentNode.getNext();
        }
        tempNode=currentNode;
        previousNode.setNext(currentNode.getNext());
        return tempNode;
    }
}
