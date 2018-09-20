import java.io.*;
import java.util.*;
class Social{
	public String[] list1,list2;
	User[] users;
	int size;
	Social() {
		users = new User[100];
		size = 0;
	}
	public void user(String name, String friends) {
		String[] flist = friends.split(",");
		User u = new User(name,flist);
		users[size++] = u;
		int z = 0;
		if (size > 2) {
			while (z < size) {
				for (int i = 0; i < size - 1; i++) {
					if (users[i].username.compareTo(users[i+1].username) > 0) {
						User temp = users[i];
						users[i] = users[i + 1];
						users[i + 1] = temp;
					}
				}
			z++;	
			}
		}
	}
	public void getConnections(String username) {
		if (size!=0) {
			int f = 0;
			for (int i = 0; i < size; i++) {
				if (username.equals(users[i].getname())) {
					f = 1;
					System.out.println(users[i].tostring());
				}
			}
			if (f == 0) {
				System.out.println("Not a user in Network");
			}
		}
	}
	public void addConnections(String username,String newfriend) {
		for (int i = 0; i < size; i++) {
			if (username.equals(users[i].getname())) {
				users[i].addfriend(newfriend);
			}
 		}
	}
	public String getCommonConnections(String username1, String username2) {
		String[] mutual;
		for (int i = 0; i < size; i++) {
			if (username1.equals(users[i].getname())){
				list1 = Arrays.copyOf(users[i].getfriend(),users[i].getfriendscount());
			}
			if (username2.equals(users[i].getname())){
				list2 = Arrays.copyOf(users[i].getfriend(),users[i].getfriendscount());
			}
		}
		if (list1.length > list2.length) {
			mutual = new String[list1.length];
		} else {
			mutual = new String[list2.length];
		}
		int dup = 0;
		if (list1.length !=0 && list2.length != 0) {
			for (int j = 0; j < list1.length; j++) {
				for (int k = 0; k < list2.length; k++) {
					if (list1[j].equals(list2[k])){
						mutual[dup++] = list1[j]; 
					}
					else {
						continue;
					}
				}
			}
		}
		if (dup == 0) {
			return "[]";
		}
		String s = "[";
		for (int i = 0; i < dup - 1; i++) {
			s = s + mutual[i] + ", ";
		}
		return s + mutual[dup - 1] + "]";
	}
	public void network() {
		String s = "";
		for (int i = 0; i < size-1; i++) {
			s = s + users[i].getname() + ": " + users[i].tostring() + ", ";
		}
		s = s + users[size-1].getname() + ": " + users[size-1].tostring();
		System.out.println(s);
	}
}