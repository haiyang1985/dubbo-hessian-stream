package org.ghy.dubbo.hessian.stream;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;

import java.io.*;

public class HessianStreamTest {
    public static void main(String[] args) throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(os);
        OutputStream outputStream = output.getBytesOutputStream();
        byte[] bytes = {1, 2, 3, 4, 5};
        outputStream.write(bytes);

        byte[] bytesInput = {0, 0, 0, 1, 2, 3, 4, 5};
        InputStream is = new ByteArrayInputStream(bytesInput);
        Hessian2Input input = new Hessian2Input(is);
        InputStream inputStream = input.readInputStream();
        System.out.println(inputStream);
    }
}
