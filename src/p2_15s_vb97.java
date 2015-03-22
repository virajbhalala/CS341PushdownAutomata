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
			PDA( input);
			
		}
		else
		{
			System.out.println("Program terminated!");
		}
		
		
		
	
	}
	
	
	public static void PDA(String input){
		System.out.println("assume £ is an epsilon symbol");
		printOut('$','£','$',"q1", "q2");
	}

	//£ assume this epsilon symbol (option+3)
	Stack stack=new Stack();
	
	
	
	public static void printOut( char symbolRead, char symbolPopped, char SymbolPushed, String Lstate, String Estate ){
		 System.out.println("Read: " +symbolRead+ ", Popped: " +symbolPopped + " --> Pushed: " +SymbolPushed +" | State left: " +Lstate+ " State Entering: " +Estate + "\n") ; 
	}

	//will be used to print the stack
	public static String printState(){
		return "";
		
	}
			

}

	