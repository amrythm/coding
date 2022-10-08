package Graphs;

import java.util.*;

public class DivideIntoComponents {

    public static void main(String[] args) {

        ArrayList<Node> tree = new ArrayList<>();
        Node root = new Node("Black");
        //tree.add(root);
        Node second = new Node("Black");
        Node third  = new Node("Blue");
        Node fourth = new Node("Blue");
        Node fifth = new Node("Red");
        root.children.add(second);
        second.children.add(root);
        root.children.add(third);
        third.children.add(root);
        root.children.add(fourth);
        fourth.children.add(root);
        root.children.add(fifth);
        fifth.children.add(root);
//        Node sixth = new Node("Green");
//        Node seventh = new Node("Blue");
//        Node eighth = new Node("Green");
//        Node ninth = new Node("Red");
//
//        root.children.add(second);
//        second.children.add(root);
//        root.children.add(third);
//        third.children.add(root);
//        root.children.add(fourth);
//        fourth.children.add(root);
//        root.children.add(fifth);
//        fifth.children.add(root);
//        third.children.add(sixth);
//        sixth.children.add(third);
//        fourth.children.add(seventh);
//        seventh.children.add(fourth);
//        fourth.children.add(eighth);
//        eighth.children.add(fourth);
//        fifth.children.add(ninth);
//        ninth.children.add(fifth);

        tree.add(root);
        tree.add(second);
        tree.add(third);
        tree.add(fourth);
        tree.add(fifth);
//        tree.add(sixth);
//        tree.add(seventh);
//        tree.add(eighth);
//        tree.add(ninth);

        System.out.println(edgesToRemove(tree));

    }

    static class Node {
        String color;
        ArrayList<Node> children;

        Node(String color) {
            this.color = color;
            children = new ArrayList<>();
        }
    }

    static class Pair {
        int red, blue;

        Pair() {
            this.red=0;
            this.blue = 0;
        }
    }

    static int edgesToRemove(ArrayList<Node> tree) {

        int countRed = 0, countBlue = 0;

        for (int i = 0; i < tree.size(); i++) {
            if(tree.get(i).color == "Red")
                countRed++;
            if(tree.get(i).color == "Blue")
                countBlue++;
        }

        HashSet<Node> visited = new HashSet<>();
        int count;
        return  countRedBlue(tree.get(0), countBlue, countRed, 0, 0,0, visited);
    }

    private static int countRedBlue( Node src, int blue, int red, int currRed,
                                      int currBlue, int count, HashSet<Node> visited) {

        if(visited.contains(src))
            return count;

        visited.add(src);

        if(src.color == "Red")
            currRed++;
        if(src.color == "Blue")
            currBlue++;

        if(currBlue == blue && currRed == 0)
            count++;

        if(currRed == red && currBlue == 0)
            count++;

        for (int i = 0; i < src.children.size(); i++) {
                countRedBlue(src.children.get(i), blue, red, currRed, currBlue, count, visited);
        }

        return count;
    }

}
