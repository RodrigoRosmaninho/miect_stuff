import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class CustomSet extends ArrayList<String>{

    public CustomSet(String src){
        super();
        src = src.replaceAll("[{}]", "");
        for (String s : src.split(",")) super.add(s);
    }

    public CustomSet(List list){
        super(list);
    }

    public CustomSet union(CustomSet other){
        ArrayList tmp = ((CustomSet) (super.clone()));
        tmp.addAll(other);
        return new CustomSet(tmp);
    }

    public CustomSet interception(CustomSet other){
        return new CustomSet(super.stream()
                                .filter(e -> other.contains(e))
                                .collect(Collectors.toList())
                            );
    }

    public CustomSet difference(CustomSet other){
        return new CustomSet(super.stream()
                                .filter(e -> !other.contains(e))
                                .collect(Collectors.toList())
                            );
    }

    public String toString(){
        return "{" + super.stream().collect(Collectors.joining(",")) + "}";
    }

}