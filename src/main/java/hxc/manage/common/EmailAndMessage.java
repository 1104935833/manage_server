package hxc.manage.common;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@Component
public class EmailAndMessage {

    @Value("${mail.user}")
    private String user;

    @Value("${mail.password}")
    private String password;

    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    @Async
    public void sendMail(String mail) throws InterruptedException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress(user));
        // 设置收件人邮箱地址
//        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("1597243156@qq.com"),
//                new InternetAddress("1597243156@qq.com"),
//                new InternetAddress("1597243156@qq.com")});//多个收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));//一个收件人
        // 设置邮件标题
        message.setSubject("审批");
        // 设置邮件内容
        message.setText("您有一个新的申请需要审批，请登录网站进行操作");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect(user, password);// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    @Async
    public void send(String phone){
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
//        Map<String,Object> re = new HashMap<>();
        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        int mobile_code = (int)((Math.random()*9+1)*100000);
        String content = "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。";
//        String content = "您有一个"+mobile_code+"申请需要审批，请登录网站进行操作。";
        NameValuePair[] data ={
                new NameValuePair("account","C90828810"),
                new NameValuePair("password", "3908acb8e6c476589a5337583b8b488d"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String submitResult = method.getResponseBodyAsString();
            Document document = DocumentHelper.parseText(submitResult);
            Element root = document.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            if(code.equals("2")){
                System.out.println("短信提交成功");
            }else {
                System.out.println(code);
            }
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            method.releaseConnection();
//            client.getHttpConnectionManager().closeIdleConnections(0);
        }

    }
}
