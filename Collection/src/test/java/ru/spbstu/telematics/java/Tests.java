package ru.spbstu.telematics.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.assertEquals;

public class Tests
{
    @Test
    /*Проверка на правильность добавления*/
    public void ArListTest()
    {
        ArList<Integer> myList = new ArList<Integer>(5);
        ArrayList<Integer> javaList = new ArrayList<Integer>(5);

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        javaList.add(1);
        javaList.add(2);
        javaList.add(3);
        javaList.add(4);
        javaList.add(5);

        assertEquals("Add to tail failed", myList, javaList);

        myList.add(0,0);
        javaList.add(0,0);

        assertEquals("Add to index 0 failed", myList, javaList);

        myList.add(myList.size(),6);
        javaList.add(javaList.size(),6);

        assertEquals("Add to last index failed", myList, javaList);

        myList.add(3,7);
        javaList.add(3,7);

        assertEquals("Add to inner index failed", myList, javaList);

        myList.remove(myList.size() - 1);
        myList.remove(myList.size() - 1);

        javaList.remove(javaList.size() - 1);
        javaList.remove(javaList.size() - 1);

        assertEquals("Remove last element failed", myList, javaList);

        myList.remove((Object) 2);
        javaList.remove((Object) 2);

        assertEquals("Remove object \"2\" failed", myList, javaList);

        assertEquals("\"get(4)\" failed", myList.get(4), javaList.get(4));
        assertEquals("\"get(0)\" failed", myList.get(0), javaList.get(0));
        assertEquals("\"contains(7)\" failed", myList.contains(7), javaList.contains(7));
    }

    @Test
    public void IteratorTest()
    {
        ArList<Integer> myList = new ArList<Integer>(5);
        ArrayList<Integer> javaList = new ArrayList<Integer>(5);

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        javaList.add(1);
        javaList.add(2);
        javaList.add(3);
        javaList.add(4);
        javaList.add(5);

        ListIterator<Integer> myIterator = myList.iterator();
        ListIterator<Integer> javaIterator = javaList.listIterator();

        assertEquals("Previous index 1 failed", myIterator.previousIndex(), javaIterator.previousIndex());
        assertEquals("Next index 1 failed", myIterator.nextIndex(), javaIterator.nextIndex());

        assertEquals("\"hasPrev() (index = 0)\" failed", myIterator.hasPrevious(), javaIterator.hasPrevious());

        while (myIterator.hasNext() && javaIterator.hasNext())
            assertEquals("Bypass list by iterator failed", myIterator.next(), javaIterator.next());

        assertEquals("\"hasNext() (index = size - 1)\" failed", myIterator.hasNext(), javaIterator.hasNext());
        assertEquals("Previous index 2 failed", myIterator.previousIndex(), javaIterator.previousIndex());
        assertEquals("Next index 2 failed", myIterator.nextIndex(), javaIterator.nextIndex());
    }
}
