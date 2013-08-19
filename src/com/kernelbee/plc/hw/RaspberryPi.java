package com.kernelbee.plc.hw;

public class RaspberryPi extends Platform{
	
	private final String MY_NAME = "RaspberryPi";	
	
	public int version;	
		
	public RaspberryPi(int version){
						
		this.version = version;
						
		switch(version){
		case 0:
			preAllocateArrays(8,8,8,8);
			break;
		case 1:
			preAllocateArrays(16,16,16,16);
			break;
		}
		
		for(int i = 0; i < digitalInputs.length; i++){
			digitalInputs[i] = new DigitalInputRaspberryPi(i);
		}		
		
		for(int i = 0; i < digitalOutputs.length; i++){
			digitalOutputs[i] = new DigitalOutputRaspberryPi(i);
		}
		
		for(int i = 0; i < analogInputs.length; i++){
			analogInputs[i] = new AnalogInputRaspberryPi(i);
		}		
		
		for(int i = 0; i < analogOutputs.length; i++){
			analogOutputs[i] = new AnalogOutputRaspberryPi(i);
		}
	}
	
	public String getName(){
		
		String ver = ".ver.unknown";
		
		switch(version){		
		case 0: ver = ".ver.A"; break;
		case 1: ver = ".ver.B"; break;		
		}	
		
		return MY_NAME+ver;
	}		
}
