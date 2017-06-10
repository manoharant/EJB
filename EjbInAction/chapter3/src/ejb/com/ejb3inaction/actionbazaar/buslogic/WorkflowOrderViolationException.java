package com.ejb3inaction.actionbazaar.buslogic;

public class WorkflowOrderViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WorkflowOrderViolationException() {
	}

	public WorkflowOrderViolationException(String msg) {
		super(msg);
	}

	public WorkflowOrderViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WorkflowOrderViolationException(Throwable cause) {
		super(cause);
	}
}