import com.dataworld.db.Products;
import com.dataworld.db.Users;
import com.dataworld.product.Product;
import com.dataworld.snackworld.Standard;
import com.dataworld.user.Admin;
import com.dataworld.user.CommonUser;
import com.dataworld.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AdminTest {
    Admin admin = new Admin("admin", "admin");
    Users users;
    Admin a1;
    Products products;

    Standard standard;

    @Before
    public void init() {
        standard = Standard.getStandard();

        users = Users.getInstance();
        users.regUser(new CommonUser("c1", "1234"));
        users.regUser(new CommonUser("c2", "1234"));
        users.regUser(new CommonUser("c3", "1234"));
        users.regUser(new CommonUser("c4", "1234"));
        users.regUser(new Admin("a1", "1234"));

        products = Products.getInstance();
        products.regProduct(new Product("itemA", 12345));
        products.regProduct(new Product("itemB", 22345));
        products.regProduct(new Product("itemC", 32345));
        products.regProduct(new Product("itemD", 42345));
        products.regProduct(new Product("itemD", 52345));
        products.regProduct(new Product("itemD", 62345));

        a1 = (Admin) users.retrieveUser("a1");
    }

    @Test
    public void testRegUser() {
        CommonUser commonUser = new CommonUser("common", "1234");
        admin.regUser(commonUser);
        Assert.assertEquals(commonUser, users.retrieveUser("common"));
    }

    @Test
    public void testDelUser() {
        User temp = users.retrieveUser("c1");
        Assert.assertEquals("c1", temp.getUserId());
        admin.delUser("c1");
        User temp2 = users.retrieveUser("c1");
        Assert.assertEquals(null, temp2);
    }

    @Test
    public void testRegProduct() {
        a1.regProduct(new Product("new Item", 1111));

        List<Product> productList = products.searchProductList("new Item");
        String productId = productList.get(0)
                        .getProductId();

        System.out.println("productId = " + productId);

        Assert.assertEquals("new Item", products.retrieveProduct(productId).getProductName());
    }

    @Test
    public void testDelProduct() {
        List<Product> productList = products.searchProductList("itemD");
        for(Product item : productList){
            System.out.println("item.getProductId() = " + item.getProductId());
        }

        a1.delProduct(productList.get(1).getProductId());

        List<Product> productList2 = products.searchProductList("itemD");
        for(Product item : productList2){
            System.out.println("item.getProductId() = " + item.getProductId());
        }

        Assert.assertNotEquals(productList.size(), productList2.size());


    }

    @Test
    public void testSetStandard() {
        System.out.println("standard.getStartDate() = " + standard.getStartDate());
        System.out.println("standard.getEndDate() = " + standard.getEndDate());
        System.out.println("standard.getLimitedAmount() = " + standard.getLimitedAmount());

        a1.setStandard(null, null, 100000);
        Assert.assertEquals(1, standard.getStartDate());
        Assert.assertEquals(31, standard.getEndDate());
        Assert.assertEquals(100000, standard.getLimitedAmount());

        a1.setStandard(null, 5, null);
        Assert.assertEquals(1, standard.getStartDate());
        Assert.assertEquals(5, standard.getEndDate());
        Assert.assertEquals(100000, standard.getLimitedAmount());

        a1.setStandard(31, null, null);
    }
}
