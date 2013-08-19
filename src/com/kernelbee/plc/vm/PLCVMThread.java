package com.kernelbee.plc.vm;


public class PLCVMThread implements Runnable{
	
	private PLCVM vm;
	
	public PLCVMThread(PLCVM plc) {
		vm = plc;
	}

	@Override
	public void run() {		
		try {
			
			vm.loop();
			
		} catch (InterruptedException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
