package Graphs;


public class IfWordExists {

    public static void main (String[] args) {

        char[][] puzzle = {  {'o','p','x','a','a', 'e'},
                             {'l','m','k','s','t','c'},
                             {'w','t','t','j','r','d'},
                             {'i','f','d','v','o','x'},
                             {'k','g','u','a','n','s'},
                             {'n','m','t','l','c','p'}};

        System.out.println(wordExists(puzzle, "psnovdftmp"));

    }

    static boolean wordExists(char[][] puzzle, String word) {

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if(puzzle[i][j] == word.charAt(0))
                    if(find(puzzle,word,0, i,j))
                        return true;
            }
        }
        return false;
    }

    private static boolean find(char[][] puzzle, String word,int pos, int i, int j) {

        if(pos >= word.length())
            return true;
        if(word.charAt(pos) != puzzle[i][j])
            return false;



        puzzle[i][j] = '$';

        int[][] dirs = {{0,1},{0,-1},{1,0}, {-1,0}};
         for (int k = 0; k < dirs.length; k++) {
            int i1 = i + dirs[k][0];
            int j1 = j + dirs[k][1];

            if(i1>=0 && j1>=0 && i1<puzzle.length && j1 < puzzle[0].length) {
                if(find(puzzle, word, pos+1,i1,j1))
                    return true;
            }
         }
         puzzle[i][j] = word.charAt(0);
         return false;
    }
}
