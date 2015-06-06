package com.levelup.spring.service.jms;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created by denis_zavadsky on 6/6/15.
 */
@Component("simpleMessageListener")
public class SimpleMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage){
            try {
                Object myObject = ((ObjectMessage) message).getObject();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
