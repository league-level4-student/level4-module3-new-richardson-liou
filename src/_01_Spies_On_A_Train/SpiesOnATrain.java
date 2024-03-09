package _01_Spies_On_A_Train;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
        String mostLikelySuspect = null;
        int maxMatches = 0;
        Node<TrainCar> head = train.getHead();
        
        HashMap<String, Integer> names = new HashMap<String,Integer>();

        while (head != null) {
        	TrainCar current = head.getValue();
        	
            String passengerStatement = current.questionPassenger();
            String[] statement = passengerStatement.split(" ");
            List<String> state = Arrays.asList(statement);
            passengerStatement = passengerStatement.replace(".", "");
            System.out.println(passengerStatement);
            
            
            int matches = 0;
            
            for(String clue : clues) {
            	if(passengerStatement.endsWith(clue)) {
		           int index = state.indexOf("saw");
		           String name = state.get(index+1);
		           if(names.get(name) != null) {
		        	   names.put(name, names.get(name)+1);
		           }
		           else {
		        	   names.put(name, 1);
		           }
            	}
            }
           
            head = head.getNext();
        }
     
        
        for(Entry e : names.entrySet()) {
        	int val = (int) e.getValue();
        	if(val > maxMatches) {
        		maxMatches = val;
        		mostLikelySuspect = (String) e.getKey();
        	}
        	
        	
        	
        }
        
        

        return mostLikelySuspect;
    }
    
   
}