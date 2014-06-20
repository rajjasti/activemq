package com.raj.service.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service("errorHandler")
public class JmsErrorHandler implements ErrorHandler {
  private static final Log LOG = LogFactory.getLog(JmsErrorHandler.class);

  @Override
  public void handleError(Throwable t) {
    LOG.error("Error in listener", t);
  }
}