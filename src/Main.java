import java.net.MalformedURLException;

import sun.misc.Signal;
import sun.misc.SignalHandler;

import com.kernelbee.plc.hw.Platform;
import com.kernelbee.plc.hw.RaspberryPi;

import com.kernelbee.plc.vm.PLCVM;
import com.kernelbee.plc.vm.PLCVMThread;
import com.kernelbee.plc.vm.Mitsubishi.FX3.PLC;

import com.kernelbee.plc.vm.Program;

public class Main {

	//@SuppressWarnings("static-access")
	public static void main(String[] args) throws 	InterruptedException,
													InstantiationException,
													IllegalAccessException,
													ClassNotFoundException,
													MalformedURLException{
				
		SignalHandler signalHandler = new SignalHandler() {
			
			boolean stopIt = false;
			
			public void handle(Signal signal) {
				//System.err.println("Exiting because of signal: " + signal);	            
				stopIt ^= true;
				PLCVM.stopCycle(stopIt);
			}
		};			    
	    Signal.handle(new Signal("INT"), signalHandler);
	    
		////////////////////////////////////////////////////////////////	    
	    //create H/W platform
	    Platform hw = new RaspberryPi(0);
	    
	    //create PLC on specific H/W
	    PLCVM plc = new PLC(hw);	    
		
		System.out.println(	 "\n********************************************************************\n"
							+plc.getName()
							+"\n********************************************************************\n"
							);
		
		//load S/W from java file, compile and map it to Program API
		Program sw = new Program(	"../plcprogram",
									"PLCProgram");
	    //load S/W to PLC
	    plc.loadSW(sw);
		
	    //create PLC VM thread
		PLCVMThread runner = new PLCVMThread(plc);
		////////////////////////////////////////////////////////////////
		do{
		
			if(PLCVM.isRunning()){
								
				Thread thread = new Thread(runner);		
				
				//run VM on H/W
				thread.start();
				
				try {
					thread.join();
				
			    } catch (InterruptedException e) {
			    	//TODO ?
			    }				
			}else{
				System.out.println("...VM is stopped...");
				Thread.sleep(1000);
			}
			
		}while(true);
		//////////////////////////////////////////			
	}
}
