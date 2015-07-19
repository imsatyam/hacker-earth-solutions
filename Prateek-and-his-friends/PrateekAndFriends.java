import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
class PrateekAndFriends {
    
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //number of test cases
        int testCaseCount = Integer.parseInt(br.readLine());
        
        //Read the relevent inputs
        for(int testIndex = 0; testIndex < testCaseCount; testIndex++){
        	
        	//Get information line
        	String[] friendCountAndBudget = br.readLine().split(" ");
        	int friendCount = Integer.parseInt(friendCountAndBudget[0]);
        	int budget = Integer.parseInt(friendCountAndBudget[1]);
        	
        	//Read the cost for each friend and store it in an array.
        	int[] costArr = new int[friendCount];
        	for(int friendIndex = 0; friendIndex < friendCount; friendIndex++){
        		costArr[friendIndex] = Integer.parseInt(br.readLine());
        	}
        	
        	//Check if this invite is successful
        	if(isInviteSuccessful(costArr, budget)){
        		System.out.println("YES");
        	}else{
        		System.out.println("NO");
        	}
        }
    }
    /*
    * Checks the invite.
    */
    private static boolean isInviteSuccessful(int[] costArr, int budget){
    	
    	boolean isValid = false;
    	
    	for(int index = 0; index < costArr.length; index++){
    		
    		//if boolean value is true, that means we got a successful invite
    		if(isValid){
    			break;
    		}
    		int sumOfCost = 0;
    		for(int startIndex = index; startIndex < costArr.length; startIndex++){
    			sumOfCost = sumOfCost + costArr[startIndex];
    			
    			//if sumOfCost = budget, it is a success scenario. Fail otherwise
    			if(sumOfCost == budget){
    				isValid = true;
    				break;
    			}
    			else if(sumOfCost > budget){
    				break;
    			}
    		}
    	}
    	return isValid;
    }
    
}