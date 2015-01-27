package com.dac.common.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;

public class ExecTest {
	
	 public static void main(String... args)
	            throws IOException {
	        final SSHClient ssh = new SSHClient();
	        ssh.loadKnownHosts();
	        ssh.connect("192.168.130.74");
	        try {
	            ssh.authPassword("shui.ren", "OwdyeepIj3");
	            final Session session = ssh.startSession();
	            try {
	                final Command cmd = session.exec("ll /log/241.66/tops/tops-front-purchaser(membermix-a1.nh.travelzen.cn)-debug-current.log");
	                System.out.println(IOUtils.readFully(cmd.getInputStream()).toString());
	                cmd.join(5, TimeUnit.SECONDS);
	                System.out.println("\n** exit status: " + cmd.getExitStatus());
	            } finally {
	                session.close();
	            }
	        } finally {
	            ssh.disconnect();
	        }
	 }

}
