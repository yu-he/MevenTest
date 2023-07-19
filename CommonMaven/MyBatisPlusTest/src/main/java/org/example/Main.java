package org.example;

import org.example.mybatisplus.entity.FilAwbInfo;
import org.example.mybatisplus.mapper.FilAwbInfoDao;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class Main implements ApplicationContextAware {
    private static ApplicationContext context;
    public static void main(String[] args) {
        SpringApplication.run(Main.class);

        FilAwbInfoDao awbInfoDao = context.getBean(FilAwbInfoDao.class);
        FilAwbInfo filAwbInfo = new FilAwbInfo();
        filAwbInfo.setBillId("AWBA99911011011");
        filAwbInfo = awbInfoDao.queryAwb(filAwbInfo);
        System.out.println(filAwbInfo.getBillId());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}