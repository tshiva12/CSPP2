import java.io.*;
import java.util.*;
class User{
	private String username;
	private int count = 0;
	private String[] friend = new String[100];
	public User(String uname,String[] list){
		username = uname;
		for(String i:list){
			addfriend(i);
		}
	}
	public String getname(){
		return username;
	}
	public String[] getfriend() {
		return friend;
	}
	public int getfriendscount(){
		return count;
	}
	public void addfriend(String newfriend) {
		newfriend = newfriend.replace("." , "").trim();
		friend[count] = newfriend;
		count++; 
	}
	public String tostring() {
		String s = "[";
		for(int i = 0; i < count-1; i++) {
			s = s + friend[i] + ", ";
		}
		return s + friend[count-1] + "]";
	}
}