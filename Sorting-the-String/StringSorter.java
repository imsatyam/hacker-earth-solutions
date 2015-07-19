import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class StringSorter {
	
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		
		for(int testIndex = 0; testIndex < testCaseCount; testIndex++){
			
			//Get the string and order information
			String[] stringAndOrder = br.readLine().split(" ");
			char[] characterArr = getCharacterArray(stringAndOrder[0]);
			
			if(characterArr != null){
				boolean isAscending = ((Integer.parseInt(stringAndOrder[1])) % 2) == 0;
				System.out.println(getSortedString(characterArr, isAscending));
			}
			else{
				System.out.println("NULL");
			}
		}
        
    }
    
    //Process the string
    private static char[] getCharacterArray(String inputString){
    	
    	StringBuilder builder = null;
    	char[] characterArr = null;
    	
    	for(char character : inputString.toCharArray()){
    		//Check if the character is uppercase. If yes, add to builder
    		if(Character.isUpperCase(character)){
    			if(builder == null){
    				builder = new StringBuilder();
    			}
    			builder.append(character);
    		}
    	}
    	
    	if(builder != null){
    		characterArr = builder.toString().toCharArray();
    		Arrays.sort(characterArr);
    	}
    	
    	return characterArr;
    }
    
    //Sort the string
    private static String getSortedString(char[] arr, boolean isAscending){
    	StringBuilder builder = new StringBuilder();
    	if(isAscending){
    		for(char c : arr){
    			builder.append(c);
    		}
    	}
    	else{
    		for(int index = arr.length - 1; index >= 0; index--){
    			builder.append(arr[index]);
    		}
    	}
    	return builder.toString();
    }
}