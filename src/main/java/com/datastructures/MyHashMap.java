package com.datastructures;

public class MyHashMap<K,V> {
    MyLinkedList<K> myLinkedList ;

    public MyHashMap(){
        this.myLinkedList=new MyLinkedList<>();
    }
    //method to get value of node having given key
    public V get(K key) {
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }
    //method to add key and value to hashmap node
    public void add(K key, V value) {
        MyMapNode<K,V> myMapNode= (MyMapNode<K, V>) myLinkedList.search(key);
        if(myMapNode == null) {
            myMapNode=new MyMapNode<>(key,value);
            this.myLinkedList.append(myMapNode);
        }else{
            myMapNode.setValue(value);
        }
    }
    @Override
    public String toString() {
        return "MyHashMapNodes{"+myLinkedList+'}';
    }
}
