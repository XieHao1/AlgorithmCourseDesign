import java.util.List;

public class Sort {

    /**
     * 对单价进行冒泡排序
     * @param drugs 商品列表
     * @return 对单价进行排序后的商品列表
     */
    public List<Drug> sortByUnitPrice(List<Drug> drugs){
        for(int i = 0; i < drugs.size()-1;i++){
            for (int j = 0; j < drugs.size()-1-i;j++){
                if(drugs.get(j).getDrugUnitPrice() > drugs.get(j+1).getDrugUnitPrice()){
                    Drug drug = drugs.get(j);
                    drugs.set(j, drugs.get(j+1));
                    drugs.set(j+1, drug);
                }
            }
        }
        return drugs;
    }

    /**
     * 对销售数量进行快速排序
     * @param drugs 商品列表
     * @return 快速排序后的商品列表
     */
    public List<Drug> sortByNumberOfSales(List<Drug> drugs){
        quickSortByNumberOfSales(drugs,0,drugs.size()-1);
        return drugs;
    }

    /**
     * 对单价进行直接插入排序
     * @param drugs 商品列表
     * @return 直接插入排序后的商品列表
     */
    public  List<Drug> directInsertionSortByUnitPrice(List<Drug> drugs){

        for (int i = 1; i < drugs.size(); i++) {
            //arr[i] 当前元素  arr[i-1] 他前面的一个元素
            //如果当前元素小于我前一个元素，那就交换位置
            for (int j = i -1 ; j > 0; j--) {
                if (drugs.get(i).getDrugUnitPrice() < drugs.get(j-1).getDrugUnitPrice()) {
                    Drug forwardDrug = drugs.get(i);
                    Drug backDrug = drugs.get(j-1);
                    drugs.set(j-1 , forwardDrug);
                    drugs.set(i , backDrug);
                }
            }
        }
        return drugs;
    }

    /**
     * 对销售量进行直接选择排序
     * @param drugs 商品列表
     * @return 直接选择排序后的商品列表
     */
    public List<Drug> directSelectionSortBySales(List<Drug> drugs){
        for (int i = 0; i < drugs.size(); i++) {
            int index = i; // 记录最小值索引
            for (int j = i+1; j < drugs.size(); j++) {
                if(drugs.get(j).getSales() < drugs.get(index).getSales()){
                    index = j;
                }
            }
            // 交换最小值索引值与开始索引值
            Drug temp = drugs.get(i);
            Drug indexDrug = drugs.get(index);
            drugs.set(i,indexDrug);
            drugs.set(index,temp);
        }
        return drugs;
    }


    private static void quickSortByNumberOfSales(List<Drug> drugs,int left,int right){
        if(left >= right) return;
        //以左边的数为基础
        Drug drugPivot = drugs.get(left);
        int i = left;
        int j = right;
        while (i < j){
            while (drugs.get(j).getNumberOfSales() >= drugPivot.getNumberOfSales() && i < j) --j;
            while (drugs.get(i).getNumberOfSales() <= drugPivot.getNumberOfSales() && i < j) ++i;
            //交换
            if(i < j){
                Drug leftDrug = drugs.get(i);
                Drug rightDrug = drugs.get(j);
                drugs.set(j, leftDrug);
                drugs.set(i, rightDrug);
            }
        }
        drugs.set(left,drugs.get(i));
        drugs.set(i,drugPivot);
        quickSortByNumberOfSales(drugs,left,i - 1);
        quickSortByNumberOfSales(drugs, i + 1,right);
    }
}
