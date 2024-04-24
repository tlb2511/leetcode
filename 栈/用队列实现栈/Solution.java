package 栈.用队列实现栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class MyStack {
    Deque<Integer> q1;
    Deque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();

    }

    public void push(int x) {
        q1.addLast(x);
    }

    public int pop() {
        while(q1.size() > 1){
            int top = q1.removeFirst();
            q2.addLast(top);
        }
        int ans = q1.removeFirst();
        q1.addAll(q2);
        q2.clear();
        return ans;
    }

    public int top() {
        while(q1.size() > 1){
            int top = q1.removeFirst();
            q2.addLast(top);
        }
        int ans = q1.removeFirst();
        q2.addLast(ans);
        q1.addAll(q2);
        q2.clear();
        return ans;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
