package by.epam.java.training.xml.entity;

import by.epam.java.training.xml.exception.MethodNotSupportedException;

import java.util.Objects;

public class Journal extends Paper {
    private int subscriptionIndex;
    private JournalType journalType;

    public Journal() {
    }

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(int subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
    }

    public JournalType getJournalType() {
        return journalType;
    }

    @Override
    public void setJournalType(JournalType journalType) throws MethodNotSupportedException {
        this.journalType = journalType;
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
    public NewspaperType getNewspaperType() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public void setNewspaperType(NewspaperType newspaperType) throws MethodNotSupportedException {
        throw new MethodNotSupportedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        if (!super.equals(o)) return false;

        Journal journal = (Journal) o;
        return getSubscriptionIndex() == journal.getSubscriptionIndex() &&
                getJournalType() == journal.getJournalType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSubscriptionIndex();
        result = 31 * result + (getJournalType() != null ? getJournalType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Journal{" + super.toString() +
                "subscriptionIndex=" + subscriptionIndex +
                ", journalType=" + journalType +
                '}';
    }
}
