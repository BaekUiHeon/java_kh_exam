// 궁금증 Scanner가 아닌 메서드를 따로 만들어준이유. 하나입력받고 바로 String에 넣는방식에서 버퍼가 필요한이유.


package server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server { //Server를 담당할 클래스 

	public void testServer(int port) { // 프로세스 포트번호를 인자로 받는 메서드.
		ServerSocket ss = null;        // 서버담당 소켓 
		BufferedReader br = null;      // 서버입력스트림
		BufferedWriter bw = null;      // 서버출력스트림
		Scanner scanner = new Scanner(System.in); // 문자입력용 Scanner
		
		try {
			ss = new ServerSocket(port); //입력받은 포트번호를 가지는 소켓을 생성.
			System.out.println("클라이언트 대기중......");  // 클라이언트 대기중을 출력해주고
			Socket sc = ss.accept();                   //클라이언트 접촉시 소켓을 생성해줌.
			System.out.println("서버 접속완료!!");        // try안에 있으므로 이위치가 실행되었다는것은 서버가 접속되었다는뜻임.
			System.out.println("로컬번호:" + sc.getLocalPort()); //  클라이언트마다 부여되는 소켓포트번호 출력 
			System.out.println("서버프로세스번호:" + sc.getPort()); //  포트번호출력
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));  
			// 클라이언트로부터 입력받는 스트림, getInputStream은 InputStream객체를 반환하므로, 1.문자열보조스트림으로 감싼다 2.문자열버퍼보조스트림으로감싼다.  
			bw = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
			// 클라이언트로부터 출력받는 스트림,OutputStream객체를 반환하므로, 1.문자열보조스트림으로 감싼다 2.문자열버퍼보조스트림으로감싼다.  

			String forW = null; // 쓰기를 위한 문자열
			String forR = null; // 읽기를 위한 문자열
			while(true) { 							 // 무한루프 while문 실행(종료문 내부에 작성)
				System.out.print("클라이언트 전송문자:"); // 클라이언트 전송문자 발송
				forW = scanner.nextLine();			 // scanner를 통해 문자열을 입력받는다. forW에 저장.
				bw.write(forW+"\n");				 // 입력스트림에 forW에 저장된값을 넣는다.(전달을위해 \n포함)
				bw.flush();						     // 버퍼를 비운다.
				if(forW.equals(""))					 // 입력스트림이 공백이면
					break;							 // while문 종료	
			}
			
			System.out.println("클라이언트 전송종료");    // while문이 종료되면 "클라이언트 전송종료" 출력
			
			while (!((forR = br.readLine()).equals(""))) { // while문 (입력스트림에 공백이 입력되기 전까지 무한반복)
				System.out.println("클라이언로부터의 메세지:" + forR); // 클라이언트로부터의 메세지를 출력한
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ss != null) {
					ss.close();
				}
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scanner.close();
	}
}
