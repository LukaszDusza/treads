package serverTCP;

public class Main {

	public static void main(String[] args) {

		
		ServerTCP server8080 = new ServerTCP("serwer 8082", 8082);

		
		server8080.start();

	}

}
