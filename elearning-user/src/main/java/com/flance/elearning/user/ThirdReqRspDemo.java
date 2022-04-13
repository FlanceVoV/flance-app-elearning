package com.flance.elearning.user;

import com.flance.web.utils.GsonUtils;
import com.flance.web.utils.RsaUtil;
import com.flance.web.utils.web.request.GatewayRequest;
import com.flance.web.utils.web.response.WebResponse;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ThirdReqRspDemo {

    private final static String SELF_PRI_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNn7ZWwNeuqaQDSuS46UduNGGzB0mx5gEqBs+qg4uQDlm9jGSZeCepaHrXyTIVK5vucGocTRzIHXuiP7zOy2orsTecCPte85MlE2jTEbq5kRADTAD6BD7PximIevdM+00tVW1LkXtiOOPL1BCaeCSwcb/B7R3vmovm+4e0gKGVVZtsyYCpTLUGz0/WzQz0fz7q3/bY5l5iCy4jdZ7oxLBGxontWbrbgS4nYhBcMWJRqeLYlHj9aoaOl1YwAllVQ1yTS01FqvK5sSZThNEIr8VDAjNyF/hKSupzwfKolPxyfIX+9ClJC3IIlf3AN9ae0yCIArgmUogNh9YKa5h/6H9rAgMBAAECggEABIQ1Ymrf9ff+/QPka2k1F/SfsP/of73gB6ET+lIbn0p13i+d/a7xRNvKHxuRd09et6nqGGD1LASUrsXtlYKzLhWGunkm2w5VgPcvfpuwIr7XjeNcnJyKDEI7jNivDkttWKbCx4gqMSWzTgrDRMnUEbRu8xZGwB9jmsgmucDoZkS6T40TaA1GegbtyDiCiz+3USQjMtrzWQ5lATLyk1Ow2CgrWnq0Pt9ovNv1nvV8knErkdBOnmTTq80s6l6xNmBATurgkiA+TG8UmB030hed9B2+/xDWFA6XgNFVz0IgAbz5aNtdHP44BXAG5SXkKQXcKvCLKSy7IoKMAxL01frawQKBgQDh7hnmTuvu9wWzyUH0KiiW2IWm2Id0wlr32Jp5aeBC1VWhWd5FOYLpGIUNMRCIuhSJHYW/GceQbO/wqON6+KOBySvlEvxog+m13cNFoa0l2BmCFVpZijmsF8fEIeARC35qER9q8GHGOmP2ozCx2h4rhCyQk2hjexRJzCYV6Z3F2wKBgQCgeSBrbKrvywWm757Yot2RrIJya+Wf4pktRy/vkTueNkcT23+JCakQ2GSrmXoUJm+fbakCEj/7sF8Kc9DFu72obSGsqxw8tvUft27AKB7KE31BzHhlj7mYlTLweXxriqOShKQ972el99XgQ2SQciW+xv7O7VL0Z56ZhLS9gvoJsQKBgHqVvTnIIp2TLGXjUkTPxxwpuULRA5YnikImJZKxDrxUklSstTwsO0qMQkzpDUaSaGgJO7N3ol9LrFiQ2nSzicv2wjlVttxijqFeBQC3+4GoIhcBzPb+V9J3SK2zj6bP7LRSPBDDAtoSfoCpBNfLOEl2OtPrF126v0RXX2bOTgu3AoGAWNFRyUNXBOuYkEHV6E+UVNlnRc9EQ48WesII3Q7EMZgXFP2LBB0Nrx4l8fg7YkW3yETYoyXYtgRzRgS+C4MSwNLOLZRzR4N3/nr3WHGcQPoyfKWgCY5YCgSiMgj7fUY5rJGvmfwUoP6gKMUENxKGo6XeSEeAf3eOh6e0paOForECgYBVReBXtKaRfq1EJHVDm18GLNhwK8PP6MUFKGB8U4E6S/zlbQSFrbdgiGhGN7bdKyksSwxvMpAVDsKRrSXQNRWrNz7NkpHZdf05/7LEpwUYhx/QOOIMq4wIMrzEFv69qDhSKfTr3VvUISVF9XT5ghj1vNg5K6ZEzllJtAMZNpQcBg==";

    private final static String SELF_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjZ+2VsDXrqmkA0rkuOlHbjRhswdJseYBKgbPqoOLkA5ZvYxkmXgnqWh618kyFSub7nBqHE0cyB17oj+8zstqK7E3nAj7XvOTJRNo0xG6uZEQA0wA+gQ+z8YpiHr3TPtNLVVtS5F7Yjjjy9QQmngksHG/we0d75qL5vuHtIChlVWbbMmAqUy1Bs9P1s0M9H8+6t/22OZeYgsuI3We6MSwRsaJ7Vm624EuJ2IQXDFiUani2JR4/WqGjpdWMAJZVUNck0tNRaryubEmU4TRCK/FQwIzchf4Skrqc8HyqJT8cnyF/vQpSQtyCJX9wDfWntMgiAK4JlKIDYfWCmuYf+h/awIDAQAB";

    private final static String FLANCE_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsbH+ojJbMf/HdEfBhgpttOrYuVZmM5Gpt0+sHk1HUjTTjmw3a+ITR9VnDWTUWf6DpMqgZPBM9b5Rwj3HSMBXUslIKVWqQnMMMLtTmOvhYZS/ifiYC+xdbDj2RcrmwPGtA1687WW1b7JvVHUG6ki9Xqo3sleXFY8fB4o3SwlOvna+LdO0+ortNg3V8F5XRCQzhyms54wJ/+s6JN2TyAUjonpOTRMjRZCf/fDxfsTlcHTIcDmWPj9NoyjnZi6780aHIWlXyStJ9sTX44NWtEqDSEsKtGY64lBBsy6li5m8lTV5quK/A07ZpJIGLSIBSC3UEkTLz3tBFNtHlMJJLNO/YQIDAQAB";


    @PostMapping("/test")
    public WebResponse test(@RequestBody GatewayRequest request) throws Exception {

        String sign = request.getSign();
        String encodeDataStr = request.getData();
        byte[] encodeData = Base64Utils.decode(encodeDataStr.getBytes(StandardCharsets.UTF_8));
        Long timestamp = request.getTimestamp();
        String signData = encodeDataStr + timestamp;
        boolean flag = RsaUtil.verify(signData.getBytes(StandardCharsets.UTF_8), sign, FLANCE_PUB_KEY);

        if (!flag) {
            throw new RuntimeException("123123123");
        }

        byte[] decodeDataBytes = RsaUtil.decryptByPrivateKey(encodeData, SELF_PRI_KEY);

        String data = new String(Base64Utils.decode(decodeDataBytes), StandardCharsets.UTF_8);

        HashMap<String, String> map = GsonUtils.fromString(data, HashMap.class);

        map.put("test", "test");

        String resultData = GsonUtils.toJSONString(map);
        Long resultTimestamp = System.currentTimeMillis();
        byte[] resultDataBytes = Base64Utils.encode(resultData.getBytes(StandardCharsets.UTF_8));


        byte[] resultEncodeDataBytes = RsaUtil.encryptByPublicKey(resultDataBytes, FLANCE_PUB_KEY);
        String dataResponse = Base64Utils.encodeToString(resultEncodeDataBytes);

        String resultSignData = dataResponse + resultTimestamp;
        byte[] signBytes = RsaUtil.sign(resultSignData.getBytes(StandardCharsets.UTF_8), SELF_PRI_KEY);
        String resultSign = Base64Utils.encodeToString(signBytes);



        System.out.println(RsaUtil.verify(signBytes, resultSign, SELF_PUB_KEY));

        WebResponse response = new WebResponse();
        response.setData(dataResponse);
        response.setSign(resultSign);
        response.setSuccess(true);
        response.setCode("000000");
        response.setTimestamp(resultTimestamp);
        return response;
    }
}
