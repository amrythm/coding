package SetsAndMaps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//Given a list of tickets, find itinerary in order using the given list.
//Example:
//
//
//Input:
//"Chennai" -> "Banglore"
//"Bombay" -> "Delhi"
//"Goa"    -> "Chennai"
//"Delhi"  -> "Goa"
//
//Output:
//Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
//It may be assumed that the input list of tickets is not
// cyclic and there is one ticket from every city except final destination.
public class FindItinerary {

    public static void main(String args[]) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Bangalore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
        dataSet.put("Bangalore", "Kanyakumari");
        dataSet.put("Kanyakumari", "Australia");
        dataSet.put("Russia", "Greece");
        dataSet.put("Australia", "Japan");
        dataSet.put("Nagaland" ,"Himachal Pradesh");
        dataSet.put("Japan", "Russia");
        dataSet.put("Greece", "Nagaland");

//        dataSet.put("N", "M");
//        dataSet.put("S", "K");
//        dataSet.put("L", "D");
//        dataSet.put("O", "M");
//        dataSet.put("M", "C");
//        dataSet.put("I", "D");
//        dataSet.put("K", "C");
//        dataSet.put("G", "D");
//        dataSet.put("C", "X");
//        dataSet.put("D", "X");
//        dataSet.put("E", "X");
//        dataSet.put("X","X");

         findItinerary(dataSet);

    }

    public static void findItinerary(Map<String,String> tickets) {

        if(tickets.isEmpty())
            return;

        Hashtable<String, String> itinerary = new Hashtable<>();
        HashMap<String, String> reverse = new HashMap<>();
        String final_dest ="";
        for(String source : tickets.keySet()) {
            String dest = tickets.get(source);

            reverse.put(dest,source);
            if(!tickets.containsKey(dest)) {
                final_dest = dest;
            }
        }
//        itinerary.put(reverse.get(final_dest), final_dest);
//
//            for(String s : itinerary.keySet()) {
//                if(!reverse.containsKey(reverse.get(s)))
//                itinerary.put(reverse.get(s),s);
//                else break;
//            }
        fillItinerary(final_dest, reverse, itinerary);


    }
    public static void fillItinerary(String s, HashMap<String,String > reverse
                                                , Hashtable<String, String> itinerary) {

        if(!reverse.containsKey(reverse.get(s))) {
            itinerary.put(reverse.get(s),s);
            System.out.println(reverse.get(s) + " -> " + s);
            return;
        }

        String curr_source = reverse.get(s);
        fillItinerary(curr_source, reverse, itinerary);
        itinerary.put(curr_source,s);
        System.out.println(curr_source + " -> " + s);
    }
}
