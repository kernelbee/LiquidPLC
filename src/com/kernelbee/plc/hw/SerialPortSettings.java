package com.kernelbee.plc.hw;

public class SerialPortSettings {

	public int handshake;
	public int parity;
	public int ssbits;
	public int dbits;
	public int bps;
	
	SerialPortSettings(	int handshake, int parity, int ssbits, int dbits, int bps){
		this.handshake = handshake;
		this.parity = parity;
		this.ssbits = ssbits;
		this.dbits = dbits;
		this.bps = bps;	
	}
	
}
