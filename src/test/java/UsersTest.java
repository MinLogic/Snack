import com.dataworld.service.db.Users;
import com.dataworld.service.user.Admin;
import com.dataworld.service.user.Approver;
import com.dataworld.service.user.CommonUser;
import org.junit.Before;

public class UsersTest {
    Users users;
    @Before
    public void init(){
        users = Users.getInstance();

        users.regUser(new Admin("admin", "1234"));
        users.regUser(new CommonUser("common", "1234"));
        users.regUser(new Approver("approver", "1234"));

    }
}
