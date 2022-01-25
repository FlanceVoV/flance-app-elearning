package com.flance.elearning.gateway;

import com.flance.elearning.gateway.route.RouteEntity;
import com.flance.web.utils.RsaUtil;
import com.flance.web.utils.web.request.GatewayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

public class RsaSendDemo {

    private final static String SELF_PRI_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNn7ZWwNeuqaQDSuS46UduNGGzB0mx5gEqBs+qg4uQDlm9jGSZeCepaHrXyTIVK5vucGocTRzIHXuiP7zOy2orsTecCPte85MlE2jTEbq5kRADTAD6BD7PximIevdM+00tVW1LkXtiOOPL1BCaeCSwcb/B7R3vmovm+4e0gKGVVZtsyYCpTLUGz0/WzQz0fz7q3/bY5l5iCy4jdZ7oxLBGxontWbrbgS4nYhBcMWJRqeLYlHj9aoaOl1YwAllVQ1yTS01FqvK5sSZThNEIr8VDAjNyF/hKSupzwfKolPxyfIX+9ClJC3IIlf3AN9ae0yCIArgmUogNh9YKa5h/6H9rAgMBAAECggEABIQ1Ymrf9ff+/QPka2k1F/SfsP/of73gB6ET+lIbn0p13i+d/a7xRNvKHxuRd09et6nqGGD1LASUrsXtlYKzLhWGunkm2w5VgPcvfpuwIr7XjeNcnJyKDEI7jNivDkttWKbCx4gqMSWzTgrDRMnUEbRu8xZGwB9jmsgmucDoZkS6T40TaA1GegbtyDiCiz+3USQjMtrzWQ5lATLyk1Ow2CgrWnq0Pt9ovNv1nvV8knErkdBOnmTTq80s6l6xNmBATurgkiA+TG8UmB030hed9B2+/xDWFA6XgNFVz0IgAbz5aNtdHP44BXAG5SXkKQXcKvCLKSy7IoKMAxL01frawQKBgQDh7hnmTuvu9wWzyUH0KiiW2IWm2Id0wlr32Jp5aeBC1VWhWd5FOYLpGIUNMRCIuhSJHYW/GceQbO/wqON6+KOBySvlEvxog+m13cNFoa0l2BmCFVpZijmsF8fEIeARC35qER9q8GHGOmP2ozCx2h4rhCyQk2hjexRJzCYV6Z3F2wKBgQCgeSBrbKrvywWm757Yot2RrIJya+Wf4pktRy/vkTueNkcT23+JCakQ2GSrmXoUJm+fbakCEj/7sF8Kc9DFu72obSGsqxw8tvUft27AKB7KE31BzHhlj7mYlTLweXxriqOShKQ972el99XgQ2SQciW+xv7O7VL0Z56ZhLS9gvoJsQKBgHqVvTnIIp2TLGXjUkTPxxwpuULRA5YnikImJZKxDrxUklSstTwsO0qMQkzpDUaSaGgJO7N3ol9LrFiQ2nSzicv2wjlVttxijqFeBQC3+4GoIhcBzPb+V9J3SK2zj6bP7LRSPBDDAtoSfoCpBNfLOEl2OtPrF126v0RXX2bOTgu3AoGAWNFRyUNXBOuYkEHV6E+UVNlnRc9EQ48WesII3Q7EMZgXFP2LBB0Nrx4l8fg7YkW3yETYoyXYtgRzRgS+C4MSwNLOLZRzR4N3/nr3WHGcQPoyfKWgCY5YCgSiMgj7fUY5rJGvmfwUoP6gKMUENxKGo6XeSEeAf3eOh6e0paOForECgYBVReBXtKaRfq1EJHVDm18GLNhwK8PP6MUFKGB8U4E6S/zlbQSFrbdgiGhGN7bdKyksSwxvMpAVDsKRrSXQNRWrNz7NkpHZdf05/7LEpwUYhx/QOOIMq4wIMrzEFv69qDhSKfTr3VvUISVF9XT5ghj1vNg5K6ZEzllJtAMZNpQcBg==";

    private final static String SELF_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjZ+2VsDXrqmkA0rkuOlHbjRhswdJseYBKgbPqoOLkA5ZvYxkmXgnqWh618kyFSub7nBqHE0cyB17oj+8zstqK7E3nAj7XvOTJRNo0xG6uZEQA0wA+gQ+z8YpiHr3TPtNLVVtS5F7Yjjjy9QQmngksHG/we0d75qL5vuHtIChlVWbbMmAqUy1Bs9P1s0M9H8+6t/22OZeYgsuI3We6MSwRsaJ7Vm624EuJ2IQXDFiUani2JR4/WqGjpdWMAJZVUNck0tNRaryubEmU4TRCK/FQwIzchf4Skrqc8HyqJT8cnyF/vQpSQtyCJX9wDfWntMgiAK4JlKIDYfWCmuYf+h/awIDAQAB";

    private final static String FLANCE_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsbH+ojJbMf/HdEfBhgpttOrYuVZmM5Gpt0+sHk1HUjTTjmw3a+ITR9VnDWTUWf6DpMqgZPBM9b5Rwj3HSMBXUslIKVWqQnMMMLtTmOvhYZS/ifiYC+xdbDj2RcrmwPGtA1687WW1b7JvVHUG6ki9Xqo3sleXFY8fB4o3SwlOvna+LdO0+ortNg3V8F5XRCQzhyms54wJ/+s6JN2TyAUjonpOTRMjRZCf/fDxfsTlcHTIcDmWPj9NoyjnZi6780aHIWlXyStJ9sTX44NWtEqDSEsKtGY64lBBsy6li5m8lTV5quK/A07ZpJIGLSIBSC3UEkTLz3tBFNtHlMJJLNO/YQIDAQAB";

    private final static String FLANCE_PRI_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxsf6iMlsx/8d0R8GGCm206ti5VmYzkam3T6weTUdSNNOObDdr4hNH1WcNZNRZ/oOkyqBk8Ez1vlHCPcdIwFdSyUgpVapCcwwwu1OY6+FhlL+J+JgL7F1sOPZFyubA8a0DXrztZbVvsm9UdQbqSL1eqjeyV5cVjx8HijdLCU6+dr4t07T6iu02DdXwXldEJDOHKaznjAn/6zok3ZPIBSOiek5NEyNFkJ/98PF+xOVwdMhwOZY+P02jKOdmLrvzRochaVfJK0n2xNfjg1a0SoNISwq0ZjriUEGzLqWLmbyVNXmq4r8DTtmkkgYtIgFILdQSRMvPe0EU20eUwkks079hAgMBAAECggEBAIVUPvFIw3CSsP+oz6ZZsNNs20zFbU4IX8WxvD3IUll2Vb6pqDQEn97oWriMDWGxPOmrOApE3BoPwZzzadJGr77oVILfSi8tz9nI1QMLCkODruxBYSShJ8AKRY88nUPskprSvQOLq0WyJyLB5HxqM90R71SbsDt29htcM/zTcQgrIIYBRHrCtTQx3Di/NaMx2JbIHEbFrBh6fqO2+b/aPgpw5m3WrfzqvAcrkabVxi9NQgKT7OvfR4XOfj1oT82T+C7mGDB92wFEZaRuY2ry5YuHhb5iBVammigc4UqlMaTTpRBeo1DOd8W4G3wTOXA7wiXV1o389amCvJMYURhDyIECgYEA+ifQwKR4NLsaTYU/4SMWGdX20i2cAtuaciXf5jem9JieOeGEOcAWiQg2yTeBlh3xRfIQ6zSyE7J73SFFdVUq4255OXXqftsdIzajziJa7cNNpckIhKhBDhhB/q4JdsMMO2a9KyYz0y2AJLGa7TF5oDndqCIhoL6T5JBR7vucFAkCgYEAtdjLFMJSEUToTnudVGm2drBfWYzlQeK3grv7M+U0eUsbWVgCVzFywTUDcXOsUe4dFyVYQ5Ws5x4NJzG6vQCwpZw6WbOrBPDdZ/nkAEJwRh2FKP+xB7fTiV16T22Mdd9LWoDkWRc/UYjiqp7nabLzXsQG04bEB0cwlYQ12077FpkCgYAYEfCyOKEgYch8IRAud5PO1Jm1S5IxbDQGO8K5gi1cZ7sB0sNIU0VX1iR/ZAniCeuHUW1zVFS2NHxaoLLwQUupKp4be08e+bJqCv3j/cZGDn7QLvHU4eOwmYDwIorilI3+wTn+huSBs2UbIsPHgvUzB55eaTpXHz9XxNM9bZRtEQKBgEJ6DFN8bi/t9taqDevL8W4WL+U2wqCBVwCt47km8zXcJRVWPRTO+Np0nNueo8IXv/60Ij4iu2CJ9dj8Lv3lAK6qHBKqwbw+qVHXYmhN4WlgZUuFnZvqsaQnzgy3SX/Vr2BYeiGvg/A0kFg7WvGi/6EHHE+7lnHqrnIaMO4JQ3URAoGASgs2rsScEUm+93cQGkVi2XFVczTsmMzR3wmJvU8tlhBeYg6axaNyS9FHho7mUlbg51wb8jzPj5lcNxE72Yf93woj33XOlaYGpKCBXdE+dQ4sBZ7Hx2/9JF0TIACh0YNx3m6DsP2HuAq9W6N8YGxE5O7OFWuXnyf9RtaXk0c8d9I=";

    public static void main(String[] args) throws Exception {

        System.out.println(getSend());
    }

    private static String getResponse(String result) {

        return result;
    }

    private static String getSend() throws Exception {
        GatewayRequest gatewayRequest = new GatewayRequest();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setRouteName("测试瞅瞅测试瞅瞅");
        Long timestamp = System.currentTimeMillis();

        String data = gson.toJson(routeEntity);
        // 转byte
        byte[] dataBytes = Base64Utils.encode(data.getBytes(StandardCharsets.UTF_8));

        // 使用flance的公钥加密
        byte[] encodeDataBytes = RsaUtil.encryptByPublicKey(dataBytes, FLANCE_PUB_KEY);
        String enCodeStr = Base64Utils.encodeToString(encodeDataBytes);

        // 待签名
        String signData = enCodeStr + timestamp;

        // 使用自己的私钥加签
        byte[] signBytes = RsaUtil.sign(signData.getBytes(StandardCharsets.UTF_8), SELF_PRI_KEY);
        String signStr = Base64Utils.encodeToString(signBytes);

        byte[] signDataBytes = (enCodeStr + timestamp).getBytes(StandardCharsets.UTF_8);
        System.out.println(RsaUtil.verify(signDataBytes, signStr, SELF_PUB_KEY));

        byte[] de = RsaUtil.decryptByPrivateKey(Base64Utils.decodeFromString(enCodeStr), FLANCE_PRI_KEY);
        System.out.println(new String(Base64Utils.decode(de)));

        gatewayRequest.setData(enCodeStr);
        gatewayRequest.setSign(signStr);
        gatewayRequest.setTimestamp(timestamp);

        return gson.toJson(gatewayRequest);
    }

    private static void checkSign() {
        String sign = "";

    }

}
