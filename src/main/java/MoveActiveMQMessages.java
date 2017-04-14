import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by mdev on 7/25/16.
 */

public class MoveActiveMQMessages {

    public static void main(String[] args) throws JMSException, InterruptedException {

        String queueFrom = "loadable";
        String hostFrom = "relaymq02";

        String queueTo = "loadable";
        String hostTo = "relaymq01";


        Session consumerSession = getSession(hostFrom);
        Session producerSession = getSession(hostTo);
        // Wait for a receivedMessage
        MessageConsumer consumer = getConsumer(consumerSession, queueFrom);
        MessageProducer producer = getProducer(producerSession, queueTo);
        try {
            while (true) {
                Thread.sleep(100);
                Message receivedMessage = consumer.receive();
                TextMessage textMessage = (TextMessage) receivedMessage;
                String message = textMessage.getText();
                final Message msg = producerSession.createTextMessage(message);
                producer.send(msg);
            }
        } finally {
            consumerSession.close();
            producerSession.close();
            System.exit(0);
        }
    }

    public static MessageConsumer getConsumer(Session session, String queueName) throws JMSException {
        return session.createConsumer(session.createQueue(queueName));
    }

    public static MessageProducer getProducer(Session session, String queueName) throws JMSException {
        return session.createProducer(session.createQueue(queueName));
    }

    public static Session getSession(String host) throws JMSException {
        final ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://" + host + ".tmsgf.trb:61616");
        final Connection conn = connFactory.createConnection();
        conn.start();
        return conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }


}