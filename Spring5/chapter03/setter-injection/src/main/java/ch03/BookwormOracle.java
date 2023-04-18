package ch03;

import org.springframework.stereotype.Service;

@Service("book")
public class BookwormOracle {
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money -  go see the world instead";
    }
}
