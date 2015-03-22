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
		}
		else
		{
			System.out.println("Program terminated!");
		}
		
		
	}
	Stack stack=new Stack();

	public static String printState(){
		return "";
		
	}

}

	