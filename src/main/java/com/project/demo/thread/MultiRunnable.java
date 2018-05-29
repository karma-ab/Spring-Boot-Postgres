package com.project.demo.thread;

public class MultiRunnable implements Runnable {

	@Override
	public void run() {

		for (int i = 5; i > 0; i--) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println("thread runnable is running...");
		}

	}

}
