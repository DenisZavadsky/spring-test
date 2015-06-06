package com.levelup.spring.service.jms;

import com.levelup.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created by denis_zavadsky on 6/6/15.
 */
@Component("topicMessageProducer")
public class TopicMessageProducer {

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    public void sendMessage(){
        Product product = new Product();

        jmsTopicTemplate.convertAndSend(product);
    }

    public void sendCreate(final String messageContent) {

        jmsTopicTemplate.send(new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {

                ObjectMessage message = session.createObjectMessage(messageContent);
                TextMessage text = session.createTextMessage();
                text.setText("Test");
                text.setBooleanProperty("isRedirected",true);
                message.setStringProperty("type", "create");



                return message;
            }

        });
    }
}
