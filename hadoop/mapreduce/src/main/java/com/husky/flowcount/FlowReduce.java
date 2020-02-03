package com.husky.flowcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReduce extends Reducer<Text, FlowBean,Text, FlowBean> {

    FlowBean resultBean = new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long sum_upFlow = 0;
        long sum_downFlow = 0;
        for (FlowBean value : values) {
            sum_upFlow += value.getUpFlow();
            sum_downFlow += value.getDownFlow();
        }
        resultBean.setUpFlow(sum_upFlow);
        resultBean.setDownFlow(sum_downFlow);
        resultBean.setSumFlow(sum_downFlow + sum_upFlow);
        context.write(key,resultBean);
    }
}
