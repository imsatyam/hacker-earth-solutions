import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Solution to Friends everywhere problem
 * @author Satyam Shandilya
 *
 */
public class FriendsEverywhereSolution {

static class Student implements Comparable<Student>{
    	
    	private final int friendId;
    	private final HashSet<Integer> friends = new HashSet<Integer>();
    	
    	public Student(int id){
    		friendId = id;
    	}
    	
    	public int compareTo(Student student){
    		if(friends.size() > student.friends.size()){
    			return -1;
    		}
    		return 1;
    	}
    }
    
    public static void main(String args[] ) throws Exception {
        
        Scanner userInput = new Scanner(System.in);
        
        //Read the first line
        int numberOfStudents = userInput.nextInt();
        int numberOfPairs = userInput.nextInt();
        
        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        
        //Populate map based on number of students
        for(int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++){
        	studentMap.put(studentIndex, new Student(studentIndex));
        }
        
        //Now iterate the pairs
        for(int pairIndex = 0; pairIndex < numberOfPairs; pairIndex++){
        	int friendOne = userInput.nextInt();
        	int friendTwo = userInput.nextInt();
        	studentMap.get(friendOne).friends.add(friendTwo);
        	studentMap.get(friendTwo).friends.add(friendOne);
        }
        
        //Now get the set of map values
        ConcurrentSkipListSet<Student> studentSet = new ConcurrentSkipListSet<Student>(studentMap.values());
        
        //We need to iterate over it and find friend and remove set
        Iterator<Student> iterator = studentSet.iterator();
        Set<Integer> newFriends = new HashSet<Integer>();
        Set<Integer> autoFriends = new HashSet<Integer>();
        
        while(iterator.hasNext()){
        	Student student = iterator.next();
        	if(autoFriends.contains(student.friendId)){
        		iterator.remove();
        		continue;
        	}
        	
        	newFriends.add(student.friendId);
        	
        	for(Integer frndId : student.friends){
        		autoFriends.add(frndId);
        	}
        }
        
        //Result
        System.out.println(newFriends.size());
        
        StringBuilder builder = new StringBuilder();
        for(int frndId : newFriends){
        	builder.append(frndId).append(" ");
        }
        System.out.println(builder.toString().trim());
    }
	
}
