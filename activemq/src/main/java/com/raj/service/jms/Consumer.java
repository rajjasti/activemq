package com.raj.service.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class Consumer implements MessageListener {


	  /**
	   * If the queue is marked in the database as 'paused' then put the message back on the queue and
	   * pause it.
	   *
	   * @param message Description of the Parameter
	   */
	  public void onMessage(Message message) {
		  
		 
			 try {
				 ObjectMessage objMsg = (ObjectMessage) message;
				 String test = (String)objMsg.getObject();
				System.out.println("Came here " + test);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }

	 
	}

