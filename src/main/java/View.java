import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View {

    public static void main(String[] args) {
        int number = 0;
        Sort sort = new Sort();
        printf(ReadFile.getDrugList());
        while (true){
            printTemplate();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String str = scanner.next();
                Pattern compile = Pattern.compile("^[0-9]*$");
                boolean matches = compile.matcher(str).matches();
                if(!matches){
                    System.out.println("请输入正确数字");
                    printTemplate();
                    continue;
                }
                number = Integer.parseInt(str);
                switch (number){
                    case 1 : printf(sort.sortByUnitPrice(ReadFile.getDrugList()));break;
                    case 2 : printf(sort.sortByNumberOfSales(ReadFile.getDrugList()));break;
                    case 3 : printf(sort.directInsertionSortByUnitPrice(ReadFile.getDrugList()));break;
                    case 4 : printf(sort.directSelectionSortBySales(ReadFile.getDrugList()));break;
                    case 5 : return;
                    default:
                        System.out.println("请输入规定的数字");
                }
                printTemplate();
            }
        }
    }

    private static void printTemplate(){
        System.out.println();
        System.out.println("*------------药店的药品销售统计系统------------*\n");
        System.out.println("*            1.按药品单价排序(冒泡排序)        *\n");
        System.out.println("*            2.按药品销售数量排序(快速排序)      *\n");
        System.out.println("*            3.按药品单价排序(直接插入排序)     *\n");
        System.out.println("*            4.按药品销售额排序(直接选择排序)    *\n");
        System.out.println("*            5.退出程序                      *\n");
        System.out.println("*-------------------------------------------*\n");
    }

    private static void printf(List<Drug> drugs){
        System.out.println("---------------------------------------------");
        System.out.println("药品编号\t药品名称\t药品单价\t药品销售数量\t药品销售额\t");
        for (Drug drug : drugs){
            String drugNumbering = drug.getDrugNumbering();
            String drugName = drug.getDrugName();
            Integer drugUnitPrice = drug.getDrugUnitPrice();
            Integer numberOfSales = drug.getNumberOfSales();
            Integer sales = drug.getSales();
            System.out.println(drugNumbering+"\t"+drugName+"\t\t"+drugUnitPrice+"\t\t"+numberOfSales+"\t\t"+sales);
        }
        System.out.println("---------------------------------------------");
    }
}
