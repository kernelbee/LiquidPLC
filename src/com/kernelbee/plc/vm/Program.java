package com.kernelbee.plc.vm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Program implements ProgramAPI{
			
	private Object obj;
	private Class<?> cls;
	private ProgramAPI api;	
	
	public Program(String rootName,String className)
	
			throws 	InstantiationException,
					IllegalAccessException,
					ClassNotFoundException,
					MalformedURLException{				
				
		File root = new File(rootName);
		String srcPath = rootName + "/" + className + ".java";		
		System.out.format("source-file path: [%s]\n",srcPath);
		
		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();		
		System.out.format("System Java Compiler: [%s]\n",compiler);
		
		compiler.run(null, null, null, srcPath);
		
		// Load and instantiate compiled class.
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });		
		//System.out.format("URI URL: [%s]\n",root.toURI().toURL());
								
		cls = Class.forName(className, true, classLoader);						
		obj = cls.newInstance();
		
		//Time to do some magic: get API (provided by object).
		api = (ProgramAPI)obj;
	}
	
	public String getInfo(){
		return api.getInfo();
	}
	
	public void mainProgram() throws InterruptedException {
		api.mainProgram();		
	}
	public void subPrograms(int subProgramID) throws InterruptedException {
		api.subPrograms(subProgramID);
	}
	public void interrupts(int interruptID) throws InterruptedException {
		api.interrupts(interruptID);
	}	
}
