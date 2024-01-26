package com.hacker.hl.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // 클라이언트로 연결 받는 소켓
    ServerSocket serverSocket;

    // 실제 통신을 담당할 소켓 필요
    Socket socket;

    // 입력 스트림 - 소켓을 담당
    BufferedReader reader;

    // 출력 스트림
    BufferedWriter bufferedWriter;

    // 서버측에서 키보드 데이터를 받기 위해 입력 스트림이 필요하다.
    // 키보드에 대한 입력 데이터를 담당
    BufferedReader keyboardReader;

    public Server() {
        initData();
    }

    private void initData() {
        try {
            // 서버 소켓 생성
            serverSocket = new ServerSocket(10000);

            // 클라이언트 접속 대기
            socket = serverSocket.accept(); // 대기하고 있음 -> 클라이언트가 들어오면 -> 소켓 반환
            System.out.println("클라이언트 연결 완료");

            // 스트림 연결 (입력 스트림)
            // 입력 스트림 연결 -> 대상 : 소켓
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 키보드에 연결 스트림 준비
            keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 클라이언트측으로 데이터를 보내기 위해 출력 스트림 연결 - 대상 소켓
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 새로운 작업자 생성해서 일 해라고 명령하기
            WriterThread writerThread = new WriterThread();
            // Runnable 타입을 시작 시키는 방법
            Thread thread = new Thread(writerThread);
            thread.start(); // run() 메서드 안에 코드가 동작

            // 데이터를 읽는 명령 - main 쓰레드
            while (true) {
                String msg = "클라이언트 >>> " + reader.readLine() + "\n";
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                bufferedWriter.close();
                keyboardReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // end of initData

    // 내부 클래스 생성
    class WriterThread implements Runnable {

        // 새로운 작업자가 해야 할 일을 정의한다.
        @Override
        public void run() {
            // 키보드에서 데이터를 입력 받아
            // 소켓 출력 스트림을 통해서 데이터를 보내주어야 한다.
            while (true) {
                try {
                    String serverMsg = "서버 : " + keyboardReader.readLine(); // 키보드의 데이터를 받을 수 있다.
                    System.out.println("서버가 작성한 문구 확인 : " + serverMsg);
                    // 출력 스트림을 통해서 데이터 보내기 <-- 소켓
                    bufferedWriter.write(serverMsg + "\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    } // end of main

} // end of class
