package util;

public enum PropertyEnum {

    BROWSER_CHROME("BROWSER_CHROME",""),
    BROWSER_DOCKER("BROWSER_DOCKER",""),
    IMPLICITLY_MAXIMUM_WAIT_TIME("IMPLICITLY_MAXIMUM_WAIT_TIME",""),
    BASE_URL("BASE_URL","");


    private String key;
    private Long Time;
    private String description;

    private PropertyEnum(String key,String description){
        this.key = key;
        this.description=description;
    }

    public String getKeyText(){
        return this.key;
    }

    public String getDescription(){
        return this.description;
    }

}
