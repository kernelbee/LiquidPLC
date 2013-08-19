package com.kernelbee.plc.hw;

public class AnalogInputRaspberryPi extends AnalogInput {

	public AnalogInputRaspberryPi(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}
	
	protected int readInput() {		
		return (index&1);		
	}

}
