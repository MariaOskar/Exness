package com.exness.utils;

import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestUtils {

    private static final String CRYPTO_FILENAME = "src/test/resources/crypto.txt";

    public static List<String> getCryptoList(){
       return getLinesFromFile(CRYPTO_FILENAME);
    }

    public static List<String> getLinesFromFile(String filename){
        List<String> lines = new ArrayList<>();
        try {
            String str = FileUtils.readFileToString(new File(filename),"UTF-8");
            lines.addAll(Arrays.asList(str.split("\r\n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static Object[][] convertNestedListToArray(List<List<Object>> list){
        Object[][] result = new Object[list.size()][];
        for(int i=0; i < list.size(); i++){
            result[i] = list.get(i).toArray();
        }
        return result;
    }

    public static Object[][] getDataProviderFromYaml(String filename, String blockName){
        Yaml yaml = new Yaml();
        InputStream is = TestUtils.class.getClassLoader().getResourceAsStream(filename);
        Map<String, List<List<Object>>> data = yaml.load(is);

        return convertNestedListToArray(data.get(blockName));
    }

}
