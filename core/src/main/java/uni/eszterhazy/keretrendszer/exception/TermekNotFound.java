package uni.eszterhazy.keretrendszer.exception;

public class TermekNotFound extends Throwable {
    public TermekNotFound(String id) {
        super(id);
    }
}
