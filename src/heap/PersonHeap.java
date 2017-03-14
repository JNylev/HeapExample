/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author jakob
 */
public class PersonHeap implements PriorityQueue<Person>
{
    private Person[] data = new Person[capacity];
    private int size=0;
    
    private int parentOf(int p){return p/2;}
    private int leftOf(int p){return 2*p;}
    private int rightOf(int p){return 2*p+1;}
    private void swap(int n, int m)
    {
        data[0]=data[m];
        data[m]=data[n];
        data[n]=data[0];
    }
    
    @Override
    public void enqueue(Person person)
    {
        int p =++size;
        data[p] = person;
        int pp = parentOf(p);
        if (data[p].compareTo(data[pp])>0)
        {
            return;
        }
        swap(p,pp);
        p=pp;
                
    }
    @Override
    public Person dequeue()
    {
        if (size==0) throw new NoSuchElementException();
        Person result = data[1];
        
    }
}
