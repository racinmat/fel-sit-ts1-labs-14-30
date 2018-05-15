package shop;

import java.util.Date;
import java.util.Objects;

public class SeasonalItem extends Item {

    private Date availableFrom;
    private final Date availableTo;
    private Date getAvailableTo;

    public SeasonalItem(int id, String name, float price, String category, Date availableFrom, Date availableTo) {
        super(id, name, price, category);
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Date getGetAvailableTo() {
        return getAvailableTo;
    }

    public void setGetAvailableTo(Date getAvailableTo) {
        this.getAvailableTo = getAvailableTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeasonalItem)) return false;
        if (!super.equals(o)) return false;
        SeasonalItem that = (SeasonalItem) o;
        return Objects.equals(availableFrom, that.availableFrom) &&
            Objects.equals(getAvailableTo, that.getAvailableTo);
    }

    @Override
    public int getLoyaltyPoints() {
        return 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(availableFrom, getAvailableTo);
    }
}
