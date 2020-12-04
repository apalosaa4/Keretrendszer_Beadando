package uni.eszterhazy.keretrendszer.exception;

public class TermekAlreadyAdded extends Throwable {
    public TermekAlreadyAdded(String id) {
        super(id);
    }
}
