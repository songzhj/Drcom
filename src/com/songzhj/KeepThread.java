package com.songzhj;

public class KeepThread implements Runnable{ //心跳线程
	@Override
	public void run(){
		String svr = "10.100.61.3";
		try {
			keep_alive.keep(svr);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
