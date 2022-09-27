import com.dataworld.service.db.Products;
import com.dataworld.service.product.Product;
import com.dataworld.service.user.Auth;
import com.dataworld.service.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ProductsTest {

    Products products;
    public static int a = 1;

    @Before
    public void init() {
        products = new Products();
        products.regProduct(new Product("aaa", 1234));
        products.regProduct(new Product("bbb", 1234));
        products.regProduct(new Product("ccc", 1234));
    }
    @Test
    public void delProductTest() {
        ArrayList<Product> aaaa = products.products;

        String id = aaaa.get(1).getProductId();
    }

    @Test
    public void testTest() {
        ArrayList<Product> list = products.products;
        Product item = list.get(1);
        System.out.println(list.indexOf(item));
        Auth auth = Auth.ADMIN;

        User user = new User("1234","1234",Auth.ADMIN);
        System.out.println(user.getAuth());

    }

    @Test
    public void replaceTest() {
        String target = "SESSION-ID=sdas9d81023j89as0d; Path=/";
        String replacedTarget = target.split(" ")[0]
                .split("=")[1]
                .replaceAll("[^A-Za-z0-9]", "");
        System.out.println("SessionID : " + replacedTarget);
    }
}
