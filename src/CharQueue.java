/*
    Name: TODO
    PID:  TODO
 */

import java.util.NoSuchElementException;

/**
 * TODO
 *
 * @author Eli Nalebuff
 * @since 2023.10.20
 */

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    //Added size as an instance variable
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;

    private int size;
    //initiated the queue of length 5
    public CharQueue() {
        circularArray = new char[5];
        length = 5;
    }
    // initiate the queue of given length
    public CharQueue(int capacity) {
        if (capacity<1){
            throw new IllegalArgumentException();
        }
        circularArray = new char[capacity];
        length = capacity;

    }
    // returns true if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    //returns the size of the queue
    public int size() {

        return size;
    }
    //clears the array
    public void clear() {
        circularArray = new char[length];
        size = 0;
        front = 0;
        rear = 0;

    }
//if the queue is full, it will create a new queue of 2x length and reset pointers to
    //0 and length.
    public void enqueue(char elem) {

        size++;
        if (size>length){

            char[] temp = new char[length*2];

            for(int i = 0; i<length; i++){
                temp[i] = circularArray[(front+i) % length];

            }
            front = 0;
            rear = length;
            circularArray = temp;
            length = length *2;



        }
        circularArray[rear] = elem;
        rear = (rear+1) % length;
    }
// if array is not empty, it will return the front character
    public char peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        return circularArray[front];
    }
//If array is not empty, it will return the first element, and move the first pointer
    public char dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        size = size-1;
        char output = circularArray[front];
        front = (front+1)%length;
        return output;
    }
}
