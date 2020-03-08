package com.husky.transferdata;

import com.husky.transferdata.mapper.StudentMapper;
import com.husky.transferdata.reduce.StudentReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;

public class StudentRuuner implements Tool {
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = this.getConf();
        Job job = Job.getInstance();
        job.setJarByClass(StudentRuuner.class);
        Scan scan = new Scan();
        TableMapReduceUtil.initTableMapperJob(
                "student",
                scan,
                StudentMapper.class,
                ImmutableBytesWritable.class,
                Put.class,
                job
        );
        TableMapReduceUtil.initTableReducerJob(
                "atguigu:student",
                StudentReduce.class,
                job
        );
        boolean flag = job.waitForCompletion(true);
        return flag ? 0:1;
    }

    @Override
    public void setConf(Configuration conf) {

    }

    @Override
    public Configuration getConf() {
        return null;
    }
}
