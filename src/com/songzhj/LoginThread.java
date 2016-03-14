package com.songzhj;


public class LoginThread implements Runnable{ //登录线程
	private String dusr;
	private String dipaddr;
	private String dpwd;
	private String dmac;
	private byte[] authinfo;
	
	public LoginThread(String usr, String ipaddr, String pwd, String mac){
		this.dusr = usr;
		this.dipaddr = ipaddr;
		this.dpwd = pwd;
		this.dmac = mac;		
	}
	@Override
	public void run(){
		String svr = "10.100.61.3";
		try {
//			Looper.prepare();
			authinfo = login.dr_login(this.dusr, this.dipaddr, this.dpwd, svr, this.dmac);
//			Looper.loop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}