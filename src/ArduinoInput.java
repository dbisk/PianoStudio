import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.fazecast.jSerialComm.*;

/**
 * The ArduinoInput class represents an object that reads in data from an Arduino
 * connected to the computer via a Serial Port (usually USB). 
 * 
 * @author Dean Biskup
 * @version 5/22/2016
 *
 */
public class ArduinoInput implements Runnable{

	private SerialPort[] ports;
	private SerialPort chosenPort;
	private InputStream data;
	//private Scanner data;
	
	private int output;
	
	/**
	 * Constructs an "ArduinoInput" object that is designed to read the output from the 
	 * Arduino as input into the Java project. The Arduino must be in the specified USB port
	 * denoted by the parameter "port" in this constructor.
	 * 
	 * @param port the number of the serial (USB) port the Arduino is plugged into
	 * @deprecated the no args constructor should be able to find the Arduino given that
	 * the arduino drivers are installed
	 */
	public ArduinoInput(int port) {
		ports = SerialPort.getCommPorts();
		if (ports.length <= port)
			throw new NullPointerException("Arduino is in the incorrect port");
		chosenPort = ports[port];
		output = -1;
		
		if (chosenPort.openPort())
			System.out.println("Port opened successfully");
		else
			throw new NullPointerException("Port opening failed");
		chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);
		data = chosenPort.getInputStream();
		new Thread(this).start();
	}
	
	/**
	 * The default constructor searches for the Serial Port "COM3", which is traditionally the name
	 * of the Arduino's port. This will only work if the Arduino drivers are installed. 
	 * 
	 * Replaces the ArduinoInput(int port) constructor
	 * 
	 * Works as of 5/19/2016
	 */
	public ArduinoInput() {
		ports = SerialPort.getCommPorts();
		chosenPort = SerialPort.getCommPort("COM3");
		/*
		for (SerialPort p : ports) {
			String s = p.getDescriptivePortName(); // For testing purposes
			if (p.getDescriptivePortName().equals("Insert Arduino Name Here"))
				chosenPort = p;
		}*/
		
		output = -1;
		
		if (chosenPort.openPort())
			System.out.println("Port opened successfully");
		else
			throw new NullPointerException("Port opening failed");
		chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);
		data = chosenPort.getInputStream();
		new Thread(this).start();
	}
	
	private int readSerialLine() throws IOException {
		int result = -1;
		//output = -1;
		result = data.read();
		if (result == 57)
			result = -1;
		
		return result;
	}
	
	/**
	 * The run() method continually runs, and reads the next number from the serial input.
	 */
	public void run() {
		
		

		while(true) {
			//if (data.hasNextLine()) {
				try{
					output = readSerialLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			//} else
				//output = -1;
			
			
			
			System.out.println(output);
		}
	}
	
	public int getOutput() {
		return output;
	}
}
