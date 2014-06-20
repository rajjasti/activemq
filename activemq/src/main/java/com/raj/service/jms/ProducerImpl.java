package com.raj.service.jms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerImpl implements Producer {
	  private static final Log LOG = LogFactory.getLog(ProducerImpl.class);

	  private Destination destination;

	  private JmsTemplate jmsTemplate;

	  public void placeMessageOnQueue(String unitNumber, Object object) {
	    queueObject(unitNumber, (Serializable) object);
	  }

	  public void setDestination(Destination destination) {
	    this.destination = destination;
	  }

	  public void setJmsTemplate(JmsTemplate jmsTemplate) {
	    this.jmsTemplate = jmsTemplate;
	  }

	  protected void queueObject(final String unitNumber, Serializable messageObject) {
	    final Map<String, String> queueParams = new HashMap<String, String>();
	    queueParams.put("unitNumber", unitNumber);
	    queueParams.put("JMSXGroupID", unitNumber);

	    final Serializable msgObject = messageObject;

	    jmsTemplate.send(destination, new MessageCreator() {
	        public Message createMessage(Session session)
	            throws JMSException {
	          if (LOG.isDebugEnabled()) {
	            LOG.debug("Creating message");
	          }

	          ObjectMessage message = session.createObjectMessage();
	          message.setObject(msgObject);

	          for (String aKey : queueParams.keySet()) {
	            message.setStringProperty(aKey, queueParams.get(aKey));
	          }

	          return message;
	        }
	      });
	  }
	}

