package graphs.heap;

public class KeyValuePair {
    private Integer _key;
    private Integer _value;

    public KeyValuePair(Integer key, Integer value) {
        this._key = key;
        this._value = value;
    }

    public final Integer getKey() {
        return _key;
    }

    public final Integer getValue() {
        return _value;
    }

    public final void setValue(Integer value) {
        this._value = value;
    }
}
