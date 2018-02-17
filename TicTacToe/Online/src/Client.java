import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			Socket socket = new Socket("localhost", 6066);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			System.out.println("Unable to connect to the address: " + "localhost" + ":" + 6066 );
		}
		System.out.println("Successfully connected to the server.");
	
	Scanner sc=new Scanner(System.in);
	int guess;
	String s = null;
	while(true) {
		guess=sc.nextInt();
		try {
			dos.writeInt(guess);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s=dis.readUTF();
			System.out.println(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.equals("You won!!!")) {
			break;
		}
	}
}
}
