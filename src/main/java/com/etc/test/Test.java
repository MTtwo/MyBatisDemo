package com.etc.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("one");
        list.add("two");
        list.add("one");
        for (String s : list){
            if ("two".equals(s)){
                list.remove(s);
                break;
            }
        }
        for (String a:list){
            System.out.println(a);
        }

    }
}
