package com.husky.hbase;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.ByteBufferUtils;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;

public class HbaseTest {
    public static Configuration configuration;
    public static Connection connection;
    static {
        try {
            configuration = HBaseConfiguration.create();
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1() throws IOException {
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        NamespaceDescriptor atguigu = NamespaceDescriptor.create("atguigu").build();
        admin.createNamespace(atguigu);
    }
    @Test
    public void test2() throws IOException {
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("sex");
        admin.addColumn("student",hColumnDescriptor);
    }
    @Test
    public void test3() throws IOException {
        HBaseAdmin admin  = (HBaseAdmin) connection.getAdmin();
        admin.deleteColumn("student", "sex");
    }
    @Test
    public void test4() throws IOException {
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(Bytes.toBytes("atguigu"), Bytes.toBytes("class")));
        hTableDescriptor.addFamily(new HColumnDescriptor("info"));
        admin.createTable(hTableDescriptor);
    }
    @Test
    public void test5() throws IOException {
        Table table = connection.getTable(TableName.valueOf(Bytes.toBytes("atguigu"), Bytes.toBytes("class")));
        table.put(new Put(Bytes.toBytes("1001")).addColumn(Bytes.toBytes("info"),Bytes.toBytes("name"),Bytes.toBytes("zhangshan")));
    }
    @Test
    public void test6() throws IOException {
        HTable table = (HTable) connection.getTable(TableName.valueOf(Bytes.toBytes("atguigu"), Bytes.toBytes("class")));
        Get get = new Get(Bytes.toBytes("1001"));
        Result result = table.get(get);
        for (Cell cell : result.rawCells()) {
            System.out.println(Bytes.toString(result.getRow()));
            System.out.println(Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }
}
