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

    Passenger[] data;
    int size = 0;
    int head = 1;

    private int parentOf(int p)
    {
        return p / 2;
    }

    private int leftOf(int p)
    {
        return 2 * p;
    }

    private int rightOf(int p)
    {
        return 2 * p + 1;
    }


    public PersonHeap(int capacity)
    {
        data = new Passenger[capacity];
    }

    private void swap(int n, int m)
    {
        System.out.println("swapping " + n +  " with " + m);
        data[0] = data[m];
        data[m] = data[n];
        data[n] = data[0];
    }

    @Override
    public void enqueue(Passenger person)
    {
        size++;
        data[size] = person;
  
        System.out.println("data: 1,2,3 --- 1: " + data[1]+" 2: "+data[2]+" 3: "+data[3] + " -----");
        heapingUp(size); 
      
    }

    public void heapingUp(int p)
    {
        if (p == 1) {
            return;
        }
        int pp = parentOf(p);
        if (data[p] == null || data[pp] == null) {
            System.out.println("en af os er null");
        }
        if (data[pp] == null) {
            return;
        }
        if (data[p].compareTo(data[pp]) >= 0) {
            return;
        }
        swap(p, pp);
        p = pp;
        heapingUp(p);
    }

    public void heapingDown(int index)
    {
        if (data[leftOf(index)] == null && data[rightOf(index)] == null) {
            return;
        }
        else if(data[leftOf(index)] == null)
        {   
            if (data[index].compareTo(data[rightOf(index)])<=0) {
                return;
            }
            swap(index, rightOf(index));
            return;
        }
        else if (data[rightOf(index)] == null) {
            if (data[index].compareTo(data[leftOf(index)])<=0) {
                return;
            }
            swap(index, leftOf(index));
            return; 
        }
        
        
        if (data[leftOf(index)].compareTo(data[rightOf(index)]) <= 0) {
            //leftOf is chosen
            if (data[index].compareTo(data[leftOf(index)])<=0) {
                return;
            }

            swap(index, leftOf(index));
            heapingDown(leftOf(index));
        }
        else {
            if (data[index].compareTo(data[rightOf(index)])<=0) {
                return;
            }
            
            swap(index, rightOf(index));
            heapingDown(rightOf(index));
        }
        

    }

    @Override
    public Passenger peek()
    {
        if (size == 0) {
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
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Passenger item = data[1];
        //System.out.println("data: 1,2,3 --- 1:8" + data[1]+" 2:"+data[2]+" 3:"+data[3] + " -----");
        if (item == null) {
            System.out.println("jeg er null gg");
        }
        //System.out.println("og Mit ID er" + item.getCategory());
        data[1] = null;
        
        swap(1,size);
        heapingDown(1);
        head = (head + 1);
        size--;
        return item;
    }
    public void showData()
    {
        for (int i = 0; i < 10; i++) {
            
        }
    }
}
