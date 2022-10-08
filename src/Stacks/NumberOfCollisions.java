package Stacks;

import java.util.Stack;

//There are n cars on an infinitely long road. The cars are numbered from 0 to n - 1 from left to right and each car
// is present at a unique point.
//
//You are given a 0-indexed string directions of length n. directions[i] can be either 'L', 'R', or 'S'
// denoting whether the ith car is moving towards the left, towards the right, or staying at its current point
// respectively. Each moving car has the same speed.
//
//The number of collisions can be calculated as follows:
//
//When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
//When a moving car collides with a stationary car, the number of collisions increases by 1.
//After a collision, the cars involved can no longer move and will stay at the point where they collided.
// Other than that, cars cannot change their state or direction of motion.
//
//Return the total number of collisions that will happen on the road.
public class NumberOfCollisions {

    public static void main(String args[]) {
        int arr[] = new int[]{10, 4, 5, 90, 120, 80};
        int n = arr.length;

        String s = "LLRLRLLSLRLLSLSSSS";

        System.out.println(findCollisions(s));
    }

    public static int findCollisions(String s) {
        int n = s.length();
        if (n <= 1)
            return 0;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(s.charAt(i));
        }
        int temp =0;
        char curr = st.pop();
        int no_of_collisions = 0;
        while (!st.isEmpty()) {

            // as we are starting from the right and the rightmost car is moving to the right then there
            // will be no collisions
            if (curr == 'R') {
                curr = st.pop();
            }

            // if current car is sationary and there is a car coming from right then only collisions are possible
            // as we are starting from right, in other cases no collision will be there
            // we do not update current as the stationary car will not move anywhere
            if (curr == 'S') {
                if (st.peek() == 'R') {
                    no_of_collisions += 1;
                    st.pop();
                } else {
                    curr = st.pop();
                }
            }

            // if car is moving left from right side
            if (curr == 'L') {
                //if car moving left from right meets a car moving in the opposite directions
                // then collision will increase by 2 and if it meets a stationary car
                // collisions will increase by 1
                // Here temp variable stores any cars encountered before which are
                // travelling in same direction as car involved in accident
                // so if this current car meets with accident they will also meet with accident
                //After the accident current is made as stationary as after accident cars will become stationary only
                if (st.peek() == 'R') {
                    no_of_collisions = no_of_collisions + temp + 2;
                    // once the cars of temp have been accounted for temp is again ste to 0
                    temp = 0;
                    st.pop();
                    curr = 'S';
                } else if (st.peek() == 'S') {
                    no_of_collisions = no_of_collisions + temp + 1;
                    temp = 0;
                    st.pop();
                    curr = 'S';
                } else {
                    temp++;
                    curr = st.pop();
                }
            }
//
//        }
//        int no_of_collisions = 0;
//        int curr = s.charAt(n-1);
//        int temp = 0;
//        for (int i = n-2; i >=0 ; i--) {
//            if (curr == 'R') {
//                curr = s.charAt(i);
//            }
//
//            // if current car is sationary and there is a car coming from right then only collisions are possible
//            // as we are starting from right, in other cases no collision will be there
//            // we do not update current as the stationary car will not move anywhere
//            if ( curr == 'S') {
//                if (i>=0 && s.charAt(i) == 'R') {
//                    no_of_collisions += 1;
//                    i--;
//                } else {
//                    curr = s.charAt(i--);
//                }
//            }
//
//            // if car is moving left from right side
//            if (curr == 'L') {
//                //if car moving left from right meets a car moving in the opposite directions
//                // then collision will increase by 2 and if it meets a stationary car
//                // collisions will increase by 1
//                // Here temp variable stores any cars encountered before which are
//                // travelling in same direction as car involved in accident
//                // so if this current car meets with accident they will also meet with accident
//                //After the accident current is made as stationary as after accident cars will become stationary only
//                if (i>=0 && s.charAt(i) == 'R') {
//                    no_of_collisions = no_of_collisions + temp+ 2;
//                    // once the cars of temp have been accounted for temp is again ste to 0
//                    temp = 0;
//                    i--;
//                    curr = 'S';
//                } else if (i>=0 && s.charAt(i) == 'S') {
//                    no_of_collisions = no_of_collisions+temp+1;
//                    temp = 0;
//                    i--;
//                    curr = 'S';
//                } else if(i>=0) {
//                    temp++;
//                    curr = s.charAt(i);
//                }
//            }
//        }
        }
        return no_of_collisions;

    }
}
