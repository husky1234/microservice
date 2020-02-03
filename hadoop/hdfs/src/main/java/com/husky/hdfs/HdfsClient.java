package com.husky.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;


public class HdfsClient {
    @Test
    public void testMkdirs() throws IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://192.168.0.102:9000"), configuration, "atguigu");
        fileSystem.copyToLocalFile(new Path("/1.txt"),new Path("d:\\"));
        fileSystem.close();
    }
}
