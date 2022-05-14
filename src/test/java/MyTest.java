import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTest {

    private static final String FILE = "D:\\JAVA project\\CourseDesign1\\drug.txt";

    @Test
    public void test1(){
        FileOutputStream out = null;
        List<Drug> list = new ArrayList<>();
        list.add(new Drug("A101","A",50,100,10000));
        list.add(new Drug("A102","B",60,150,20000));
        list.add(new Drug("A103","C",70,200,30000));
        list.add(new Drug("A104","D",80,250,40000));
        list.add(new Drug("A105","E",90,300,50000));
        list.add(new Drug("A106","F",100,350,60000));
        list.add(new Drug("A107","G",110,400,70000));
        try {
            File file = new File(FILE);
            File f = new File(FILE);
            if(f.exists()){
                f.delete();
            }else {
                file.createNewFile();
            }
            out = new FileOutputStream(FILE,true);
            for (Drug drug : list){
                byte[] bytes = JSON.toJSONBytes(drug);
                out.write(bytes);
                out.write("\n".getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        List<Drug> drugList = ReadFile.getDrugList();
        System.out.println(drugList);
    }

    @Test
    public void sortByUnitPriceTest(){
        System.out.println(new Sort().sortByUnitPrice(ReadFile.getDrugList()));
    }

    @Test
    public void sortByNumberOfSales(){
        System.out.println(new Sort().sortByNumberOfSales(ReadFile.getDrugList()));
    }
}
