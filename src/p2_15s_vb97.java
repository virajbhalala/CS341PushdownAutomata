import java.util.*;


public class p2_15s_vb97 {
	public static void main(String[] args){
		
		System.out.println("Do you want to enter a string?");
		Scanner s= new Scanner(System.in);
		String answer = s.nextLine();
		
		
		if(answer.compareTo("y")==0 ||answer.compareTo("Y")==0){
			System.out.println("Please input the string to test the program!");
			String input = s.nextLine();
			System.out.println("You entered: " + input);
			start( input);
			
		}
		else
		{
			System.out.println("Program terminated!");
		}
		
		
		
	
	}
	public static int index=0;
	public static String[] args = {};


	//read,pop->push
	public static void start(String input){
		int index=0;
		Stack stack=new Stack();
		//System.out.println("assume £ is an epsilon symbol");
		if (input.charAt(0)=='$'){
			stack.push("$");
			printOut("$","epsilon","$","q1", "q2");
			index++;
			if(Character.isLetter(input.charAt(index))){
				printOut(input.substring(index, index+1),"epsilon","epsilon","q1", "q2");
				//stack.push(input.substring(index, index+1));
				q3(input);
				index++;
			}
			else if(input.charAt(index) == '('){
				stack.push("(");
				printOut(input.substring(index, index+1),"epsilon","(","q1", "q2");
				q5(input);
				index++;
				}
			else
			{
				reject();
			}
		}
		else
		{
			reject();
		}
		
		
	}
	public static void q3(String input){
		
		
	}
	public static void q4(String input){
		
	}
	public static void q5(String input){
	
	}
	public static void q6(String input){
	
	}
	public static void q7(String input){
	
	}
		
	public static void printOut( String symbolRead, String symbolPopped, String SymbolPushed, String Lstate, String Estate ){
		 System.out.println("READ: " +symbolRead+ " \t POPPED: " +symbolPopped + " \t --> PUSHED: " +SymbolPushed +"  |   State left: " +Lstate+ " \t State Entering: " +Estate + "\n") ; 
	}

	//will be used to print the stack
	public static void reject(){
		System.out.println("String is rejected!");
		main(args);
		
	}
	public static void accept (){
		System.out.println("String is accepted!");
		main(args);
	}

	
			

}

	