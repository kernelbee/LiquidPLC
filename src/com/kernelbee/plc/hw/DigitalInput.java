package com.kernelbee.plc.hw;

public abstract class DigitalInput {
	
	protected int index;
	protected boolean value;
	
	public DigitalInput(int index){
		this.index = index;
	}
	
	public abstract void readInput();
	
	public boolean getCurrValue(){
		return value;
	}
}
