package com.kernelbee.plc.vm;

public interface ProgramAPI {
	
	public String getInfo();
	void mainProgram() throws InterruptedException;	
	void subPrograms(int subProgramID) throws InterruptedException;
	void interrupts(int interruptID) throws InterruptedException;
}
