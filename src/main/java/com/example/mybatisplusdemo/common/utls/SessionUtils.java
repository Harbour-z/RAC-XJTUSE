package com.example.mybatisplusdemo.common.utls;


import com.example.mybatisplusdemo.model.domain.Admin;
import com.example.mybatisplusdemo.model.domain.AdminInfo;
import com.example.mybatisplusdemo.model.domain.MerchantInfo;
import com.example.mybatisplusdemo.model.domain.UserInfo;
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

    public static UserInfo getCurrentUserInfo() {
        return (UserInfo) session().getAttribute(USERKEY);
    }
    public static MerchantInfo getCurrentMerchantInfo() {
        return (MerchantInfo) session().getAttribute(MERCHANTKEY);
    }
    public static AdminInfo getCurrentAdminInfo() {
        return (AdminInfo) session().getAttribute(ADMINKEY);
    }

    public static void saveCurrentUserInfo(UserInfo user) {
        session().setAttribute(USERKEY, user);
    }

    public static void saveCurrentMerchantInfo(MerchantInfo merchant) {
        session().setAttribute(MERCHANTKEY, merchant);
    }

    public static void saveCurrentAdminInfo(AdminInfo admin) {
        session().setAttribute(ADMINKEY, admin);
    }

}
