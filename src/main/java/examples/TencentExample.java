package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Tencent;

public class TencentExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Tencent tencent = new Tencent();
        tencent.setAppId("2092215077");
        tencent.setPageUrl("http://lcec.lclog.cn/cargo/NewCargotracking?blno=BANR01XMHB0004&selectstate=BLNO");

        try {
            solver.solve(tencent);
            System.out.println("Captcha solved: " + tencent.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
