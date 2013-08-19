package com.kernelbee.plc.vm.Mitsubishi.FX3;

import com.kernelbee.plc.hw.Platform;
import com.kernelbee.plc.vm.PLCVM;

public class PLC extends PLCVM{
		
	public PLC(Platform platform) {
		super(platform);
		//TODO
	}
	
	///////////////////////////////////////////////////////////////////////////
	@Override
	public void initUnit(){
		super.initUnit();
		//TODO
		//System.out.format("\t\t\t\t\tFX3* up.\n");
	};	
	@Override
	public void getInputs(){
		super.getInputs();
		//TODO		
		//System.out.format("\t\t\tgetInputs FX3*.\n");
	};	
	@Override
	public void setOutputs(){
		super.setOutputs();
		//TODO
		//System.out.format("\t\t\tsetOutputs FX3*.\n");
	};	
	@Override
	public void finishUnit(){
		super.finishUnit();
		//TODO
		System.out.format("\t\t\t\tFX3* down.\n\n");
	};
	///////////////////////////////////////////////////////////////////////////
	
	public String getName(){
		return "\t[Mitsubishi FX3*]\ton\t" + "[" + hw.getName() + "]";
	}

}
