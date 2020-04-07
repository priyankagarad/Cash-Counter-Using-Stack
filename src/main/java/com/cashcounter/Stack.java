package com.cashcounter;
import java.util.Scanner;
public class Stack                       //class created
{
        int size;
        int array[];
        int top;

        Stack(int size) {                   //created constructor and assign value to variable
            this.size = size;
            this.array = new int[size];
            this.top = -1;
        }
        public boolean isEmpty() {          //Stack is empty or not

            return (top == -1);
        }
        public boolean isFull() {             //stack is full or not

            return (size - 1 == top);
        }
        public void push(int pushValue) {     // push value in stack and top value incremented by one
            if (!isFull()) {
                top++;
                array[top] = pushValue;
                System.out.println("people in Queue" + pushValue);
            } else {
                System.out.println("stack is full");
            }
        }
        public void pop() {                     // pop value in stack and top value decremented by one
            if (!isEmpty()) {
                int returnedTop =array[top];
                top--;
                //array[top] = returnedTop;
                System.out.println("people go outside in queue" + returnedTop);
            } else {
                System.out.println("stack is empty");
            }
        }
        public static void main(String args[]) {                // main method
            System.out.println("welcome to Banking Cash Counter");
            /*
            created object of stack class for accessing method of class
            scanner class object created for taking value from user
            1.first ask how many people in line for cash withdraw or deposit
            2.then select choice if user want to 0)Deposit money then press 0
                                                  1)Withdraw money then press 1
             */
            Stack object = new Stack(2);
            Bank bank=new Bank();

            Scanner sc = new Scanner(System.in);
            System.out.println("how many people in queue");
            int peopleCount = sc.nextInt();

            while (peopleCount > 0) {
                peopleCount--;
                System.out.println("enter amount user want");
                int amountWant = sc.nextInt();

                System.out.println("ask for choice");
                System.out.println("0.Deposit money");
                System.out.println("1.withdraw money");
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        object.push(peopleCount);
                        bank.depositAmount(amountWant);
                        object.pop();
                        break;
                    case 1:
                        object.push(peopleCount);
                        bank.withdraw(amountWant);
                        object.pop();
                        break;
                    default:
                        System.out.println("invalid option");
                }
            }
        }
    }

