import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class HelloActiveMQ {

    public static void main(String[] args) throws JMSException {

        String message = "test";
        String queueName = "mdevvvv";
        String host = "relaydevmq01";

        final ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://" + host + ".tmsgf.trb:61616");

        final Connection conn = connFactory.createConnection();

        final Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        final Destination dest = sess.createQueue(queueName);

        final MessageProducer prod = sess.createProducer(dest);

        final Message msg = sess.createTextMessage(message);

        prod.send(msg);
        sess.close();
        conn.close();
        System.exit(0);
    }
}