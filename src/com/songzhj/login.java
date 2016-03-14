package com.songzhj;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class login {
	public static byte[] dr_login(String usr, String ipaddr, String pwd, String svr, String mac) throws Exception{
		byte[] salt = challenge.dr_challenge(svr, true);

		byte[] packet = mkpkt.dr_mkpkt(salt, ipaddr, usr, pwd, mac);
		DatagramSocket client = new DatagramSocket();
		InetAddress addr = InetAddress.getByName(svr);
		DatagramPacket sendPacket = new DatagramPacket(packet, packet.length, addr, 61440);
		client.send(sendPacket);
		
		byte[] receive = new byte[45];
		DatagramPacket re_packet=new DatagramPacket(receive, 45);
		client.receive(re_packet);
		
/*		if(receive[0]==0x04){
			Toast.makeText(context, "��½�ɹ�", Toast.LENGTH_SHORT).show();  
		}else{
			Toast.makeText(context, "��½ʧ��", Toast.LENGTH_SHORT).show();    
		}*/
		byte[] data = new byte[16];
		for(int i=23;i<39;i++){
			data[i-23] = receive[i];	
		}
		return data;
	}
}
