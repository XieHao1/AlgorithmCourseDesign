import java.io.Serializable;
import java.util.Objects;

public class Drug implements Serializable {
    //药品编号
    private String drugNumbering;
    //药品名称
    private String drugName;
    //药品单价
    private Integer drugUnitPrice;
    //销售数量
    private Integer numberOfSales;
    //销售额
    private Integer sales;

    public Drug() {}

    public Drug(String drugNumbering, String drugName, Integer drugUnitPrice, Integer numberOfSales, Integer sales) {
        this.drugNumbering = drugNumbering;
        this.drugName = drugName;
        this.drugUnitPrice = drugUnitPrice;
        this.numberOfSales = numberOfSales;
        this.sales = sales;
    }

    public String getDrugNumbering() {
        return drugNumbering;
    }

    public void setDrugNumbering(String drugNumbering) {
        this.drugNumbering = drugNumbering;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getDrugUnitPrice() {
        return drugUnitPrice;
    }

    public void setDrugUnitPrice(Integer drugUnitPrice) {
        this.drugUnitPrice = drugUnitPrice;
    }

    public Integer getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(Integer numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(drugNumbering, drug.drugNumbering) && Objects.equals(drugName, drug.drugName) && Objects.equals(drugUnitPrice, drug.drugUnitPrice) && Objects.equals(numberOfSales, drug.numberOfSales) && Objects.equals(sales, drug.sales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugNumbering, drugName, drugUnitPrice, numberOfSales, sales);
    }

    @Override
    public String toString() {
        return  "drugNumbering='" + drugNumbering + '\'' +
                ", drugName='" + drugName + '\'' +
                ", drugUnitPrice=" + drugUnitPrice +
                ", numberOfSales=" + numberOfSales +
                ", sales=" + sales + "\n";
    }
}
