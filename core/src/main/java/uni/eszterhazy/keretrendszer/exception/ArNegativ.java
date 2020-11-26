package uni.eszterhazy.keretrendszer.exception;

public class ArNegativ extends Throwable {
    public ArNegativ(double ar) {
        super(String.valueOf(ar));
    }
}
