package com.gxa.miaoshacd.utility;

/* *
 *类名：AlipayConfig
 *作者：Rachel
 */

public class AlipayConfig {

    //应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100658472";

    //商户私钥，您的PKCS8格式RSA2私钥   私钥
    public static String private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDBgsJpyXfoPzXbtk6PrU28bIdJx47YFzxkI0PiacEAXgxDhSfq9fCU17NAQOllZrs3BdIwrLWvVPncCmzlMXCL6vfmQW4FVWmtzlFiK8g5VIc8KIdxtQG4Zoaop7Jw5ya24vVGLm2X2JC6Ppj+tpO2DwIEAXnleiVRun6G0lXGDLzLH5yi5mum9Z+ALql3ICDNoJkK5pNnHRSFS8YM6lrKQ5STq3XLooZP08kHcGKv9L1Ei8eojn35Igy6VkeCHJn6inecSJ8IQn3h0NK8d5mrsQjrNvfQFI+YC47nfvLQ7K2cetAGkj6vXaNBhAycm5xDDycRXYAQmou67o0kjWFzAgMBAAECggEBALq5uW2o2YqCzC6puR8NBLDoLJe195FuwniCSvQERhdbqQvSRlWEYlTN2wsKV+zf95E9jbgoP9zi64M3kCKM1WQ+JF3MDyUYaTQsnP1U8AzaEvCqzx+aoQFV9WRzBU3KzuG1GSZSkK/wap883hcTCG+qBbDl18DmX3KAuazQ87F5U5/mb7C8d4ym8zSRsBqMOVT70QErCwhwCE/RNHS3iPU2cuxEbEnV9eH18Z/jEb7J01JE4TGPH2vtuVevE2AAw7AfHiB0G0tMU047l8+FhcZcv4D7CB7w/qrOex1bkM5c7oI+BETSwDzmX0OEWFZWCCfr7O8NQzOI9688G3DwPxkCgYEA9Ei543SU9nrTWMpd5n762CB1x4xdAQzmbP2ngAVUlJ2kibZybNHy3OlRllTi46qzJtBEffB+H0vbamsdqNd+MPdwjePmMgIOWTJCZTHrzj6XlJ8cV6gCb7PuqBPOJ75zNrm283oTWvnpYSIkfMZSVKO+j6CdIc0xJZAJcQRi2p8CgYEAysql8dNmhu9kxocpQVGZmXTEnoISO1sk8NeZLjkNpQ66alYls/Wb07Y7tq3zg8P5Ql2wZmPhtxRvFwkojXD8JFgUmMV8wpBQwMmlobJoHgIyvlfCrfHQLIe3uRA7U+6KTRWEupHFMn65lPnmuswSQWquPeAjnYUygF7NDZjB3K0CgYBWd//EsZmg/a0d+tPuKPhl1GeccOTi4EwYPFk0Ca78xChfzsMGHfLXm4cTrYx6hgvQK1xzL9OVBGbwbmYbQ9wZPR0MPKVZAj1N+WpjI56SbLl/FCsWJBRoscpCmHAaxWFG98n4uTdstpWTmmBMAm9WInfrozC7rEQ/RZLx/Fl5hQKBgDWjyqcfitQQSHC22bO8WMuddlCTCS2IG0pVTOBMGQ7ayXZNGSXzxmcGod7dPjdRRAJI89rxeofJsOS/+GkJRLh8T95lBm4UbDfCXrxZi268mB1+6zDFcJIGyBL8dyTpSM3A7l3HJwkHOiFsxJoOVpnVFQeq3ODSlZwc91IsYML1AoGBANEyuFlHxJq2j+gWv/vOde1dYHSlJAtAymHK5cVugd8MXkzXgWfMt5HeB7FXxhIZHwuJIQsY8cQQhNsmYD/aCr+ooKGGB66zBIERUnJhcCHpy0ktMIUSfxnb6kw569yi0vGudExqCdHwuTouJuUhOJi4khgEuS946e7WDNV+ObRP";
    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "/returnUrl";

    // 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //RSA2 支付宝公钥
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwYLCacl36D8127ZOj61NvGyHSceO2Bc8ZCND4mnBAF4MQ4Un6vXwlNezQEDpZWa7NwXSMKy1r1T53Aps5TFwi+r35kFuBVVprc5RYivIOVSHPCiHcbUBuGaGqKeycOcmtuL1Ri5tl9iQuj6Y/raTtg8CBAF55XolUbp+htJVxgy8yx+couZrpvWfgC6pdyAgzaCZCuaTZx0UhUvGDOpaykOUk6t1y6KGT9PJB3Bir/S9RIvHqI59+SIMulZHghyZ+op3nEifCEJ94dDSvHeZq7EI6zb30BSPmAuO537y0OytnHrQBpI+r12jQYQMnJucQw8nEV2AEJqLuu6NJI1hcwIDAQAB";
    public static String signtype = "RSA2";


}