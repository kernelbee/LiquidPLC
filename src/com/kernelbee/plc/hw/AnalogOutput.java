package com.kernelbee.plc.hw;

public abstract class AnalogOutput {
	
	protected int index;
	protected int value;
	
	public AnalogOutput(int index){
		this.index = index;
	}
	
	protected abstract void writeOutput();
	
	public void setOutput(int value){
		this.value = value;
		writeOutput();
	}
	
	public int getCurrValue(){
		return value;
	}

}
