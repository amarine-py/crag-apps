package partner_finder.domain;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {

    private final ArrayList<String> messages = new ArrayList<>();
    private ResultType type = ResultType.SUCCESS;
    private T payload;

    public ResultType getType() {
        return type;
    }

    public boolean isSuccess() {
        return type == ResultType.SUCCESS;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void addMessage(String message, ResultType type) {
        messages.add(message);
        this.type = type;
    }
    public Result<T> merge(Result<T> result) {
        if (!this.isSuccess()) {
            if (result.isSuccess()) {
                return this;
            } else {
                for (String message : this.getMessages()) {
                    result.addMessage(message, result.getType());
                }
                return result;
            }
        } else {
            return (result.getPayload() == null) ? this : result;
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "messages=" + messages +
                ", type=" + type +
                ", payload=" + payload +
                '}';
    }
}
