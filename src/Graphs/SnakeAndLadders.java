package Graphs;

import java.util.LinkedList;
import java.util.Queue;

//Given a snake and ladder board, find the minimum number of dice throws required to reach the
// destination or last cell from the source or 1st cell. Basically, the player has total control over the
// outcome of the dice throw and wants to find out the minimum number of throws required to reach the last cell.
//If the player reaches a cell which is the base of a ladder, the player has to climb up that ladder and if reaches
// a cell is the mouth of the snake, and has to go down to the tail of the snake without a dice throw.
public class SnakeAndLadders {

    public static void main(String[] args)
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[12] = 18;
        moves[3] = 19;
//        moves[10] = 25;
//        moves[19] = 28;
//
//        // Snakes
//        moves[26] = 0;
//        moves[20] = 8;
//        moves[16] = 3;
//        moves[18] = 6;

        System.out.println("Min Dice throws required is "
                + minThrows(moves, N));
    }

    static class Pair {
        int pos, moves;
        Pair(int pos) {
            this.pos = pos;
            moves = 0;
        }
    }
    static int minThrows(int move[], int n) {

        Queue<Pair> q = new LinkedList<>();
        Pair start = new Pair(1);
        q.add(start);

        while (!q.isEmpty()) {
            Pair temp = q.poll();

            if(temp.pos == n)
                return temp.moves;

            for (int i = 1; i <= 6; i++) {
                Pair next = new Pair(temp.pos + i);
                if(next.pos <= n && move[next.pos-1] != 0) {
                    if(move[next.pos-1] == -1) {
                        move[next.pos-1] = 0;
                    }else {
                        next = new Pair(move[next.pos-1]);
                        move[next.pos-1] = 0;
                    }
                    next.moves = temp.moves+1;
                    q.add(next);
                }
            }
        }
        return -1;
    }
}
