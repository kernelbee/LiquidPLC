package com.kernelbee.plc.hw;

import com.kernelbee.plc.vm.PLCCycle;
import com.kernelbee.plc.vm.PLCVM;

public abstract class Platform implements PLCCycle{
	
	public abstract String getName();
	
	protected PLCVM vm;
		
	public void installVM(PLCVM vm){
		this.vm = vm;
	}
	protected void notifyVM(PlatformMessageType type,int[] data){
		if(vm!=null)
			vm.processNotification(type,data);
	}
	
	protected DigitalInput[] digitalInputs;	
	protected DigitalOutput[] digitalOutputs;	
	protected AnalogInput[] analogInputs;	
	protected AnalogOutput[] analogOutputs;
	
	protected void preAllocateArrays(
									int nDigitalIn,
									int nDigitalOut,
									int nAnalogIn,
									int nAnalogOut
									){
		
		digitalInputs = new DigitalInput[nDigitalIn];
		digitalOutputs = new DigitalOutput[nDigitalOut];
		analogInputs = new AnalogInput[nAnalogIn];
		analogOutputs = new AnalogOutput[nAnalogOut];		
	}	
	
	public int getAnalogInput(int index) {		
		return analogInputs[index].getInput();
	}
	public void setAnalogOutput(int index,int value){
		analogOutputs[index].setOutput(value);		
	}
	
	@Override
	public void initUnit(){
		//TODO		
	}
	@Override
	public void getInputs(){
		for(DigitalInput i : digitalInputs){
			i.readInput();
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//to TEST only !!!
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/*
		for(PlatformMessageType t : PlatformMessageType.values()){					
			
			notifyVM(t,new int[]{0,0,0,0});				
		}
		*/
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}
	@Override
	public void setOutputs(){
		for(DigitalOutput i : digitalOutputs){
			i.writeOutput();
		}		
	}
	@Override
	public void finishUnit(){
		//TODO
	}	
}
