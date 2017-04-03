package seleniumdemo;

import lombok.Data;

@Data
public class CarData {

    private String postcode,distance,make,model,min_price,max_price;

    public CarData(){
        postcode = BaseClass.properties.getProperty("postcode");
        distance = BaseClass.properties.getProperty("distance");
        make = BaseClass.properties.getProperty("make");
        model = BaseClass.properties.getProperty("model");
        min_price = BaseClass.properties.getProperty("min_price");
        max_price = BaseClass.properties.getProperty("max_price");
    }

    public String getDistance(){
        if (!distance.equalsIgnoreCase("national")) {
            return "Within " + distance + " miles";
        }else if (distance.equalsIgnoreCase("1")){
            return "Within " + distance + " mile";
        }else{
            return distance;
        }
    }

    public String getMin_Price(){
        return "From £" + min_price;
    }

    public String getMax_Price(){
        return "To £" + max_price;
    }
}
