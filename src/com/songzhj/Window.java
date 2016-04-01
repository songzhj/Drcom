package com.songzhj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Window {

	private JFrame frame;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
					updateState(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void updateState(Window window) {
		Timer timer = new Timer();
		timer.schedule(window.new updateState(), 0, Main.updateTime);
	}
	
	class updateState extends TimerTask {
		@Override
		public void run() {
			new Thread(new LoginThread(Main._account, Main.ipaddr, Main._password, Main._mac)).start(); //登录的操作
			new Thread(new KeepThread()).start(); //心跳
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			textArea.append(Main.res + "\n");
		}
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 414, 147);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 10, 414, 147);
	}
}
