package com.kh.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtil {
	/*
	 * 암호화의 방향성
	 *   1) 단방향 : 암호화된 평문을 다시 복호화 할 수 없는 암호화 방식이다. (SHA2, MD5)
	 *   2) 양방향 : 암호화된 평문을 다시 복호화 할 수 있는 암호화 방식이다.
	 *     2-1) 대칭키 방식 : 암/복호화에 사용하는 키가 동일하다. (AES, DES)
	 *     2-2) 비 대칭키 방식 : 암/복화에 사용하는 키가 다르다. (RSA)
	 *     
	 * SHA2(Secure Hash Algorithm 2)
	 * 	 1) SHA-256
	 * 	   - SHA-256은 임의의 길이 메시지를 256비트 (32바이트)의 축약된 메시지로 만들어내는 해시 알고리즘이다.
	 *   2) SHA-512
	 *     - SHA-512은 임의의 길이 메시지를 512비트 (64바이트)의 축약된 메시지로 만들어내는 해시 알고리즘이다.
	 *   * 암호화 해시 함수의 안정성을 강화하기 위해 추가로 스트레칭, 솔트 방법을 사용한다. (직접 찾아보세요.)
	 */
	
	// 단방향 암호화(MD2, MD5, SHA, SHA-1, SHA-256, SHA-512를 지원한다.)
	public static String oneWayEnc(String message, String algorithm) {
		byte[] digest;
		String encMessage = "";
		
		try {
			// 메시지 다이제스트란, 입력 값의 길이에 상관없이 수학적인 연산을 항상 동일한 길이의 해시 값을 만들어낸다.
			MessageDigest md = MessageDigest.getInstance(algorithm);
			
			// 평문(message)을 byte[] 변환해서 메시지 다이제스트로 전달한다. 
			md.update(message.getBytes(Charset.forName("UTF-8")));
			
			// 암호화 형식에 맞는 byte[]로 변경하여 리턴한다.
			digest = md.digest();
			
			// Base64는 byte 형식의 데이터를 문자열로 인코딩, 디코딩하는 객체이다.
			encMessage = Base64.getEncoder().encodeToString(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encMessage;
	}
}
