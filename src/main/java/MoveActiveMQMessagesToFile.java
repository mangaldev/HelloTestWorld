import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by mdev on 8/2/16.
 */
public class MoveActiveMQMessagesToFile {
//    static int THRESHOLD = 500;
//
//    public static void main(String[] args) throws JMSException, InterruptedException {
//
//        String queueFrom = "loadable";
//        String hostFrom = "relaymq02";
//
//
//        Session consumerSession = getSession(hostFrom);
//        // Wait for a receivedMessage
//        MessageConsumer consumer = getConsumer(consumerSession, queueFrom);
//        int count = 0;
//        while (count++ < THRESHOLD) {
//            Thread.sleep(100);
//            Message receivedMessage = consumer.receive();
//            TextMessage textMessage = (TextMessage) receivedMessage;
//            if (textMessage == null)
//                continue;
//            String message = textMessage.getText();
//            String fileName = "Loadable-" + new Date() + ".txt";
//            try (FileWriter writer = new FileWriter(new File("./temp/" + fileName))) {
//                writer.write(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        consumerSession.close();
//
//        System.exit(0);
//    }
//
//    public static MessageConsumer getConsumer(Session session, String queueName) throws JMSException {
//        return session.createConsumer(session.createQueue(queueName));
//    }
//
//    public static Session getSession(String host) throws JMSException {
//        final ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://" + host + ".tmsgf.trb:61616");
//        final Connection conn = connFactory.createConnection();
//        conn.start();
//        return conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
//    }


}