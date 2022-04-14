package com.flance.elearning.user.interfaces;

import cn.hutool.core.io.FileUtil;
import com.flance.web.utils.GsonUtils;
import com.flance.web.utils.RsaUtil;
import com.flance.web.utils.web.request.GatewayRequest;
import com.flance.web.utils.web.response.WebResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class TestController {


    private final static String SELF_PRI_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNn7ZWwNeuqaQDSuS46UduNGGzB0mx5gEqBs+qg4uQDlm9jGSZeCepaHrXyTIVK5vucGocTRzIHXuiP7zOy2orsTecCPte85MlE2jTEbq5kRADTAD6BD7PximIevdM+00tVW1LkXtiOOPL1BCaeCSwcb/B7R3vmovm+4e0gKGVVZtsyYCpTLUGz0/WzQz0fz7q3/bY5l5iCy4jdZ7oxLBGxontWbrbgS4nYhBcMWJRqeLYlHj9aoaOl1YwAllVQ1yTS01FqvK5sSZThNEIr8VDAjNyF/hKSupzwfKolPxyfIX+9ClJC3IIlf3AN9ae0yCIArgmUogNh9YKa5h/6H9rAgMBAAECggEABIQ1Ymrf9ff+/QPka2k1F/SfsP/of73gB6ET+lIbn0p13i+d/a7xRNvKHxuRd09et6nqGGD1LASUrsXtlYKzLhWGunkm2w5VgPcvfpuwIr7XjeNcnJyKDEI7jNivDkttWKbCx4gqMSWzTgrDRMnUEbRu8xZGwB9jmsgmucDoZkS6T40TaA1GegbtyDiCiz+3USQjMtrzWQ5lATLyk1Ow2CgrWnq0Pt9ovNv1nvV8knErkdBOnmTTq80s6l6xNmBATurgkiA+TG8UmB030hed9B2+/xDWFA6XgNFVz0IgAbz5aNtdHP44BXAG5SXkKQXcKvCLKSy7IoKMAxL01frawQKBgQDh7hnmTuvu9wWzyUH0KiiW2IWm2Id0wlr32Jp5aeBC1VWhWd5FOYLpGIUNMRCIuhSJHYW/GceQbO/wqON6+KOBySvlEvxog+m13cNFoa0l2BmCFVpZijmsF8fEIeARC35qER9q8GHGOmP2ozCx2h4rhCyQk2hjexRJzCYV6Z3F2wKBgQCgeSBrbKrvywWm757Yot2RrIJya+Wf4pktRy/vkTueNkcT23+JCakQ2GSrmXoUJm+fbakCEj/7sF8Kc9DFu72obSGsqxw8tvUft27AKB7KE31BzHhlj7mYlTLweXxriqOShKQ972el99XgQ2SQciW+xv7O7VL0Z56ZhLS9gvoJsQKBgHqVvTnIIp2TLGXjUkTPxxwpuULRA5YnikImJZKxDrxUklSstTwsO0qMQkzpDUaSaGgJO7N3ol9LrFiQ2nSzicv2wjlVttxijqFeBQC3+4GoIhcBzPb+V9J3SK2zj6bP7LRSPBDDAtoSfoCpBNfLOEl2OtPrF126v0RXX2bOTgu3AoGAWNFRyUNXBOuYkEHV6E+UVNlnRc9EQ48WesII3Q7EMZgXFP2LBB0Nrx4l8fg7YkW3yETYoyXYtgRzRgS+C4MSwNLOLZRzR4N3/nr3WHGcQPoyfKWgCY5YCgSiMgj7fUY5rJGvmfwUoP6gKMUENxKGo6XeSEeAf3eOh6e0paOForECgYBVReBXtKaRfq1EJHVDm18GLNhwK8PP6MUFKGB8U4E6S/zlbQSFrbdgiGhGN7bdKyksSwxvMpAVDsKRrSXQNRWrNz7NkpHZdf05/7LEpwUYhx/QOOIMq4wIMrzEFv69qDhSKfTr3VvUISVF9XT5ghj1vNg5K6ZEzllJtAMZNpQcBg==";

    private final static String SELF_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjZ+2VsDXrqmkA0rkuOlHbjRhswdJseYBKgbPqoOLkA5ZvYxkmXgnqWh618kyFSub7nBqHE0cyB17oj+8zstqK7E3nAj7XvOTJRNo0xG6uZEQA0wA+gQ+z8YpiHr3TPtNLVVtS5F7Yjjjy9QQmngksHG/we0d75qL5vuHtIChlVWbbMmAqUy1Bs9P1s0M9H8+6t/22OZeYgsuI3We6MSwRsaJ7Vm624EuJ2IQXDFiUani2JR4/WqGjpdWMAJZVUNck0tNRaryubEmU4TRCK/FQwIzchf4Skrqc8HyqJT8cnyF/vQpSQtyCJX9wDfWntMgiAK4JlKIDYfWCmuYf+h/awIDAQAB";

    private final static String SELF2_PRI_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCDkbaqR2HMx+Q3aR4yB6gbMTLBGFOigzzV1PE+8YHhpM1bAYPeV/X3ZcIvZKZdC9c0ufSOc1b0pVTvmRUu5thXHPyHPkQE9PHBf3ROg2dI+3ilOjTFTxk2Vo5CHI7PeWh/Udp1doALiMbpTubAgIZj8UzWaUuyZ/rcBrhdZb97mXCxsZEhEGWIO3WCTIntWH4hJL75q9IEqJYRnvG6H8AxFa2iYFxGFhAQETnC/vB+nCn/W2KSiAi7q14CmdxZwFqiRIKuhdN11yIpNMR8XMlmva0eh8ZS+QoTQheuGwYPa8g50mTi+vBkmds+Jbey2/jOPcnfVjGsrjw0m9aHXnDAgMBAAECggEAB/zKezlxt9D6+lGyfTyFLQMhHvrY4xL1cqiFW46+/c1VEy3cPW0N5tsUIJRMAaKyGfhWBoJIS4BmbWs/DDktdNBRyqfe4A7nrcx/Zy8ykNkZDhZpKjWerO7wbJpJMbw+czF0Blr89Y/f1h3SyFVaPamnydySmYoGiVYsQHaRXG0GYjsCmnEZPdoasvIbjXmTcrPGhjZqTD451hhHQ0A3DtnDO6ElM5fNQ/BraZCkMzr2Jwf7XKfXVSYI1Euxb6KUf/a0TvAIBg6jp7Wv4ombY1LFz9n1O6LQcA0vwoKNvc0zzjNZMc2dZlEMU+mGDw3OHLjEGz9oFLxvnj8GrUBfQQKBgQC+NiXsX/KAgw2NZAwSinZVkxQfrBwABaZNqx1qOrXYVi7HyVwZhF/oE/MwCdpUXafTyaKU/iYKa+TH59MvPQxtiBZSyNiJjYEJMyplpymLBVcKNWZilLbiNmC0aT9GAauyrQLvUl1iAVyOD5Pq23T4mPFYQVrg9gg3/cQvY7gGoQKBgQCvCcXg3EGinLCA4R1Wl+U/IiI0eSMfiiIqS/fx1wcQTk70SK1iiP3WZhJ7M5AODfC0RlYdQtukcIsztbU7roh9dj9Wx/9CL5lxxvylwS900bS++x3YBR6jgP0x0tqCGS55JsvG4MXFmukqx00Dfko+ZWHV+lPdwsSO5govJ1354wKBgH3u38DV7XpESi64dH26Coqxq/skOg2Rr/9wMTNp14d519MSb9W9HLpMqw+9Fj4RG9JOh0PZ2FnCAWCRDfMSmi3SkeURcLvxYeMzaviOaiTOzkfF/xl5mHPAyNnpbKju5jyP64eDoqwGdr7fdXFjBtioefGSo5aZjet0KfWuMeLBAoGBAKa/d6vkB/8CqD7OteVFZNYFDXLRp/0m2a9Tmcvg3dDR2PNsvQgumysBKEAH+gb5jsIec3ECvT1lHadQRmuptEtZN7PTaT/DGrnCJ/M8G5p9IGQD1AVzsyFuA0bQqOrhVF2D8QLwJFhAYDopjRtz1wSkDlULWZPcNOYxDaioJyWjAoGAXOJN+n+bdhrGFvDiDL0bjKld0oP97NQiyT1+GEFS/MS10P3O4/FLTW78Sa4+FzkGxt6ZDufocopWBNFT//mmwAqSl95lxLVvBph7+Dp+29DxT1vNO4TbJS07r7QE1TtYV+EAZrmXIIQQMEvSl9ISg13kzM3HAyoh1xY2Av+t6U8=";

    private final static String SELF2_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgg5G2qkdhzMfkN2keMgeoGzEywRhTooM81dTxPvGB4aTNWwGD3lf192XCL2SmXQvXNLn0jnNW9KVU75kVLubYVxz8hz5EBPTxwX90ToNnSPt4pTo0xU8ZNlaOQhyOz3lof1HadXaAC4jG6U7mwICGY/FM1mlLsmf63Aa4XWW/e5lwsbGRIRBliDt1gkyJ7Vh+ISS++avSBKiWEZ7xuh/AMRWtomBcRhYQEBE5wv7wfpwp/1tikogIu6teApncWcBaokSCroXTddciKTTEfFzJZr2tHofGUvkKE0IXrhsGD2vIOdJk4vrwZJnbPiW3stv4zj3J31YxrK48NJvWh15wwIDAQAB";

    private final static String FLANCE_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsbH+ojJbMf/HdEfBhgpttOrYuVZmM5Gpt0+sHk1HUjTTjmw3a+ITR9VnDWTUWf6DpMqgZPBM9b5Rwj3HSMBXUslIKVWqQnMMMLtTmOvhYZS/ifiYC+xdbDj2RcrmwPGtA1687WW1b7JvVHUG6ki9Xqo3sleXFY8fB4o3SwlOvna+LdO0+ortNg3V8F5XRCQzhyms54wJ/+s6JN2TyAUjonpOTRMjRZCf/fDxfsTlcHTIcDmWPj9NoyjnZi6780aHIWlXyStJ9sTX44NWtEqDSEsKtGY64lBBsy6li5m8lTV5quK/A07ZpJIGLSIBSC3UEkTLz3tBFNtHlMJJLNO/YQIDAQAB";

    private final static String FILE_PATH = "D:\\tmp\\down\\";

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


    @PostMapping("/test2")
    public WebResponse test2(@RequestBody GatewayRequest request) throws Exception {

        String sign = request.getSign();
        String encodeDataStr = request.getData();
        byte[] encodeData = Base64Utils.decode(encodeDataStr.getBytes(StandardCharsets.UTF_8));
        Long timestamp = request.getTimestamp();
        String signData = encodeDataStr + timestamp;
        boolean flag = RsaUtil.verify(signData.getBytes(StandardCharsets.UTF_8), sign, FLANCE_PUB_KEY);

        if (!flag) {
            throw new RuntimeException("123123123");
        }

        byte[] decodeDataBytes = RsaUtil.decryptByPrivateKey(encodeData, SELF2_PRI_KEY);

        String data = new String(Base64Utils.decode(decodeDataBytes), StandardCharsets.UTF_8);

        HashMap<String, String> map = GsonUtils.fromString(data, HashMap.class);

        map.put("test", "test");

        String resultData = GsonUtils.toJSONString(map);
        Long resultTimestamp = System.currentTimeMillis();
        byte[] resultDataBytes = Base64Utils.encode(resultData.getBytes(StandardCharsets.UTF_8));


        byte[] resultEncodeDataBytes = RsaUtil.encryptByPublicKey(resultDataBytes, FLANCE_PUB_KEY);
        String dataResponse = Base64Utils.encodeToString(resultEncodeDataBytes);

        String resultSignData = dataResponse + resultTimestamp;
        byte[] signBytes = RsaUtil.sign(resultSignData.getBytes(StandardCharsets.UTF_8), SELF2_PRI_KEY);
        String resultSign = Base64Utils.encodeToString(signBytes);



        System.out.println(RsaUtil.verify(signBytes, resultSign, SELF2_PUB_KEY));

        WebResponse response = new WebResponse();
        response.setData(dataResponse);
        response.setSign(resultSign);
        response.setSuccess(true);
        response.setCode("000000");
        response.setTimestamp(resultTimestamp);
        return response;
    }

    @PostMapping("/upload")
    public String uploadToDirectory(@RequestParam MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(FILE_PATH + file.getOriginalFilename());
        Files.write(path, bytes);
        return "File uploaded";
    }

    @GetMapping("/down")
    public ResponseEntity<byte[]> uploadToDirectory() throws UnsupportedEncodingException {
        // 读取文件路径,根据实际情况来
        String path = FILE_PATH + "【江苏】通行宝渠道对接协议v7.89.docx";
        File file = new File(path);
        //待下载文件名，根据实际情况来
        String fileName = "测试文件下载.docx";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        return new ResponseEntity<>(FileUtil.readBytes(file), headers, HttpStatus.CREATED);
    }

}
