package by.epam.java.training.xml.entity;

import by.epam.java.training.xml.exception.MethodNotSupportedException;

import java.util.Objects;

public class Newspaper extends Paper{
    private int subscriptionIndex;
    private NewspaperType newspaperType;

    public Newspaper() {
    }

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(int subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
    }

    public NewspaperType getNewspaperType() {
        return newspaperType;
    }

    public void setNewspaperType(NewspaperType newspaperType) {
        this.newspaperType = newspaperType;
    }


    @Override
    public JournalType getJournalType() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public void setJournalType(JournalType journalType) throws MethodNotSupportedException {
        throw new MethodNotSupportedException();
    }


    @Override
    public String getNameOfCompany() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public void setNameOfCompany(String nameOfCompany) throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public BookletType getBookletType() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public void setBookletType(BookletType bookletType) throws MethodNotSupportedException {
        throw new MethodNotSupportedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        if (!super.equals(o)) return false;

        Newspaper newspaper = (Newspaper) o;
        return getSubscriptionIndex() == newspaper.getSubscriptionIndex() &&
                getNewspaperType() == newspaper.getNewspaperType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSubscriptionIndex();
        result = 31 * result + (getNewspaperType() != null ? getNewspaperType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Newspaper{" + super.toString() +
                "subscriptionIndex=" + subscriptionIndex +
                ", newspaperType=" + newspaperType +
                '}';
    }
}
