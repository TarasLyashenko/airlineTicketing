package com.example.airlineTicketing;

import com.example.airlineTicketing.Dao.TestEntityDao;
import com.example.airlineTicketing.Entity.TestEntity;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineTicketingApplication implements CommandLineRunner
{
    @Resource
    private TestEntityDao testEntityDao;

    public static void main(String[] args)
    {
        SpringApplication.run(AirlineTicketingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        TestEntity testEntity = new TestEntity();
        testEntity.setTest("Test");
        testEntityDao.save(testEntity);
        System.out.println();
    }
}
