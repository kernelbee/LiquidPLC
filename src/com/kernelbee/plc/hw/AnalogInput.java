package com.kernelbee.plc.hw;

public abstract class AnalogInput {

	protected int index;
	protected int value;
	
	public AnalogInput(int index){
		this.index = index;
	}
	
	protected abstract int readInput();
	
	public int getInput(){		
		return value = readInput();
	}
	
	public int getCurrValue(){
		return value;
	}
}
