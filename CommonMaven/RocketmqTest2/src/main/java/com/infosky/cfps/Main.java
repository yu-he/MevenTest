package com.infosky.cfps;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
//            Properties properties = new Properties();
//            ClassPathResource resource = new ClassPathResource("system.properties");
//            InputStream in = resource.getInputStream();
//            properties.load(in);
//
//            String isTestDatabusConsumer = properties.getProperty("isTestDatabusConsumer");
//            String isTestDatabusProducer = properties.getProperty("isTestDatabusProducer");
//            String aclAccessKey = properties.getProperty("aclAccessKey");
//            String aclSecretKey = properties.getProperty("aclSecretKey");
//            String consumerGroupName = properties.getProperty("consumerGroupName");
//            String nameServerAddress = properties.getProperty("nameServerAddress");
//            String topic = properties.getProperty("topic");
//            String tag = properties.getProperty("tag");
//            String isTls = properties.getProperty("tls");
//            String message = "生产消息测试aaaaa123456";
            String isTestDatabusConsumer = "Y";
            String isTestDatabusProducer = "N";
            String aclAccessKey = "IMF-I";
            String aclSecretKey = "IMF-I#2024";
            String consumerGroupName = "IIS_CMS";
            String nameServerAddress = "172.22.73.140:9876";
            String topic = "XIY-IMF-FLIGHT_CMS";
            String tag = "ALL";
            String isTls = "N";
            String message = "生产消息测试aaaaa123456";

            if ("Y".equals(isTestDatabusProducer)) {
                try {
                    RPCHook rpcHook = new AclClientRPCHook(new SessionCredentials(aclAccessKey, aclSecretKey));
                    DefaultMQProducer producer = new DefaultMQProducer(consumerGroupName, rpcHook, true, null);
                    producer.setNamesrvAddr(nameServerAddress);
                    if ("Y".equals(isTls)) {
                        producer.setUseTLS(true);
                    }
                    producer.start();
                    Message msg = new Message(topic, tag, Long.toString(System.currentTimeMillis()), message.getBytes(RemotingHelper.DEFAULT_CHARSET));
                    SendResult sendResult = producer.send(msg);
                    System.out.println("生产消息成功，返回：" + sendResult.toString());
                    producer.shutdown();
                } catch (Exception ex) {
                    System.out.println("mq生产异常：" + ex.getMessage() + "：" + Arrays.toString(ex.getStackTrace()));
                }
            }

            if ("Y".equals(isTestDatabusConsumer)) {
                try {
                    RPCHook rpcHook = new AclClientRPCHook(new SessionCredentials(aclAccessKey, aclSecretKey));
                    DefaultLitePullConsumer consumer = new DefaultLitePullConsumer(consumerGroupName, rpcHook);
                    consumer.setNamesrvAddr(nameServerAddress);
                    if ("Y".equals(isTls)) {
                        consumer.setUseTLS(true);
                    }
                    consumer.subscribe(topic, "*");
                    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
                    consumer.setAutoCommit(true);
                    consumer.start();
                    while (true) {
                        List<MessageExt> msgExtList = consumer.poll();
                        if (msgExtList == null || msgExtList.isEmpty()) {
                            System.out.println("接收到的消息数组为空");
                        }

                        for (MessageExt messageExt : msgExtList) {
                            String msgBody = new String(messageExt.getBody(), StandardCharsets.UTF_8);
                            System.out.println("接收到的消息：" + msgBody);
                        }
                    }
                    //consumer.shutdown();
                } catch (Exception ex) {
                    System.out.println("mq消费异常：" + ex.getMessage() + "：" + Arrays.toString(ex.getStackTrace()));
                }
            }
        } catch (Exception ex) {
            System.out.println("程序运行异常：" + ex.getMessage() + "：" + Arrays.toString(ex.getStackTrace()));
        }
    }
}
