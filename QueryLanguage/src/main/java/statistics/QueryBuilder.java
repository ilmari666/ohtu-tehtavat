package statistics;

import java.util.ArrayList;
import statistics.matcher.*;

public class QueryBuilder {
    
    ArrayList<Matcher> matchers;

    public QueryBuilder() {
        matchers=new ArrayList<>();
        matchers.add(new All());
    }

    public Matcher build() {
        return new And(matchers.toArray(new Matcher[matchers.size()]));
    }

    public QueryBuilder playsIn(String team){
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int count, String attribute){
        matchers.add(new HasAtLeast(count, attribute));
        return this;
    }
    public QueryBuilder hasFewerThan(int count, String attribute){
        matchers.add(new HasFewerThan(count, attribute));
        return this;
    }
    public QueryBuilder not(Matcher... matchrs){
        matchers.add(new Not(matchrs));
        return this;
    }
    public QueryBuilder all(){
        matchers.add(new All());
        return this;
    }
}
