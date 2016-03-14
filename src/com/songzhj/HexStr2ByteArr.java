package com.songzhj;

public class HexStr2ByteArr {
	 public static byte[] hexStr2ByteArr(String strIn) throws Exception {
	        byte[] arrB = strIn.getBytes();
	        int iLen = arrB.length;
	 
	        // �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
	        byte[] arrOut = new byte[iLen / 2];
	        for (int i = 0; i < iLen; i = i + 2) {
	            String strTmp = new String(arrB, i, 2);
	            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
	        }
	        return arrOut;
	    }
	 
	 public static byte[] hexStr2ByteArrl(String strIn) throws Exception {
	        byte[] arrB = strIn.getBytes();
	        int iLen = arrB.length;
	 
	        // �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
	        byte[] arrOut = new byte[iLen / 2];
	        for (int i = 0; i < iLen; i = i + 2) {
	            String strTmp = new String(arrB, i, 2);
	            arrOut[i / 2] = (byte) Long.parseLong(strTmp, 16);
	        }
	        return arrOut;
	    }
	 
}