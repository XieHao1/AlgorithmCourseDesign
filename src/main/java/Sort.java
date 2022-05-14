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
     * 对销售额进行快速排序
     * @param drugs 商品列表
     * @return 快速排序后的商品列表
     */
    public List<Drug> sortByNumberOfSales(List<Drug> drugs){
        quickSortByNumberOfSales(drugs,0,drugs.size()-1);
        return drugs;
    }

    private static void quickSortByNumberOfSales(List<Drug> drugs,int left,int right){
        if(left >= right) return;
        //以作边的数为基础
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
