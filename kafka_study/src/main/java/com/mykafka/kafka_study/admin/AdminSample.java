package com.mykafka.kafka_study.admin;

import org.apache.kafka.clients.admin.*;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class AdminSample {

    public final static String TOPIC_NAME = "fj_topic";

    public static void main(String[] args) throws Exception {
        //AdminClient adminClient = AdminSample.adminClient();
        //System.out.println("adminClient: " + adminClient);
        // 创建Topic实例
        //createTopic();
        // 获取Topic
        //topicLists();
    }

    /*
        获取Topic列表
     */
    public static void topicLists() throws Exception {
        AdminClient adminClient = adminClient();
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> names = listTopicsResult.names().get();

        // 打印names
        names.stream().forEach(System.out::println);
    }

    /*
        创建Topic实例
     */
    public static void createTopic() {
        AdminClient adminClient = adminClient();
        // 副本因子
        Short rs = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME, 1, rs);
        CreateTopicsResult topics = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("CreateTopicsResult: " + topics);
    }

    /*
        设置 AdminClient
     */
    public static AdminClient adminClient() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.58.128:9092");

        AdminClient adminClient = AdminClient.create(properties);
        return adminClient;
    }
}
