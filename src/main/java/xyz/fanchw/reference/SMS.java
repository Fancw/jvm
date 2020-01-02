package xyz.fanchw.reference;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class SMS {
    public static void main(String[] args) {
        // 短信应用 SDK AppID
        int appid = 1400286886; // SDK AppID 以1400开头
        // 短信应用 SDK AppKey
        String appkey = "107066a31228c8d747094b7b0da90c44";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {"18656380173", "13033130173", "13816118354", "15069002663"};
        // 短信模板 ID，需要在短信应用中申请
        int templateId = 476656; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
        int inform = 477418; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
        // 签名
        String smsSign = "fanchw验证"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
        try {
            String[] params = {"范崇文","测试拍卖"};
            /*SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result = msender.sendWithParam("86", phoneNumbers,
                    templateId, params, smsSign, "", "");*/
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[1],
                    inform, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException | JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
