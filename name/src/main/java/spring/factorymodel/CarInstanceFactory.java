package spring.factorymodel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linlang
 * @date 2019/1/23
 */
public class CarInstanceFactory {

    private Map<Integer, Car> map = new HashMap<Integer,Car>();
    public void setMap(Map<Integer, Car> map) {
        this.map = map;
    }
    public CarInstanceFactory(){    }
    public Car getCar(int id){
        return map.get(id);
    }

}
