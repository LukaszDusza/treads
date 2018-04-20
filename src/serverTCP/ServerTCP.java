package serverTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP extends Thread {

	private int serverPort;

	public ServerTCP(String name, int port) {
		setName(name);
		serverPort = port;
	}

	public void run() {

		ServerSocket serversocket = null;
		Socket connectedSocked = null;
		InputStream inputstream = null;
		OutputStream outputstream = null;

		String responceMessage = "HTTP/1.1 200 OK\r\n\r\n" + "<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<title> Serwer TCP  </title>" + " </head>" + " <body>"
				+ " <br /><center> <b> Witaj na serwerze TCP Akademii Kodu :)  </b></center>" + " </body>" + "</html>";

		byte[] responce = responceMessage.getBytes();
		byte[] buffer = new byte[2048];

		try {
			serversocket = new ServerSocket(serverPort);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!this.isInterrupted()) {

			try {
				connectedSocked = serversocket.accept();
				ConectedTCP mythread = new ConectedTCP("Serwer");
				mythread.start();
				inputstream = connectedSocked.getInputStream();
				outputstream = connectedSocked.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				outputstream.write(responce);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				int counter = inputstream.read(buffer);
				if (counter > 0) {
					String tekstmes = new String(buffer, 0, buffer.length);
					System.out.println(tekstmes);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			outputstream.flush();
			outputstream.close();
			inputstream.close();
			connectedSocked.close();
			if (serversocket != null) {
				serversocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
