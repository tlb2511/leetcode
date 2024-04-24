package 栈.用栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    class MyQueue {
        public Deque<Integer> sk1;
        public Deque<Integer> sk2;
        public MyQueue() {
            sk1 = new ArrayDeque<>();
            sk2 = new ArrayDeque<>();
        }

        public void push(int x) {
            sk1.addLast(x);
        }

        public int pop() {
            while(!sk1.isEmpty()){
                int i = sk1.removeLast();
                sk2.addLast(i);
            }
            int ans = sk2.removeLast();
            while(!sk2.isEmpty()){
                int i = sk2.removeLast();
                sk1.addLast(i);
            }
            return ans;
        }

        public int peek() {
            while(!sk1.isEmpty()){
                int i = sk1.removeLast();
                sk2.addLast(i);
            }
            int ans = sk2.getLast();
            while(!sk2.isEmpty()){
                int i = sk2.removeLast();
                sk1.addLast(i);
            }
            return ans;
        }

        public boolean empty() {
            return sk1.isEmpty();
        }
    }
}
