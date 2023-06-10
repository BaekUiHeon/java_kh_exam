package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public void testServer(int port) {
		String forR = null;
		String forW = null;
		Scanner scanner= new Scanner(System.in);
		try (ServerSocket ss = new ServerSocket(port);) {
			System.out.println("서버 생성......");
			System.out.println("클라이언트 대기중");

			try (Socket s = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
				System.out.println("클라이언트 접속완료");
				System.out.printf("클라이언트 번호:%d\n", s.getLocalPort());
				System.out.printf("포트 번호:%d\n", s.getPort());

				while (!(forR = br.readLine()).equals("")) {
					System.out.println("클라이언트로부터의 입력:"+forR);
				}
				
				while(true) {
					System.out.print("서버전송입력:");
					forW=scanner.nextLine();
					bw.write(forW+"\n");
					bw.flush();
					if(forW.equals(""))
						break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}
}