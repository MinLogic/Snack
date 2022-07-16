import com.dataworld.product.Product;
import com.dataworld.user.Admin;
import com.dataworld.user.CommonUser;
import com.dataworld.user.User;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestHandlerTest {

    @Test
    public void testFile(){
        File file = new File("");
    }

    @Test
    public void testTest(){
        Map<String, Object> map = new HashMap<>();
        String[] bplc = {"0101000001", "0101000002"};
        map.put("BPLC", bplc);
        String test = "";
        String test2 ="1,2,3,4,5";
        String[] testArr = test.split(",");
        String[] testArr2 = test2.split(",");

        if(testArr == null)
        for (String item : testArr) {
            System.out.println("item = " + item);
        }
        for (String item : testArr2) {
            System.out.println("item2 = " + item);
        }
    }

    @Test
    public void listRemoveObjectTest(){
        Product temp = new Product("A", 1234);
        List<Product> tempList = new ArrayList<>();
        tempList.add(temp);

        System.out.println("tempList = " + tempList.size());
        tempList.remove(temp);
        System.out.println("tempList = " + tempList.size());
    }


    @Test
    public void localDateTeat(){
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        String dateFormat = localDate.format(DateTimeFormatter.ofPattern("dd"));

        System.out.println("dateFormat = " + dateFormat);

        int intdate = Integer.parseInt(dateFormat);

        System.out.println("intdate = " + intdate);
    }

    @Test
    public void extendsTest() {
        User common = new CommonUser("abc", "1234");
        Admin admin = new Admin("aaaa", "1234");

        User temp = common;
        System.out.println(temp.getUserId());
        admin.regUser(new CommonUser("aadd", "1234"));
    }

}
