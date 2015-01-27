package com.dac.common.test;

import org.junit.Test;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ExecTest {
	
	@Test
	public void case1(){
		try{
			JSch jsch = new JSch();
			Session session = jsch.getSession("shui.ren", "291.168.130.74", 22);
		}catch(Exception e){
			
		}
		
	}

}
