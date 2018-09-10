package com.lyl.dnf.action;

public class ActionRun implements Action {
	
	public static final int STATUS_READY = 0;
	
	public static final int STATUS_IN_PROGRESS = 1;
	
	public static final int STATUS_SUCCESS = 2;
	
	public static final int STATUS_FAILED = -1;
	
	private long startTime;
	
	private int status;
	
	private Action action;
	
	public ActionRun(Action action) {
		this.action = action;
		status = STATUS_READY;
	}
	
	public void start() {
		startTime = System.currentTimeMillis();
		status = STATUS_IN_PROGRESS;
		action.action();
	}

	@Override
	public void action() {
		
	}

	public int currentStatus() {
		return status;
	}

	public boolean isSuccess() {
		return status == STATUS_SUCCESS;
	}

	public long runtime() {
		return System.currentTimeMillis() - startTime;
	}
	
}
