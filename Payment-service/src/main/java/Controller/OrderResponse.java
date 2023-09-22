package Controller;

import lombok.Getter;

@Getter
public class OrderResponse {

    String secretKey;
    String razorpayOrderId;
    String applicationFee;
    String secretId;
    String pgName;

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public void setApplicationFee(String applicationFee) {
        this.applicationFee = applicationFee;
    }
}
