package com.lyl.common.utils;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageStack {

	private int maxSize;
	
	private Deque<String> messages;
	
	public MessageStack() {
		this(100);
	}
	
	public MessageStack(int maxSize) {
		this.maxSize = maxSize;
		messages = new LinkedBlockingDeque<String>();
	}
	public void push(String message) {
		push(message, 10);
	}
	
	/**
	 * 如果消息队列已满，等待 sleepMillis后再次判断，直到能将消息加入队列位置
	 * @param message
	 * @param sleepMillis
	 */
	public void push(String message, long sleepMillis) {
		while (messages.size() >= maxSize) 
			sleep(sleepMillis);
		synchronized (messages) {
			messages.push(message);
		}
	}
	
	public String pop() {
		return pop(10);
	}
	
	public String pop(long millis) {
		while(messages.isEmpty()) 
			sleep(millis);
		synchronized(messages) {
			return messages.pop();
		}
	}
	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {
		messages.clear();
	}
	
	public static void main(String[] args) {
		System.out.println(new MessageStack().pop());
	}
	
}
