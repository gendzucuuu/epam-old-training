package by.epam.java.training.xml.entity;

public enum PaperEnum {
    JOURNAL("journal"), NEWSPAPER("newspaper"), BOOKLET("booklet"),
    ID("id"),
    TITLE("title"),
    MONTHLY("monthly"),
    COLORED("colored"),
    VOLUME("volume"),
    GLOSSY("glossy"),
    NAME_OF_COMPANY("name-of-company"),
    BOOKLET_TYPE("booklet-type"),
    SUBSCRIPTION_INDEX("subscription-index"),
    JOURNAL_TYPE("journal-type"),
    NEWSPAPER_TYPE("newspaper-type");

    private String value;

    PaperEnum(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static PaperEnum findByValue(String value){
        for(PaperEnum paper : values()){
            if(paper.getValue().equalsIgnoreCase(value)){
                return paper;
            }
        }
        return null;
    }
}
