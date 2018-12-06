package com.cyb.test.mytest.javatest.collection;

import com.ibm.icu.impl.Punycode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chaoyongbing on 2017/12/1 10:31.
 */

public class CollectionTest {

    @Test
    public void testList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("00");
        arrayList.add("11");
        arrayList.get(1);
        print(arrayList);

        Vector<String> vector = new Vector<>();
        vector.add("000");
        vector.add("000");
        print(vector);


        Stack<String> stack = new Stack<>();
        stack.push("0");
        stack.push("1");
//        stack.pop();
        stack.peek();
        print(stack);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0");
        linkedList.addFirst("1");
        linkedList.addLast("2");
        linkedList.get(1);//分开两段去遍历
        print(linkedList);

    }




    public void testLinkedHashMap(){
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("a",1);
    }


    @Test
    public void testQueue() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(999);
        arrayDeque.add("sss");
        print(arrayDeque);
    }

    @Test
    public void testMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("a", "1");
        hashMap.put("b", "2");

        printMap(hashMap);
        guyiyichang(hashMap);

//        Hashtable hashtable = new Hashtable();
//        hashtable.put(33, 33);
//        hashtable.put(null, null);
//        printMap(hashtable);


//        WeakHashMap weakHashMap = new WeakHashMap();
//        weakHashMap.put();
    }


    @Test
    public void testSet() {
        HashSet<String> set = new HashSet<>();

        set.add("1");
        set.add("0");
        set.add("0");

        set.remove("2");
        set.contains("0");
        print(set);


        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("1");
        linkedHashSet.add("0");
        print(linkedHashSet);

        //插入保证有序
        TreeSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("1100");
        sortedSet.add("00");
        print(sortedSet);


        EnumSet<Color> enumSet = EnumSet.of(Color.BLUE);
    }

    public enum Color {
        BLUE
    }

    public void print(Collection collection) {
        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("---------------");
    }


    public void printMap(Map map) {
        Set<Map.Entry> set = map.entrySet();

        Iterator<Map.Entry> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.err.println(entry.getKey() + ":" + entry.getValue());
        }

//        map.keySet();
//
//        Collection collection = map.values();
//        collection.iterator();

    }


    @Test
    public void testConcurrent(){

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","a");
        concurrentHashMap.put("2","b");
        concurrentHashMap.put("3","c");

        printMap(concurrentHashMap);
        guyiyichang(concurrentHashMap);
    }


    private void guyiyichang(Map map){
        Set<Map.Entry> set = map.entrySet();

        Iterator<Map.Entry> iterator = set.iterator();
        while (iterator.hasNext()) {
//            map.put("aaaa",111111);
            Map.Entry entry = iterator.next();
            System.err.println(entry.getKey() + ":" + entry.getValue());
//            iterator.remove();
//            map.put("aaaa1",111111);
        }
        map.put("aaaa1",111111);
        iterator = set.iterator();
        while (iterator.hasNext()) {
//            map.put("aaaa",111111);
            Map.Entry entry = iterator.next();
            System.err.println(entry.getKey() + ":" + entry.getValue());
            iterator.remove();
//            map.put("aaaa1",111111);
        }
    }
}
