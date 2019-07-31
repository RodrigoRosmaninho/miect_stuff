import java.util.*;

public class Vector extends Value {
    public List<Number> list;

    public Vector(List<Number> list){
        this.list = list;
    }

    public Vector(){
        list = new ArrayList<>();
    }

    public void invert(){
        list.forEach(n -> n.invert());
    }

    public Vector sum(Value v){
        Vector res = new Vector();
        Vector vec = (Vector) v;
        int length = this.list.size();
        if(vec.list.size() < length) length = vec.list.size();
        for(int i = 0; i < length; i++){
            res.list.add(this.list.get(i).sum(vec.list.get(i)));
        }
        return res;
    }

    public Vector sub(Value v){
        Vector res = new Vector();
        Vector vec = (Vector) v;
        int length = this.list.size();
        if(vec.list.size() < length) length = vec.list.size();
        for(int i = 0; i < length; i++){
            res.list.add(this.list.get(i).sub(vec.list.get(i)));
        }
        return res;
    }

    public Vector mult(Value v){
        Vector res = new Vector();
        Number n = (Number) v;
        for(int i = 0; i < this.list.size(); i++){
            res.list.add((Number) (this.list.get(i).mult(n)));
        }
        return res;
    }

    public Number prod(Vector v){
        Double res = 0.0;
        int length = this.list.size();
        if(v.list.size() < length) length = v.list.size();
        for(int i = 0; i < length; i++){
            res += ((Number) (this.list.get(i).mult(v.list.get(i)))).val;
        }
        return new Number(res);
    }

    public String toString(){
        return list.toString();
    }
}
