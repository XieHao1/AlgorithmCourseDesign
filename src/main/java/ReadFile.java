import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private static final String FILE = "D:\\JAVA project\\CourseDesign1\\drug.txt";

    public static List<Drug> getDrugList(){
        List<Drug> list = new ArrayList<>();
        FileReader file = null;
        BufferedReader in = null;
        String str = null;
        try {
            file = new FileReader(FILE);
            in = new BufferedReader(file);
            while ((str = in.readLine()) != null){
                Drug drug = JSON.parseObject(str, Drug.class);
                list.add(drug);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
