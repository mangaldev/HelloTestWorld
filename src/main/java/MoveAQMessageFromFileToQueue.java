import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mdev on 8/2/16.
 */
public class MoveAQMessageFromFileToQueue {
    public static void main(String[] args) throws JMSException, IOException, InterruptedException {

        String queueTo = "loadable";
        String hostTo = "relaymq01";

        Session producerSession = getSession(hostTo);
        MessageProducer producer = getProducer(producerSession, queueTo);
        Path directory = Paths.get("./temp/");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry: stream) {
                String message = new String(Files.readAllBytes(entry), Charset.forName("UTF-8"));
                System.out.println("Sending: ");
                final Message msg = producerSession.createTextMessage(message);
                producer.send(msg);
                System.out.println("=================================================================================");
                Thread.sleep(50);
            }
        }

        producerSession.close();

        System.exit(0);
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
