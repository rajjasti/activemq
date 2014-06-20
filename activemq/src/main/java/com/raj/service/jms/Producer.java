package com.raj.service.jms;

public interface Producer {
	  /**
	   * This method will allow outbound messages to be placed on a queue
	   *
	   * @param xmlLog the log object used for tracking
	   * @param object the obejct to place on the queue
	   */
	  void placeMessageOnQueue(String unitNumber, Object object);
	}
