package com.example.demo.util;

/**
 * @version 1.0
 * @Author chenglong
 * @className password
 * @Description password entity
 * @Date 2025-07-23
 */
public class Password {
    public static String getPublicKeyString() {
        //公钥验签
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDas2D7GQMMirK516zxt3YynA1eALG70k3O16fpF8gfgT2pjj9fhoYAldC6r0dQxzn2qQgIwBUBqfhbr7YA5Z+gNYKWwa9VcVFrPVR+/XDphTNiUY4/R/WkytSmBYZEYLIsdQHjYArxxAsSJtLh+WFXjiEuWjYv/BwCK7HthskuXwIDAQAB";
    }
    public static String getPrivateKeyString() {
        //私钥加签
        return "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANqzYPsZAwyKsrnXrPG3djKcDV4AsbvSTc7Xp+kXyB+BPamOP1+GhgCV0LqvR1DHOfapCAjAFQGp+FuvtgDln6A1gpbBr1VxUWs9VH79cOmFM2JRjj9H9aTK1KYFhkRgsix1AeNgCvHECxIm0uH5YVeOIS5aNi/8HAIrse2GyS5fAgMBAAECgYBHJj5x0kRMqz7T+ReZl88LTfuHToCEEzofBcfprEP+A+TUqaNyZ2hm/lZmtalk3Tu9RGaJujvbS7mx0mtKxWl1cjb7rk+zU6Zxf054VgW6b51Uq9AhLAOrS4BYrJr1SEpaACFo+F0T4HS72ITws9ah/dTOS2LZHcsYxto57XzIWQJBAP5XfV7uA82f2+90bRMP8eXsH9Z2LlIALDKwzAksm3JJ2BIFWqm4BHJwI+7yofgen/SWnCG7lsCp0DwdkYHkGisCQQDcIGb4mOJFVXPoSPFiAM9oJTFME8SYS2zQPaPrR+EDQYgeaO52NM+MElkTtrD7G+ms1sDzB28Xlz3b/wUOaGadAkEA1l5dP9ayg+v5zmA90rQ8uQKEbxjav6h/mBXlUtIzDmfo4n96w9NihCW6U5pTI7KENP2ACPp3/FjkNtbhHi5oUwJBAMPravq0SB/hsKn70iuiAPf2smu95GqQJyco1a5haVoWh2pZhnRbCKbo5bNwFRFKhK667TzhTvU2PW6DCiMKtNkCQQDpstRqRWWMzJuwNnm3fJ1bjsqsR8YRPDQs+qSQujd59O0HUSYOA36iXIgZkpfHpAffJ6+tgn3/5mKcWgwMlDUj";
    }

    public static String getPassword_3des() {
        //3DES秘钥
        return "dh1pjBZKdSg4TUGhuPBU2mpl";
    }

    public static String getQstPublicKeyString() {
        //全税通公钥
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC83nAGqSeWNNqltizZE6rWkfXQe7sZL12V8jJiigrr7/NFgkyqN4dwkM1PlKe2OQ7LUIZap9ijk5ZhOa7FJZ1+dOshJbFMKqSL6gBMxNlIE9xvms01rFZTmxs1gAgLTi1Cz1oi0kOZDfGYGRb0akHWblepsgjfF76BHJ4QpFQ1cQIDAQAB";
    }

}
