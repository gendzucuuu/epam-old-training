package by.epam.java.training.xml.entity;

public enum JournalType {
    SOCIAL("Social magazine"),
    SCIENCE("Science magazine"),
    PRODUCTION_AND_PRACTICAL("Production and practical magazine"),
    POPULAR("Popular magazine"),
    REVIEW("Review magazine");

    private String value;

    JournalType(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JournalType findByValue(String value){
        for(JournalType journalType : values()){
            if(journalType.getValue().equalsIgnoreCase(value)){
                return journalType;
            }
        }
        return null;
    }
}
