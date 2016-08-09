package com.znm.test.effective.builder.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by jiang.qi on 2016/8/2.
 */
public class Stack {

    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public Stack(){
        elements=new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++]=e;
    }

    public Object pop(Object e){
        if(size==0){
            throw new EmptyStackException();
        }
        //防止内存泄露
        elements[size]=null;
        return elements[size--];
    }

    private void ensureCapacity(){
        if(size==elements.length){
            elements= Arrays.copyOf(elements,size*2+1);
        }
    }
}
