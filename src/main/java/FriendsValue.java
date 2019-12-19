import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.Proxy;

import java.time.*;
import java.util.Set;

public class FriendsValue {

    private final Value value;

    public FriendsValue(Value value) {
        this.value = value;
    }

    public Value getMemberOr(String identifier, Object or) {
        Value member = this.value.getMember(identifier);
        if (member == null) {
            return Value.asValue(or);
        }
        return member;
    }

    public static FriendsValue from(Value value) {
        return new FriendsValue(value);
    }

    public Value getMetaObject() {
        return value.getMetaObject();
    }

    public boolean hasArrayElements() {
        return value.hasArrayElements();
    }

    public Value getArrayElement(long index) {
        return value.getArrayElement(index);
    }

    public void setArrayElement(long index, Object value) {
        this.value.setArrayElement(index, value);
    }

    public boolean removeArrayElement(long index) {
        return value.removeArrayElement(index);
    }

    public long getArraySize() {
        return value.getArraySize();
    }

    public boolean hasMembers() {
        return value.hasMembers();
    }

    public boolean hasMember(String identifier) {
        return value.hasMember(identifier);
    }

    public Value getMember(String identifier) {
        return value.getMember(identifier);
    }

    public Set<String> getMemberKeys() {
        return value.getMemberKeys();
    }

    public void putMember(String identifier, Object value) {
        this.value.putMember(identifier, value);
    }

    public boolean removeMember(String identifier) {
        return value.removeMember(identifier);
    }

    public boolean canExecute() {
        return value.canExecute();
    }

    public Value execute(Object... arguments) {
        return value.execute(arguments);
    }

    public void executeVoid(Object... arguments) {
        value.executeVoid(arguments);
    }

    public boolean canInstantiate() {
        return value.canInstantiate();
    }

    public Value newInstance(Object... arguments) {
        return value.newInstance(arguments);
    }

    public boolean canInvokeMember(String identifier) {
        return value.canInvokeMember(identifier);
    }

    public Value invokeMember(String identifier, Object... arguments) {
        return value.invokeMember(identifier, arguments);
    }

    public boolean isString() {
        return value.isString();
    }

    public String asString() {
        return value.asString();
    }

    public boolean fitsInInt() {
        return value.fitsInInt();
    }

    public int asInt() {
        return value.asInt();
    }

    public boolean isBoolean() {
        return value.isBoolean();
    }

    public boolean asBoolean() {
        return value.asBoolean();
    }

    public boolean isNumber() {
        return value.isNumber();
    }

    public boolean fitsInLong() {
        return value.fitsInLong();
    }

    public long asLong() {
        return value.asLong();
    }

    public boolean fitsInDouble() {
        return value.fitsInDouble();
    }

    public double asDouble() {
        return value.asDouble();
    }

    public boolean fitsInFloat() {
        return value.fitsInFloat();
    }

    public float asFloat() {
        return value.asFloat();
    }

    public boolean fitsInByte() {
        return value.fitsInByte();
    }

    public byte asByte() {
        return value.asByte();
    }

    public boolean fitsInShort() {
        return value.fitsInShort();
    }

    public short asShort() {
        return value.asShort();
    }

    public boolean isNull() {
        return value.isNull();
    }

    public boolean isNativePointer() {
        return value.isNativePointer();
    }

    public long asNativePointer() {
        return value.asNativePointer();
    }

    public boolean isHostObject() {
        return value.isHostObject();
    }

    public <T> T asHostObject() {
        return value.asHostObject();
    }

    public boolean isProxyObject() {
        return value.isProxyObject();
    }

    public <T extends Proxy> T asProxyObject() {
        return value.asProxyObject();
    }

    public <T> T as(Class<T> targetType) throws ClassCastException, IllegalStateException, PolyglotException {
        return value.as(targetType);
    }

    public <T> T as(TypeLiteral<T> targetType) {
        return value.as(targetType);
    }

    public SourceSection getSourceLocation() {
        return value.getSourceLocation();
    }

    public boolean isDate() {
        return value.isDate();
    }

    public LocalDate asDate() {
        return value.asDate();
    }

    public boolean isTime() {
        return value.isTime();
    }

    public LocalTime asTime() {
        return value.asTime();
    }

    public boolean isInstant() {
        return value.isInstant();
    }

    public Instant asInstant() {
        return value.asInstant();
    }

    public boolean isTimeZone() {
        return value.isTimeZone();
    }

    public ZoneId asTimeZone() {
        return value.asTimeZone();
    }

    public boolean isDuration() {
        return value.isDuration();
    }

    public Duration asDuration() {
        return value.asDuration();
    }

    public boolean isException() {
        return value.isException();
    }

    public RuntimeException throwException() {
        return value.throwException();
    }

    public Context getContext() {
        return value.getContext();
    }

    public static Value asValue(Object o) {
        return Value.asValue(o);
    }
}
