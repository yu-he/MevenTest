package InfoSky;

import com.pantech.esb.bean.EsbConsumer;
import com.pantech.esb.bean.EsbProducer;
import com.pantech.esb.bean.MessageConsumer;
import com.pantech.esb.exception.IllegalAuthorizedException;
import com.pantech.esb.service.MessageSender;

import java.io.IOException;

public class EsbBusTest {
    public static void main(String[] args) throws IllegalAuthorizedException, IOException {
        // 发送代码
        EsbProducer esbProducer = new EsbProducer();
        MessageSender messageSender = esbProducer.buildMessageSender("testTopic", "testService", new SenderService());
        for (int i = 0; i < 20; i++) {
            messageSender.send("这是⼀条测试信息", "test");
        }

        // 接收代码
        EsbConsumer esbConsumer = new EsbConsumer();
        try {
            MessageConsumer messageConsumer = esbConsumer.buildMessageConsumer("testService", new ConsumerService(), false);
            messageConsumer.start(true);
        } catch (IllegalAuthorizedException e) {
            e.printStackTrace();
        }
    }
}
