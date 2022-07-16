import com.dataworld.db.Products;
import com.dataworld.db.Users;
import com.dataworld.user.Admin;
import com.dataworld.user.CommonUser;
import com.dataworld.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminTest {
    Admin admin = new Admin("admin", "admin");
    Users users;

    Products products;

    @Before
    public void init() {
        users = Users.getInstance();
        users.regUser(new CommonUser("c1", "1234"));
        users.regUser(new CommonUser("c2", "1234"));
        users.regUser(new CommonUser("c3", "1234"));
        users.regUser(new CommonUser("c4", "1234"));

        products = Products.getInstance();
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
    }

    @Test
    public void testDelProduct() {
    }

    @Test
    public void testSetStandard() {
    }
}
