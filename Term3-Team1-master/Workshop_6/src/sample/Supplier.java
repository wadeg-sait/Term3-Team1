package sample;

public class Supplier {
    private int SupplierId;
    private String SupName;

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public String getSupName() {
        return SupName;
    }

    public void setSupName(String supName) {
        SupName = supName;
    }

    public Supplier(int supplierId, String supName) {
        SupplierId = supplierId;
        SupName = supName;
    }

    @Override
    public String toString() {
        return SupName;
    }
}
