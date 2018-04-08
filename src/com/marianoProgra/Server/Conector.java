package com.marianoProgra.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conector {
	
	ServerSocket server;
	Socket socket;
	int puerto = 9000;
	DataOutputStream salida;
	BufferedReader entrada;
	
	public void iniciar() {
		try {
			server = new ServerSocket(puerto);
			socket = new Socket();
			socket = server.accept();
			
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String mensaje = entrada.readLine();
			System.out.println(mensaje);
			
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Adios Mundo");
			socket.close();
		} catch (Exception e) {}
	}

}
