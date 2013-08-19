package com.kernelbee.plc.vm;

import com.kernelbee.plc.hw.Platform;
import com.kernelbee.plc.hw.PlatformMessageType;

public abstract class PLCVM implements PLCCycle{

	public abstract String getName();
		
	protected Platform hw;
	protected Program sw;
	
	protected long cycles;
	protected long timeStarted;
	protected long timeStopped;
	
	protected long nInterrupts;
	
	public PLCVM(Platform platform){
		hw = platform;	hw.installVM(this);		
	}
	
	public String getHWName(){
		return hw.getName();
	}

	public void loadSW(Program software){
		
		System.out.format(	"\n...Loading program:\n"
							+"################################\n"
							+"%s"
							+"################################\n",							
							software.getInfo());
		
		this.sw = software;
	}
	
	public String getSWName(){
		if(sw!=null)
			return sw.getInfo();
		else
			return "No program installed yet";
	}
	
	public void processNotification(PlatformMessageType type,int[] data){
						
		//System.out.format("\nHave got h/w notification: %s\t%s",type,Arrays.toString(data));
		
		switch(type){
		
		case PLC_INTERRUPT:
			
			nInterrupts++;
			
			try {
				
				if(sw!=null)
					sw.interrupts(data[0]);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case PLC_MODULE_LINK:
			break;
			
		case PLC_MODULE_UNLINK:
			break;
			
		default:
			break;
		}		
	}
	/////////////////////////////////////////////////////////////	
	private static volatile boolean isRUNNING = true;
	
	public static void stopCycle(boolean stopIt){
		isRUNNING = !stopIt;
	}	
	public static boolean isRunning(){
		return isRUNNING;
	}	
	
	protected void loop() throws InterruptedException{
		
		initUnit();
		
		while(PLCVM.isRunning() == true){

			getInputs();
			
			if(sw!=null)
				sw.mainProgram();
			else
				Thread.sleep(100);
			
			setOutputs();
		};
		
		finishUnit();
	}	
	/////////////////////////////////////////////////////////////	
	public void initUnit(){
		System.out.format("\ninit...");
		
		hw.initUnit();
		
		cycles = 0;
		nInterrupts = 0;
		timeStarted = System.nanoTime();
	};	
	public void getInputs(){
		
		cycles++;
		
		//System.out.format("\nreading Inputs...");
		
		hw.getInputs();
	};	
	public void setOutputs(){
		//System.out.format("\nupdating Outputs...");
		
		hw.setOutputs();
	};	
	public void finishUnit(){
		
		timeStopped = System.nanoTime();
		long duration = timeStopped - timeStarted;					
		System.out.format("\t\tavarage cycle time (by %d cycles, %d interrupts): %.6f ms (%d ns)\n",
				cycles,
				nInterrupts,
				(double)duration/1000000.0/((double)cycles),
				(long)((double)duration/((double)cycles))
				);
		
		System.out.format("\nfinish...");
		
		hw.finishUnit();
	};
	/////////////////////////////////////////////////////////////
	
}
