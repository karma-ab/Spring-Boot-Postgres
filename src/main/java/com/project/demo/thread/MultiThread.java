package com.project.demo.thread;

public class MultiThread extends Thread {

	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(" extending thread is running...");
		}

	}

}
