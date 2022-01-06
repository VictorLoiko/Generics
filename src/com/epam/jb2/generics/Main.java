package com.epam.jb2.generics;

import com.epam.jb2.generics.entity.MyList;
import com.epam.jb2.generics.entity.implementation.MyArrayList;
import org.omg.CORBA.Object;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~ Validating creation ~~~~~~~~~~~");
        MyList<Integer> myList = new MyArrayList<>();
        System.out.println(myList);
        System.out.println("~~~~~~~~~~~ Validating add ~~~~~~~~~~~");
        myList.add(2);
        myList.add(4);
        System.out.println(myList);
        myList.add(4);
        System.out.println(myList);
        System.out.println("~~~~~~~~~~~ Validating add with index ~~~~~~~~~~~");
        myList.add(1,0);
        myList.add(1,-2);
        System.out.println(myList);
        System.out.println("~~~~~~~~~~~ Validating remove with index ~~~~~~~~~~~");
        myList.remove(1);
        System.out.println(myList);
        System.out.println("~~~~~~~~~~~ Validating remove  ~~~~~~~~~~~");
        myList.remove();
        System.out.println(myList);
        System.out.println("~~~~~~~~~~~ Validating index Exception  ~~~~~~~~~~~");
        try{
            myList.remove(5);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("~~~~~~~~~~~ Validating sort  ~~~~~~~~~~~");
        myList.add(1);
        myList.sort();
        System.out.println(myList);

        System.out.println("~~~~~~~~~~~ Validating sort with comparator  ~~~~~~~~~~~");
        System.out.println(myList);
        myList.sort((o1, o2) -> o2-o1);
        System.out.println(myList);
    }
}
