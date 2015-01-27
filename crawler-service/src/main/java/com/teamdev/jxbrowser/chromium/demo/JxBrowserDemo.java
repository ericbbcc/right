package com.teamdev.jxbrowser.chromium.demo;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;
import com.teamdev.jxbrowser.chromium.LoggerProvider;

public class JxBrowserDemo {
	public static void init() throws Exception{
		LoggerProvider.getBrowserLogger().setLevel(Level.OFF);
		LoggerProvider.getChromiumProcessLogger().setLevel(Level.OFF);
		LoggerProvider.getIPCLogger().setLevel(Level.OFF);
	}
	 public static void main(String...s) throws Exception{
		 init();
		 final Browser browser = BrowserFactory.create();
		 final JTextField addressBar = new JTextField("http://www.weibo.com");
		 addressBar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                browser.loadURL(addressBar.getText());
	            }
	        });

	        JPanel addressPane = new JPanel(new BorderLayout());
	        addressPane.add(new JLabel(" URL: "), BorderLayout.WEST);
	        addressPane.add(addressBar, BorderLayout.CENTER);

	        JFrame frame = new JFrame("JxBrowser - Hello World");
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.add(addressPane, BorderLayout.NORTH);
	        frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
	        frame.setSize(1,1);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        browser.addLoadListener(new PageLoadListener());
	        browser.loadURL(addressBar.getText());
	 }
}
