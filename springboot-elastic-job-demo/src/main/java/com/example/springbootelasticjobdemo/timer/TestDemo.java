package com.example.springbootelasticjobdemo.timer;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.util.Date;

/**
 * @author sh 2018/12/7 16:04
 * @version ideaIU-2018.2.5.win
 */
public class TestDemo implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(new Date());
    }
}
