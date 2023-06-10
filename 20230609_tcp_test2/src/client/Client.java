package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

// Client로 Socket을 생성(=클라이언트서버 접속)하고 상호간의 입출력을 수행하는 프로그램 작성을 목표로한다.
public class Client {
	public void testClient(String ip,int port) {
		String forW=null;
		String forR=null;
		try(																							//try 변수선언문
				Socket s=new Socket(ip,port);
				BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				Scanner scanner=new Scanner(System.in);
				
				)
		{
			System.out.println("소켓생성완료");
			while(true) {          																		//try 실행문
				System.out.print("서버출력문자입력:");
				bw.write((forW=scanner.nextLine())+"\n");
				bw.flush();
				if(forW.equals(""))
					break;
			}
			System.out.println("서버출력종료.");
			
			while(!((forR=br.readLine()).equals(""))) {
				System.out.println("클라이언트 송신문자:"+forR);
			}
			System.out.println("클라이언트 송신종료");
		}
		catch(IOException e) {																			//catch문
			e.printStackTrace();
			
			}
		
	}
}
