package by.epam.java.training.xml.entity;

import by.epam.java.training.xml.exception.MethodNotSupportedException;

import java.util.Objects;


public abstract class Paper {
    private long id;
    private String title;
    private boolean monthly;
    private boolean colored;
    private int volume;
    private boolean glossy;

    public Paper() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }


    public abstract int getSubscriptionIndex() throws MethodNotSupportedException;

    public abstract void setSubscriptionIndex(int subscriptionIndex) throws MethodNotSupportedException;

    public abstract NewspaperType getNewspaperType() throws MethodNotSupportedException;

    public abstract void setNewspaperType(NewspaperType newspaperType) throws MethodNotSupportedException;

    public abstract JournalType getJournalType() throws MethodNotSupportedException;

    public abstract void setJournalType(JournalType journalType) throws MethodNotSupportedException;

    public abstract String getNameOfCompany() throws MethodNotSupportedException;

    public abstract void setNameOfCompany(String nameOfCompany) throws MethodNotSupportedException;

    public abstract BookletType getBookletType() throws MethodNotSupportedException;

    public abstract void setBookletType(BookletType bookletType) throws MethodNotSupportedException;


    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Paper paper = (Paper) o;
        return this.getId() == paper.getId() &&
                this.isMonthly() == paper.isMonthly() &&
                this.isColored() == paper.isColored() &&
                this.getVolume() == paper.getVolume() &&
                this.isGlossy() == paper.isGlossy() &&
                Objects.equals(this.getTitle(), paper.getTitle());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (isMonthly() ? 1 : 0);
        result = 31 * result + (isColored() ? 1 : 0);
        result = 31 * result + getVolume();
        result = 31 * result + (isGlossy() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", monthly=" + monthly +
                ", colored=" + colored +
                ", volume=" + volume +
                ", glossy=" + glossy +
                '}';
    }



}
