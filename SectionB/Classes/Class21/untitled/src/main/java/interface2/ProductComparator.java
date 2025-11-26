package interface2;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product thisProduct, Product otherProduct) {
        int result=0;
        if(thisProduct.getId()> otherProduct.getId())
            result=1;
        if(thisProduct.getId()< otherProduct.getId())
            result=-1;
        if(thisProduct.getId()== otherProduct.getId())
            result=0;
        return result;

    }
}
