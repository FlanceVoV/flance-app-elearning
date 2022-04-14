package com.flance.tenant.gateway;

import com.flance.tenant.gateway.route.RouteEntity;
import com.flance.web.utils.RsaUtil;
import com.flance.web.utils.web.request.GatewayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

public class RsaSendDemo {

    private final static String SELF_PRI_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNn7ZWwNeuqaQDSuS46UduNGGzB0mx5gEqBs+qg4uQDlm9jGSZeCepaHrXyTIVK5vucGocTRzIHXuiP7zOy2orsTecCPte85MlE2jTEbq5kRADTAD6BD7PximIevdM+00tVW1LkXtiOOPL1BCaeCSwcb/B7R3vmovm+4e0gKGVVZtsyYCpTLUGz0/WzQz0fz7q3/bY5l5iCy4jdZ7oxLBGxontWbrbgS4nYhBcMWJRqeLYlHj9aoaOl1YwAllVQ1yTS01FqvK5sSZThNEIr8VDAjNyF/hKSupzwfKolPxyfIX+9ClJC3IIlf3AN9ae0yCIArgmUogNh9YKa5h/6H9rAgMBAAECggEABIQ1Ymrf9ff+/QPka2k1F/SfsP/of73gB6ET+lIbn0p13i+d/a7xRNvKHxuRd09et6nqGGD1LASUrsXtlYKzLhWGunkm2w5VgPcvfpuwIr7XjeNcnJyKDEI7jNivDkttWKbCx4gqMSWzTgrDRMnUEbRu8xZGwB9jmsgmucDoZkS6T40TaA1GegbtyDiCiz+3USQjMtrzWQ5lATLyk1Ow2CgrWnq0Pt9ovNv1nvV8knErkdBOnmTTq80s6l6xNmBATurgkiA+TG8UmB030hed9B2+/xDWFA6XgNFVz0IgAbz5aNtdHP44BXAG5SXkKQXcKvCLKSy7IoKMAxL01frawQKBgQDh7hnmTuvu9wWzyUH0KiiW2IWm2Id0wlr32Jp5aeBC1VWhWd5FOYLpGIUNMRCIuhSJHYW/GceQbO/wqON6+KOBySvlEvxog+m13cNFoa0l2BmCFVpZijmsF8fEIeARC35qER9q8GHGOmP2ozCx2h4rhCyQk2hjexRJzCYV6Z3F2wKBgQCgeSBrbKrvywWm757Yot2RrIJya+Wf4pktRy/vkTueNkcT23+JCakQ2GSrmXoUJm+fbakCEj/7sF8Kc9DFu72obSGsqxw8tvUft27AKB7KE31BzHhlj7mYlTLweXxriqOShKQ972el99XgQ2SQciW+xv7O7VL0Z56ZhLS9gvoJsQKBgHqVvTnIIp2TLGXjUkTPxxwpuULRA5YnikImJZKxDrxUklSstTwsO0qMQkzpDUaSaGgJO7N3ol9LrFiQ2nSzicv2wjlVttxijqFeBQC3+4GoIhcBzPb+V9J3SK2zj6bP7LRSPBDDAtoSfoCpBNfLOEl2OtPrF126v0RXX2bOTgu3AoGAWNFRyUNXBOuYkEHV6E+UVNlnRc9EQ48WesII3Q7EMZgXFP2LBB0Nrx4l8fg7YkW3yETYoyXYtgRzRgS+C4MSwNLOLZRzR4N3/nr3WHGcQPoyfKWgCY5YCgSiMgj7fUY5rJGvmfwUoP6gKMUENxKGo6XeSEeAf3eOh6e0paOForECgYBVReBXtKaRfq1EJHVDm18GLNhwK8PP6MUFKGB8U4E6S/zlbQSFrbdgiGhGN7bdKyksSwxvMpAVDsKRrSXQNRWrNz7NkpHZdf05/7LEpwUYhx/QOOIMq4wIMrzEFv69qDhSKfTr3VvUISVF9XT5ghj1vNg5K6ZEzllJtAMZNpQcBg==";

    private final static String SELF_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjZ+2VsDXrqmkA0rkuOlHbjRhswdJseYBKgbPqoOLkA5ZvYxkmXgnqWh618kyFSub7nBqHE0cyB17oj+8zstqK7E3nAj7XvOTJRNo0xG6uZEQA0wA+gQ+z8YpiHr3TPtNLVVtS5F7Yjjjy9QQmngksHG/we0d75qL5vuHtIChlVWbbMmAqUy1Bs9P1s0M9H8+6t/22OZeYgsuI3We6MSwRsaJ7Vm624EuJ2IQXDFiUani2JR4/WqGjpdWMAJZVUNck0tNRaryubEmU4TRCK/FQwIzchf4Skrqc8HyqJT8cnyF/vQpSQtyCJX9wDfWntMgiAK4JlKIDYfWCmuYf+h/awIDAQAB";

    private final static String SELF2_PRI_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCDkbaqR2HMx+Q3aR4yB6gbMTLBGFOigzzV1PE+8YHhpM1bAYPeV/X3ZcIvZKZdC9c0ufSOc1b0pVTvmRUu5thXHPyHPkQE9PHBf3ROg2dI+3ilOjTFTxk2Vo5CHI7PeWh/Udp1doALiMbpTubAgIZj8UzWaUuyZ/rcBrhdZb97mXCxsZEhEGWIO3WCTIntWH4hJL75q9IEqJYRnvG6H8AxFa2iYFxGFhAQETnC/vB+nCn/W2KSiAi7q14CmdxZwFqiRIKuhdN11yIpNMR8XMlmva0eh8ZS+QoTQheuGwYPa8g50mTi+vBkmds+Jbey2/jOPcnfVjGsrjw0m9aHXnDAgMBAAECggEAB/zKezlxt9D6+lGyfTyFLQMhHvrY4xL1cqiFW46+/c1VEy3cPW0N5tsUIJRMAaKyGfhWBoJIS4BmbWs/DDktdNBRyqfe4A7nrcx/Zy8ykNkZDhZpKjWerO7wbJpJMbw+czF0Blr89Y/f1h3SyFVaPamnydySmYoGiVYsQHaRXG0GYjsCmnEZPdoasvIbjXmTcrPGhjZqTD451hhHQ0A3DtnDO6ElM5fNQ/BraZCkMzr2Jwf7XKfXVSYI1Euxb6KUf/a0TvAIBg6jp7Wv4ombY1LFz9n1O6LQcA0vwoKNvc0zzjNZMc2dZlEMU+mGDw3OHLjEGz9oFLxvnj8GrUBfQQKBgQC+NiXsX/KAgw2NZAwSinZVkxQfrBwABaZNqx1qOrXYVi7HyVwZhF/oE/MwCdpUXafTyaKU/iYKa+TH59MvPQxtiBZSyNiJjYEJMyplpymLBVcKNWZilLbiNmC0aT9GAauyrQLvUl1iAVyOD5Pq23T4mPFYQVrg9gg3/cQvY7gGoQKBgQCvCcXg3EGinLCA4R1Wl+U/IiI0eSMfiiIqS/fx1wcQTk70SK1iiP3WZhJ7M5AODfC0RlYdQtukcIsztbU7roh9dj9Wx/9CL5lxxvylwS900bS++x3YBR6jgP0x0tqCGS55JsvG4MXFmukqx00Dfko+ZWHV+lPdwsSO5govJ1354wKBgH3u38DV7XpESi64dH26Coqxq/skOg2Rr/9wMTNp14d519MSb9W9HLpMqw+9Fj4RG9JOh0PZ2FnCAWCRDfMSmi3SkeURcLvxYeMzaviOaiTOzkfF/xl5mHPAyNnpbKju5jyP64eDoqwGdr7fdXFjBtioefGSo5aZjet0KfWuMeLBAoGBAKa/d6vkB/8CqD7OteVFZNYFDXLRp/0m2a9Tmcvg3dDR2PNsvQgumysBKEAH+gb5jsIec3ECvT1lHadQRmuptEtZN7PTaT/DGrnCJ/M8G5p9IGQD1AVzsyFuA0bQqOrhVF2D8QLwJFhAYDopjRtz1wSkDlULWZPcNOYxDaioJyWjAoGAXOJN+n+bdhrGFvDiDL0bjKld0oP97NQiyT1+GEFS/MS10P3O4/FLTW78Sa4+FzkGxt6ZDufocopWBNFT//mmwAqSl95lxLVvBph7+Dp+29DxT1vNO4TbJS07r7QE1TtYV+EAZrmXIIQQMEvSl9ISg13kzM3HAyoh1xY2Av+t6U8=";

    private final static String SELF2_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgg5G2qkdhzMfkN2keMgeoGzEywRhTooM81dTxPvGB4aTNWwGD3lf192XCL2SmXQvXNLn0jnNW9KVU75kVLubYVxz8hz5EBPTxwX90ToNnSPt4pTo0xU8ZNlaOQhyOz3lof1HadXaAC4jG6U7mwICGY/FM1mlLsmf63Aa4XWW/e5lwsbGRIRBliDt1gkyJ7Vh+ISS++avSBKiWEZ7xuh/AMRWtomBcRhYQEBE5wv7wfpwp/1tikogIu6teApncWcBaokSCroXTddciKTTEfFzJZr2tHofGUvkKE0IXrhsGD2vIOdJk4vrwZJnbPiW3stv4zj3J31YxrK48NJvWh15wwIDAQAB";

    private final static String FLANCE_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsbH+ojJbMf/HdEfBhgpttOrYuVZmM5Gpt0+sHk1HUjTTjmw3a+ITR9VnDWTUWf6DpMqgZPBM9b5Rwj3HSMBXUslIKVWqQnMMMLtTmOvhYZS/ifiYC+xdbDj2RcrmwPGtA1687WW1b7JvVHUG6ki9Xqo3sleXFY8fB4o3SwlOvna+LdO0+ortNg3V8F5XRCQzhyms54wJ/+s6JN2TyAUjonpOTRMjRZCf/fDxfsTlcHTIcDmWPj9NoyjnZi6780aHIWlXyStJ9sTX44NWtEqDSEsKtGY64lBBsy6li5m8lTV5quK/A07ZpJIGLSIBSC3UEkTLz3tBFNtHlMJJLNO/YQIDAQAB";

    private final static String FLANCE_PRI_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxsf6iMlsx/8d0R8GGCm206ti5VmYzkam3T6weTUdSNNOObDdr4hNH1WcNZNRZ/oOkyqBk8Ez1vlHCPcdIwFdSyUgpVapCcwwwu1OY6+FhlL+J+JgL7F1sOPZFyubA8a0DXrztZbVvsm9UdQbqSL1eqjeyV5cVjx8HijdLCU6+dr4t07T6iu02DdXwXldEJDOHKaznjAn/6zok3ZPIBSOiek5NEyNFkJ/98PF+xOVwdMhwOZY+P02jKOdmLrvzRochaVfJK0n2xNfjg1a0SoNISwq0ZjriUEGzLqWLmbyVNXmq4r8DTtmkkgYtIgFILdQSRMvPe0EU20eUwkks079hAgMBAAECggEBAIVUPvFIw3CSsP+oz6ZZsNNs20zFbU4IX8WxvD3IUll2Vb6pqDQEn97oWriMDWGxPOmrOApE3BoPwZzzadJGr77oVILfSi8tz9nI1QMLCkODruxBYSShJ8AKRY88nUPskprSvQOLq0WyJyLB5HxqM90R71SbsDt29htcM/zTcQgrIIYBRHrCtTQx3Di/NaMx2JbIHEbFrBh6fqO2+b/aPgpw5m3WrfzqvAcrkabVxi9NQgKT7OvfR4XOfj1oT82T+C7mGDB92wFEZaRuY2ry5YuHhb5iBVammigc4UqlMaTTpRBeo1DOd8W4G3wTOXA7wiXV1o389amCvJMYURhDyIECgYEA+ifQwKR4NLsaTYU/4SMWGdX20i2cAtuaciXf5jem9JieOeGEOcAWiQg2yTeBlh3xRfIQ6zSyE7J73SFFdVUq4255OXXqftsdIzajziJa7cNNpckIhKhBDhhB/q4JdsMMO2a9KyYz0y2AJLGa7TF5oDndqCIhoL6T5JBR7vucFAkCgYEAtdjLFMJSEUToTnudVGm2drBfWYzlQeK3grv7M+U0eUsbWVgCVzFywTUDcXOsUe4dFyVYQ5Ws5x4NJzG6vQCwpZw6WbOrBPDdZ/nkAEJwRh2FKP+xB7fTiV16T22Mdd9LWoDkWRc/UYjiqp7nabLzXsQG04bEB0cwlYQ12077FpkCgYAYEfCyOKEgYch8IRAud5PO1Jm1S5IxbDQGO8K5gi1cZ7sB0sNIU0VX1iR/ZAniCeuHUW1zVFS2NHxaoLLwQUupKp4be08e+bJqCv3j/cZGDn7QLvHU4eOwmYDwIorilI3+wTn+huSBs2UbIsPHgvUzB55eaTpXHz9XxNM9bZRtEQKBgEJ6DFN8bi/t9taqDevL8W4WL+U2wqCBVwCt47km8zXcJRVWPRTO+Np0nNueo8IXv/60Ij4iu2CJ9dj8Lv3lAK6qHBKqwbw+qVHXYmhN4WlgZUuFnZvqsaQnzgy3SX/Vr2BYeiGvg/A0kFg7WvGi/6EHHE+7lnHqrnIaMO4JQ3URAoGASgs2rsScEUm+93cQGkVi2XFVczTsmMzR3wmJvU8tlhBeYg6axaNyS9FHho7mUlbg51wb8jzPj5lcNxE72Yf93woj33XOlaYGpKCBXdE+dQ4sBZ7Hx2/9JF0TIACh0YNx3m6DsP2HuAq9W6N8YGxE5O7OFWuXnyf9RtaXk0c8d9I=";

    public static void main(String[] args) throws Exception {
//        RsaUtil.generateKeyPair();
        System.out.println(decode());
//        System.out.println(getSend());
    }

    private static String getResponse(String result) {

        return result;
    }

    private static String decode() throws Exception {
        GatewayRequest gatewayRequest = new GatewayRequest();
        String data = "cwfiCdwF2zfUxUIAjDqFmbetu/B4NAvU5a5WBtlTOnfdIVP/o2ThEm7o4ziaoG222VzFpeOBZxP1geRVLopv3XP5Cv9FWIALnEdFttL12lPbWEiBmBmXBb3RYaPD/RiJ1ZBLcK8UeJFbHMsErJeqQB+c7ukejAaoBrtfa3nqVlkm8x7bbxm9BU3i0iAdHe0h2BUBKcdlUQEEIz6lyTcycUfBu3ksJL5ZcQUBoXuJuFeEmjN9YVwS0Ibt4gJFYkjbC2GlkKfZyRntWv8t52bMJnQ5E+ZV/+Q/0CTvEvzWDSHiDWxCxHYRbZXGTtTEemYhZcGD9b/VVTaYpP9jvfhCmQ==";
        String sign = "oz3j+IpKdFwKy8aoGoYitN0l6hfTHcLHjDK18D6DhQOxiMUuyIm7Rr0gkm5B09bFvSJ17B1cevDJM1+85/iZ2DdZE4Ve4imqCnpkBzk3ScX+HefvSOU0cARUtqk7G110VWB2Dr092iKhRJZO/eqlvbGDQqqS7sYwWgrFYVTFVXFisLegHAZBeDxYajE2tR7KvUoJGfWXxvJ653CcstNpORTu4u7fzxFN0mOnbyLx+ZOfedcoZP6zltX+D3qR3bVThj40PWzfxt9wUvlIuIBHFHlcsB/Qw4b9qn2Mbcj4Di/xiRqoVnvgqPb95cTsBGfo2nHgGqD8bvlvvHysd0chBA==";
        long timestamp = 1649836539602L;

        byte[] signCheck = (data + timestamp).getBytes(StandardCharsets.UTF_8);
        boolean flag = RsaUtil.verify(signCheck, sign, FLANCE_PUB_KEY);
        System.out.println(flag);

        byte[] dataBytes = Base64Utils.decode(data.getBytes(StandardCharsets.UTF_8));
        byte[] decode = RsaUtil.decryptByPrivateKey(dataBytes, SELF_PRI_KEY);

        String result = new String(Base64Utils.decode(decode), StandardCharsets.UTF_8);

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