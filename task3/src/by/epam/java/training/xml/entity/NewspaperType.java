package by.epam.java.training.xml.entity;

public enum NewspaperType {
    GENERAL_POLITICAL("General political newspaper"),
    SPECIALIZED("Specialized newspaper"),
    SPECIAL("Special newspaper issue");

    private String value;

    NewspaperType(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NewspaperType findByValue(String value){
        for(NewspaperType newspaperType : values()){
            if(newspaperType.getValue().equalsIgnoreCase(value)){
                return newspaperType;
            }
        }
        return null;
    }
}
