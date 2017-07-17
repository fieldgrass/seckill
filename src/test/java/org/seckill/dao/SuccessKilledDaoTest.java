package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cms on 2017/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {

        int count=successKilledDao.insertSuccessKilled(1000,123456);
        System.out.println(count);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(1000,123456);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}