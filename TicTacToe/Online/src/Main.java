import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Socket connection=null;
		ServerSocket server = null;
		Scanner scanner=new Scanner(System.in);
		int hostname;
		int ip;
		System.out.println("port");	
		hostname=scanner.nextInt();
		System.out.println("Give ip");	
		//ip=scanner.nextInt();
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			server=new ServerSocket(hostname);
			System.out.println("Waiting for client to connect");
			while(true) {
				connection=server.accept();
				if(connection!=null) {
					break;
				}
			}
			System.out.println("Connection found.");
			dos = new DataOutputStream(connection.getOutputStream());
			dis = new DataInputStream(connection.getInputStream());

		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Give a number");
		int x=scanner.nextInt();
		int guess=0;
		while(guess!=x) {
			try {
			guess=dis.readInt();
			}catch(IOException e) {
				
			}
			try {
				if(guess==x) {
				
					dos.writeUTF("You won!!!");
					dos.flush();
			}else {
				dos.writeUTF("Guess again");
				dos.flush();
		
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		try {
			connection.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
