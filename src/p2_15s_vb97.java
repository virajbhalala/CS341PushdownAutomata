

import java.util.*;
public class p2_15s_vb97 {
	public static void main(String[] args){
		
		System.out.println("Do you want to enter a string? Enter y for yes and n for no");
		Scanner s= new Scanner(System.in);
		String answer = s.nextLine();
		//String answer = "y";
		if(answer.compareTo("y")==0){
			System.out.println("Please input the string to test the program!");
			String input = s.nextLine();
			System.out.println("You entered: " + input);
			start( input);	
		}
		else if (answer.compareTo("n")==0){
			System.out.println("Program terminated!");
		}
		else{
			System.out.println("You did not enter right letter. Please enter y for yes and n for no");
			main(args);
		}
		
	}
	
	//static variable which will be commonly used in most of the methods
	public static int index=0;
	public static String[] args = {};
	private  static Stack stack=new Stack();


	//read,pop->push
	//start method consist q1 and q2
	public static void start(String input){
		int size= input.length();
		System.out.println("Entering start state q1");
		//checking if index is less than size and if the character matches then go to corresponding state
		if (index<size && input.charAt(0)=='$'){
			stack.push("$");
			printOut("$","epsilon","$","q1", "q2");
			index++;
			
			//checking if index is less than size and if the character matches then go to corresponding state
			//we dont need worry about popping, pushing, and peeking stuff when it is epsilon 
			if(index<size && Character.isLetter(input.charAt(index))){
				printOut(input.substring(index, index+1),"epsilon","epsilon","q2", "q3");
				index++;
				q3(input);
			}
			
			else if(index<size && input.charAt(index) == '('){
				//since 
				stack.push("(");
				printOut(input.substring(index, index+1),"epsilon","(","q2", "q5");
				index++;
				q5(input);
				}
			else
			{
				//System.out.println(input.charAt(index));
				reject();
			}
		}
		else
		{
			reject();
		}	
	}
	
	private static String operators = "+-*/";
	//From here, each state will have their own method. So it will be easier and less code when going from one state to another state multiple times
	public static void q3(String input){
		int size= input.length();
		//System.out.println(index);
		//System.out.println(input.substring(index, index+1));
        
        //if it is a letter, digit, or _
		if (index<size && Character.isLetter(input.charAt(index)) || Character.isDigit(input.charAt(index)) || input.charAt(index) == '_' ){
			printOut(input.substring(index, index+1),"epsilon","epsilon","q3", "q3");
			index++;
			q3(input);
		}
		else if(index<size && operators.contains(input.substring(index, index+1))){
			printOut(input.substring(index, index+1),"epsilon","epsilon","q3", "q4");
			index++;
			q4(input);
			
		}
	
        //if ")" then we have to pop  "("
		else if (index<size && input.charAt(index) == ')'){
			if (stack.peek()=="("){
				stack.pop();
				//stack.push("");
				printOut(input.substring(index, index+1),"(","epsilon","q3", "q6");
				index++;
				q6(input);
			}
			else 
				reject();
		}
		
		//if "$" at the end then we have to pop $ which was in the beginning
		else if (index<size && input.charAt(index)=='$' && stack.peek()=="$"){
			stack.pop();
			printOut("$","$","epsilon","q3", "q7");
			index++;
			q7(input);
		}
		else reject();
		
		
	}
	public static void q4(String input){
		int size= input.length();

		if(index<size && input.charAt(index) == '('){
			stack.push("(");
			printOut(input.substring(index, index+1),"epsilon","(","q4", "q5");
			index++;
			q5(input);
		}
		else if(index<size && Character.isLetter(input.charAt(index))){
			printOut(input.substring(index, index+1),"epsilon","epsilon","q4", "q3");
			//stack.push(input.substring(index, index+1));
			index++;
			q3(input);
		}
		else reject();
		
		
	}
	public static void q5(String input){
		int size= input.length();

		//this call function itself again
		if(index<size && input.charAt(index) == '('){
			stack.push("(");
			printOut(input.substring(index, index+1),"epsilon","(","q5", "q5");
			index++;
			q5(input);
			
		}
		else if(index<size && Character.isLetter(input.charAt(index))){
			printOut(input.substring(index, index+1),"epsilon","epsilon","q5", "q3");
			//stack.push(input.substring(index, index+1));
			index++;
			q3(input);
		}
		else reject();
	
	}
	public static void q6(String input){
		int size= input.length();
		if (index<size && input.charAt(index) == ')' && stack.peek()=="("){
			stack.pop();
			printOut(input.substring(index, index+1),"(","epsilon","q6", "q6");
			index++;
			q6(input);
		}
		else if(index<size && operators.contains(input.substring(index, index+1))){
			printOut(input.substring(index, index+1),"epsilon","epsilon","q6", "q4");
			index++;
			q4(input);
			
		} 
		else if (index<size && input.charAt(index)=='$' && stack.peek()=="$"){
			stack.pop();
			printOut("$","$","epsilon","q3", "q7");
			index++;
			q7(input);
		}
		else
			reject();
	
	}
	
	//accept state
	public static void q7(String input){
		int size= input.length();
		//check to see if it is end of the string (index is already incremented previously so we dont have to write index+1)
		if (index==size && stack.empty()){
			accept();
		}
		else
			reject();
	}
		
	public static void printOut( String symbolRead, String symbolPopped, String SymbolPushed, String Lstate, String Estate ){
		 System.out.println("READ: " +symbolRead+ " \t POPPED: " +symbolPopped + " \t --> PUSHED: " +SymbolPushed +"  |   State left: " +Lstate+ " \t State Entering: " +Estate); 
	}
	
	//I have made accept and reject method just to decrease the code size
	public static void reject(){
		System.out.println("String is rejected!");
		stack.clear();
		index=0;
		main(args);
	}
	public static void accept (){
		System.out.println("String is accepted!");
		index=0;
		main(args);
	}
}

	