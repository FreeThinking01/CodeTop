package com.cs.CodeTop;

import java.util.HashMap;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-03 11:44
 * @description: 自定义HashMap
 **/
public class DiyHashMap {

    public static void main(String[] args) {
        DiyHashMap map = new DiyHashMap();
        for (int i = 0; i < 10; i++) {
            map.put(i, i * 10);
        }
        for (int i = 9; i >= 0; i--) {
            System.out.println(map.get(i));
        }
    }

    static class Node{
        Integer key;
        Integer value;
        Node next;
        Node(Integer key, Integer value){
            this.value = value;
            this.key = key;
        }
    }

    Node[] table = null;
    private int capacity = 16;

    public DiyHashMap(int capacity) {
        this.capacity = capacity;
    }

    public DiyHashMap() {
        this(16);
    }

    private void initMap(){
        table = new Node[capacity];
    }

    public void put(Integer key, int value){
        if(table == null){
            initMap();
        }
        int index = key.hashCode() % capacity;

        if(table[index] == null){
            Node node = new Node(key, value);
            table[index] = node;
        }else{
            Node cur = table[index];
            while(cur.next != null){
                if(cur.key == key){
                    cur.value = value;
                }
            }
            if(cur.key == key){
                cur.value = value;
            }
            Node node = new Node(key, value);
            cur.next = node;
        }


    }

    public Integer get(Integer key){
        int index = key.hashCode() % capacity;
        if(table[index] == null){
            return null;
        }else{
            Node cur = table[index];
            while(cur != null){
                if(cur.key == key){
                    return cur.value;
                }
            }
        }
        return null;

    }

    private void resize(){

    }

}
