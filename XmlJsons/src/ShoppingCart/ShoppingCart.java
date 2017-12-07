package ShoppingCart;

import xmljsons.Product;
import java.util.ArrayList;
import java.util.Comparator;
import com.alibaba.fastjson.annotation.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"title", "cart"})
public class ShoppingCart implements Comparator<Product> {

    @JSONField(ordinal = 1)
    private ArrayList<Product> cart = new ArrayList<Product>();
    @JSONField(ordinal = 2)
    public String title;

    public ShoppingCart() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

   // @XmlElementWrapper(name = "cart")
   // @XmlElement(name = "product")
    public void setCart(ArrayList<Product> products){
        this.cart = products;
    }
    public String getTitle() {
        return title;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public int sumOfShoppingCart() {
        int sum = 0;
        for (int i = 0; i < cart.size(); i++) {
            sum += cart.get(i).getPrice();
        }
        return sum;
    }
    
    
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getTitle().compareTo(p2.getTitle());
    }

    public void addProduct(Product p1) {
        cart.add(p1);
    }

    public boolean addProductByName(String title1) {
        ArrayList<Product> temp = new ArrayList<Product>();
        for (Product i : cart) {

            if (i.getTitle().equals(title1)) {
                temp.add(i);
            }
            return true;
        }
        return false;
    }
    /* 
    public ArrayList<Product> getCollection() {
        return cart;
    }*/

    public ArrayList<Product> theMostExpensiveProduct() {

        //hoppingCart tmp = new 
        ArrayList<Product> temp = new ArrayList<Product>();

        for (Product i : cart) {
            temp.add(i);
        }
        temp.sort(new ComparatorByPriceDesc());
        ArrayList<Product> res = new ArrayList<Product>();
        for (Product i : temp) {

            if (i.getPrice() == temp.get(0).getPrice()) {
                res.add(i);
            }
        }
        return res;
    }

    public void outputShoppingCart() {
        for (Product s : cart) {
            System.out.println(s.toString());
            System.out.println();
        }
    }
}

class ComparatorByPriceDesc implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getPrice() > p2.getPrice()) {
            return -1;
        } else if (p1.getPrice() < p2.getPrice()) {
            return 1;
        } else {
            return (p1.getTitle().compareTo(p2.getTitle()));
        }
    }
}
