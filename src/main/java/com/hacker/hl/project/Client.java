package com.hacker.hl.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    // 통신을 하기 위해 소켓이 필요 + 주소(ip) + 포트번호
    Socket socket;
    //    final String IP = "192.168.0.137";
    // 내 IP
    final String IP = "localhost";
    // 친구 IP
    //final String IP2 = "192.168.56.1";
    final int PORT = 10000;

    BufferedReader keyboardReader;
    BufferedWriter writer;

    // 소켓통신으로 통해 들어온 데이터를 입력받아야 함
    // 입력 스트림 필요
    BufferedReader socketReader;

    public Client() {
        initData();
    }

    private void initData() {
        System.out.println("클라이언트에서 서버 접속 요청");

        try {
            socket = new Socket(IP, PORT);

            // 클라이언트와 서버 연결 완료

            // 파이프로 연결만 해주는 역할
            // 키보드에서 데이터를 입력받기
            keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 소켓 통신을 통해서 데이터를 출력
            // 출력 스트림 연결 : 대상 소켓
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 입력받은 데이터를 소켓과 연결
            // 소켓과 입력 스트림 연결하기 (초기화)
            // 입력 스트림 연결 완료
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 서버측으로 온 데이터 확인 (입력 스트림)
            new Thread(new ReadThread()).start();

            // 위에 선언한 것들 여기서 사용 !!
            while (true) {
                System.out.println("키보드 입력 대기");
                String input = keyboardReader.readLine(); // 키보드에서 데이터 입력 받음
                writer.write(input);
                writer.newLine(); // 문장의 끝을 알려주어야 한다.
                writer.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                keyboardReader.close();
                writer.close();
                socketReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // end of initData

    // 내부 클래스 생성
    class ReadThread implements Runnable {

        @Override
        public void run() {
            // 소켓 통신으로 들어온 데이터를 읽어야 함
            while (true) {
                try {
                    // readLine() : 글을 읽는 기능
                    String serverMsg = socketReader.readLine();
                    System.out.println("서버 >>> " + serverMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new Client();
    } // end of main

} // end of class
