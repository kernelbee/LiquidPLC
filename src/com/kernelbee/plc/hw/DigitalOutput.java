package com.kernelbee.plc.hw;

public abstract class DigitalOutput {
	
	protected int index;
	protected boolean value;
	
	public DigitalOutput(int index){
		this.index = index;
	}
		
	public void setOutput(boolean value){
		this.value = value;		
	}
	public abstract void writeOutput();
	
	public boolean getCurrValue(){
		return value;
	}
}
