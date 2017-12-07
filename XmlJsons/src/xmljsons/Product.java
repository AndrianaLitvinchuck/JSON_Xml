package xmljsons;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
import java.time.LocalDate;
import java.util.regex.Pattern;
import com.alibaba.fastjson.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Product {

    @JSONField(ordinal = 1)
    private String title;
    @JSONField(ordinal = 2)
    private String type;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @JSONField(ordinal = 3)
    private LocalDate dateOfProduction;
    @JSONField(ordinal = 4)
    private int price;
    @JSONField(ordinal = 5)
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate shiftTime;

    private Product() {
    }

    public Product(Builder builder) {
        title = builder.title;
        type = builder.type;
        price = builder.price;
        dateOfProduction = builder.dateOfProduction;
        shiftTime = builder.shiftTime;
    }

    //get
    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getShiftTime() {
        return shiftTime;
    }

    //set
    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

    public Product setType(String type) {
        this.type = type;
        return this;
    }

    public Product setDateOfProduction(int year, int month, int day) {
        this.dateOfProduction = LocalDate.of(year, month, day);
        return this;
    }
    public Product setDateOfProduction(LocalDate date) {
        dateOfProduction = date;
        return this;

    }

    public Product setShiftTime(int year, int month, int day) {
        this.shiftTime = LocalDate.of(year, month, day);
        return this;
    }
    public Product setShiftTime(LocalDate date) {
        shiftTime = date;
        return this;

    }
    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    public boolean suitableProduct() {

        return LocalDate.now().compareTo(shiftTime) < 0;

    }

    @Override
    public boolean equals(Object obj) {
        return (title == ((Product) obj).title
                && type == ((Product) obj).type
                && price == ((Product) obj).price);
    }

    @Override
    public String toString() {
        return "\nTitle: " + title + "\nType: " + type
                + "\nPrice: " + price + "\nDateOfProduction: " + dateOfProduction
                + "\nShiftTime: " + shiftTime + "\n";
    }

    public static class Builder {

        private static final String PATTERN = "^[A-Z][a-z]+";

        private String title;
        private String type;
        private int price;
        private LocalDate dateOfProduction;
        private LocalDate shiftTime;

        public Builder setTitle(String title) {
            Pattern p1 = Pattern.compile(PATTERN);
            if (p1.matcher(title).matches()) {
                this.title = title;
            } else {
                throw new IllegalArgumentException("Illegal Title");
            }
            return this;
        }

        public Builder setType(String type) {
            Pattern p1 = Pattern.compile(PATTERN);
            if (p1.matcher(type).matches()) {
                this.type = type;
            } else {
                throw new IllegalArgumentException("Illegal Type");
            }
            return this;
        }

        public Builder setPrice(int price) {
            if ((price > 0) && (price < 1000)) {
                this.price = price;
            } else {
                throw new IllegalArgumentException("Illegal price");
            }
            return this;

        }

        public Builder setDateOfProduction(int year, int month, int day) {
            if ((year > LocalDate.now().getYear() - 2)) {
                this.dateOfProduction = LocalDate.of(year, month, day);
            } else {
                throw new IllegalArgumentException("Illegal Date of Production");
            }
            return this;
        }

        public Builder setShiftTime(int year, int month, int day) {
            LocalDate temp;
            temp = LocalDate.of(year, month, day);
            if ((temp.compareTo(this.dateOfProduction) > 0)) {
                this.shiftTime = LocalDate.of(year, month, day);
            } else {
                throw new IllegalArgumentException("Illegal Date of Shift Time");
            }
            return this;
        }

        public Product createProduct() {
            return new Product(this);
        }

    }



}
