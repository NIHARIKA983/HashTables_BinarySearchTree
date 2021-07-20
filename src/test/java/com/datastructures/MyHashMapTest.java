package com.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {
    //UC1
    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
        String sentence = "To be or not to be";
        MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words){
            Integer value = myHashMap.get(word);
            if(value == null) value=1;
            else value=value+1;
            myHashMap.add(word,value);
        }
        int frequency = myHashMap.get("to");
        System.out.println(myHashMap);
        Assert.assertEquals(2,frequency);
    }
    //UC2

    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturnParanoidFrequency() {
        String sentence = "Paranoids are not paranoid because they are paranoid but because " +
                "they keep putting themselves deliberately into paranoid avoidable situations";
        MyLinkedHashMap<String,Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words){
            Integer value = myLinkedHashMap.get(word);
            if(value == null) value=1;
            else value=value+1;
            myLinkedHashMap.add(word,value);
        }
        int frequency = myLinkedHashMap.get("paranoid");
        System.out.println(myLinkedHashMap);
        Assert.assertEquals(3,frequency);
    }
    
    //UC3

    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldBeAbleTo_RemoveGivenWordFromList() {
        String sentence = "Paranoids are not paranoid because they are paranoid but because " +
                "they keep putting themselves deliberately into paranoid avoidable situations";
        MyLinkedHashMap<String,Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words){
            Integer value = myLinkedHashMap.get(word);
            if(value == null) value=1;
            else value=value+1;
            myLinkedHashMap.add(word,value);
        }
        System.out.println("Before Deletion:\n"+myLinkedHashMap);
        INode removedNode = myLinkedHashMap.remove("avoidable");
        System.out.println("After Deletion :\n"+myLinkedHashMap);
        Assert.assertEquals("avoidable",removedNode.getKey());
    }
}
