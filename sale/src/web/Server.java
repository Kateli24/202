package web;


import org.jooby.Jooby;


/**
 *
 * @author liji8162
 */
public class Server extends Jooby {
	public static void main(String[] args) {
		new Server().start();
		
	}
	
	public Server(){
		port(6900);
		get("/", () -> "Hello World");
		
	}
	
	
	
}
