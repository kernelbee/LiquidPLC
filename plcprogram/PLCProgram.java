import com.kernelbee.plc.vm.ProgramAPI;

public class PLCProgram implements ProgramAPI{

	public String getInfo(){
		return "Project: 0000;\nCustomer: The Big Brother;\nPLC.Mitsubishi.FX3UC;\n2013.03.18 KH\n";
	}

	public void mainProgram() throws InterruptedException {
		System.out.println("calling main program...");
		Thread.sleep(1000);
	}
	public void subPrograms(int subProgramID) throws InterruptedException{
		System.out.format("\tsubprogram[###%d]...\n",subProgramID);
		Thread.sleep(10);
	}
	public void interrupts(int interruptID) throws InterruptedException{
		System.out.format("\t\t\tinterrupt handler[###%d]...\n",interruptID);
		Thread.sleep(0);
	}
}
