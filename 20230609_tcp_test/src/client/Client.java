package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Scanner scanner= new Scanner(System.in);
	public void testClient(String ip,int port) { // 클라이언트는 클라이언트의 ip와 접속할 port번호를 매개인자로 받는다. 
		Socket s=null;                           // 소켓변수 생성
		BufferedWriter bw=null;					 // 출력스트림
		BufferedReader br=null;                  // 입력스트림
		
		try {
			s= new Socket(ip, port);			// 클라이언트소켓생성
			bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));	// 출력스트림 생성
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));   // 입력스트림 생성
			System.out.println("소켓생성완료");  									// 소켓생성완료 출력
			String forR=null;													// 읽기위한 문자열선언
			String forW=null;													// 쓰기위한 문자열선언
			
			while(!((forR=br.readLine()).equals(""))) {							// 받은메세지가 공백일때까지 while문 무한반복
				System.out.println("받은메세지:"+forR);							// 받은메세지 무한출력
			}								
			
			while(true) {														// 이번엔 서버전송 while문.
				System.out.println("서버 전송문자:");								// "서버전송문자:" 출력
				forW=scanner.nextLine();										// 입력한문자 forW에 저장.
				bw.write(forW+"\n");											// forW 출력스트림에 넣기
				bw.flush();														// 출력스트림 비우기
				if(forW.equals(""))												// forW가 공백이면
					break;														// while문종료
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				if(s!=null) {s.close();}
				if(bw!=null) {bw.close();}
				if(br!=null) {br.close();}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
}
