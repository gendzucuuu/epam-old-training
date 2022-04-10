package by.epam.java.training.xml.entity;

import by.epam.java.training.xml.exception.MethodNotSupportedException;

import java.util.Objects;

public class Booklet extends Paper{
    private String nameOfCompany;
    private BookletType bookletType;

    public Booklet() {
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public BookletType getBookletType() {
        return bookletType;
    }


    @Override
    public void setBookletType(BookletType bookletType) throws MethodNotSupportedException {
        this.bookletType = bookletType;
    }

    @Override
    public int getSubscriptionIndex() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public void setSubscriptionIndex(int subscriptionIndex) throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
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
    public JournalType getJournalType() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Not supported");
    }

    @Override
    public void setJournalType(JournalType journalType) throws MethodNotSupportedException {
        throw new MethodNotSupportedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        if (!super.equals(o)) return false;

        Booklet booklet = (Booklet) o;
        return Objects.equals(getNameOfCompany(), booklet.getNameOfCompany()) &&
                getBookletType() == booklet.getBookletType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNameOfCompany() != null ? getNameOfCompany().hashCode() : 0);
        result = 31 * result + (getBookletType() != null ? getBookletType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Booklet{" + super.toString() +
                "nameOfCompany='" + nameOfCompany + '\'' +
                ", bookletType=" + bookletType +
                '}';
    }

}
