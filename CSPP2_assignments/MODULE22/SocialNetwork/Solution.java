import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Social social = new Social();
		Scanner scan = new Scanner(System.in);
		String[] line = scan.nextLine().split(" ");
		for(int i = 0; i < Integer.parseInt(line[1]); i++){
			String str = scan.nextLine();
			String[] array = str.split(" is connected to ");
			social.user(array[0], array[1]);
		}
		while(scan.hasNext()){
			String array = scan.nextLine();
			String[] tokens = array.split(" ");
			if(tokens[0].equals("getConnections")) {
				social.getConnections(tokens[1]);
			}
			if(tokens[0].equals("addConnections")) {
				social.addConnections(tokens[1],tokens[2]);
			}
			if(tokens[0].equals("CommonConnections")) {
				System.out.println(social.getCommonConnections(tokens[1], tokens[2]));
			}
			if(tokens[0].equals("Network")) {
				social.network();
			}
		}
		
	}
}