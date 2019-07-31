public class Number extends Value {
    public Double val;

    public Number(Double val){
        this.val = val;
    }

    public void invert() {
        val = val * -1;
    }

    public Number sum(Value v){
        Number n = (Number) v;
        return new Number(this.val + n.val);
    }

    public Number sub(Value v){
        Number n = (Number) v;
        return new Number(this.val - n.val);
    }

    public Value mult(Value v){
        if(v instanceof Number){
            return new Number(this.val * ((Number) v).val);
        }
        else {
            return v.mult(this);
        }
    }

    public String toString(){
        return String.valueOf(val);
    }
}
