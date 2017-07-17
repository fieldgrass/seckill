package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cms on 2017/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"" +
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        logger.info("exposer={}",exposer);
        //Exposer{exposed=true, md5='80749e7c8b45cb9f49583076c77debae', seckillId=1000, now=0, start=0, end=0}
    }

    @Test
    public void executeSeckill() throws Exception {
        SeckillExecution execution=seckillService.executeSeckill(1000,10086,"80749e7c8b45cb9f49583076c77debae");
        logger.info("execution={}",execution);
    }

}