package com.kernelbee.plc.vm;

public interface PLCCycle{
	
	public void initUnit();
	public void getInputs();	
	public void setOutputs();	
	public void finishUnit();	
}
