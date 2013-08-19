package com.kernelbee.plc.hw;

public class DigitalInputRaspberryPi extends DigitalInput{
	
	public DigitalInputRaspberryPi(int index) {
		super(index);
		// TODO
	}

	@Override
	public void readInput() {
		
		//System.out.format("\n\t\t\t\t\t\t\t\tRPi-readInput #%d",index);
		
		//value <- input
		value = ( (index&1)==1 )? true:false;
	}
	
}
