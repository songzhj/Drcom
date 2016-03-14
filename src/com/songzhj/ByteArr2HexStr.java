package com.songzhj;

public class ByteArr2HexStr {
	/**  
     * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]  
     * hexStr2ByteArr(String strIn) ��Ϊ�����ת������  
     *   
     * @param arrB  
     *            ��Ҫת����byte����  
     * @return ת������ַ���  
     * @throws Exception  
     *             �������������κ��쳣�������쳣ȫ���׳�  
     */  
   public static String byteArr2HexStr(byte[] arrB) throws Exception {
       int iLen = arrB.length;
       // ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
       StringBuffer sb = new StringBuffer(iLen * 2);
       for (int i = 0; i < iLen; i++) {
           int intTmp = arrB[i];
           // �Ѹ���ת��Ϊ����
           while (intTmp < 0) {
               intTmp = intTmp + 256;
           }
           // С��0F������Ҫ��ǰ�油0
           if (intTmp < 16) {
               sb.append("0");
           }
           sb.append(Integer.toString(intTmp, 16));
       }
       return sb.toString();
   }
}
