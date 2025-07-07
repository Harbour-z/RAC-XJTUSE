package com.example.mybatisplusdemo.common.utls;


import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.model.domain.Merchant;
import com.example.mybatisplusdemo.model.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



public class SessionUtils {
    private static final String USERKEY = "sessionUser";
    private static final String MERCHANTKEY = "sessionMerchant";
    private static final String ADMINKEY = "sessionAdmin";

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    public static User getCurrentUserInfo() {
        return (User) session().getAttribute(USERKEY);
    }

    public static void saveCurrentUserInfo(User user) {
        session().setAttribute(USERKEY, user);
    }

    public static void saveCurrentMerchantInfo(Merchant merchant) {
        session().setAttribute(MERCHANTKEY, merchant);
    }

    public static void saveCurrentAdminInfo(Admin admin) {
        session().setAttribute(ADMINKEY, admin);
    }
}
