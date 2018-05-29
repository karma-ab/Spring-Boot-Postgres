package com.project.demo.service;

import org.springframework.stereotype.Service;

import com.project.demo.service.interfaces.ThreadInterface;
import com.project.demo.thread.MultiRunnable;
import com.project.demo.thread.MultiThread;

@Service
public class ThreadService implements ThreadInterface {

	@Override
	public boolean startThreads() {
		MultiThread t1=new MultiThread();  
		t1.start(); 
		
		MultiRunnable m1=new MultiRunnable();  
		Thread t2 =new Thread(m1);  
		t2.start();  
		return true;
	}

}
