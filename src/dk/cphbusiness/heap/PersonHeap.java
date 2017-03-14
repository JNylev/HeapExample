/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.heap;

import java.util.NoSuchElementException;

import dk.cphbusiness.airport.template.Passenger;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueue;
/**
 *
 * @author jakob
 */
public class PersonHeap implements PriorityQueue<Passenger>
{
    private Passenger[] data; 
    private int size=0;
    private int head=1;
    private int parentOf(int p){return p/2;}
    private int leftOf(int p){return 2*p;}
    private int rightOf(int p){return 2*p+1;}
    private int tail = 0;
    public PersonHeap(int capacity)
    {
        data = new Passenger[capacity];
    }
    
    
    
    
    private void swap(int n, int m)
    {
        data[0]=data[m];
        data[m]=data[n];
        data[n]=data[0];
    }
    
    @Override
    public void enqueue(Passenger person)
    {
        int p =++size;
        data[p] = person;
        System.out.println("p ="+p+ " og size er "+ size);
        size++;
        heaping(p);
//        if (p==1) {
//            return;
//        }
//        int pp = parentOf(p);
//        if (data[p]==null||data[pp] == null) {
//            System.out.println("en af os er null");
//        }
//        if (data[pp]==null) {
//            return;
//        }
//        if (data[p].compareTo(data[pp])>=0)
//        {
//            return;
//        }
//        tail = (tail + 1) % data.length;
//        swap(p,pp);
//        p=pp;
                
    }
    public void heaping(int p)
    {
        if (p==1) {
            return;
        }
        int pp = parentOf(p);
        if (data[p]==null||data[pp] == null) {
            System.out.println("en af os er null");
        }
        if (data[pp]==null) {
            return;
        }
        if (data[p].compareTo(data[pp])>=0)
        {
            return;
        }
        tail = (tail + 1) % data.length;
        swap(p,pp);
        p=pp;
        heaping(p);
    }
    
    
    
    
    @Override
    public Passenger peek()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return data[head];
    }

    @Override
    public int size()
    {
        return size;
    }
    @Override
    
    public Passenger dequeue()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Passenger item = data[1];
        System.out.println( "head er" + head);
        if (item==null) {
            System.out.println("jeg er null gg");
        }
        System.out.println("og Mit ID er" + item.getId() );
        data[head] = null;
        head = (head + 1);
        size--;
        return item;
    }
}
