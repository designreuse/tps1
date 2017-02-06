package igc.tech.com.validate;

/**
 * Created by tilak on 7/29/2016.
 */
public class ValidType {

   /* required: "This field is required.",
    remote: "Please fix this field.",
    email: "Please enter a valid email address.",
    url: "Please enter a valid URL.",
    date: "Please enter a valid date.",
    dateISO: "Please enter a valid date (ISO).",
    number: "Please enter a valid number.",
    digits: "Please enter only digits.",
    creditcard: "Please enter a valid credit card number.",
    equalTo: "Please enter the same value again.",
    accept: "Please enter a value with a valid extension.",
    maxlength: c.validator.format("Please enter no more than {0} characters."),
    minlength: c.validator.format("Please enter at least {0} characters."),
    rangelength: c.validator.format("Please enter a value between {0} and {1} characters long."),
    range: c.validator.format("Please enter a value between {0} and {1}."),
    max: c.validator.format("Please enter a value less than or equal to {0}."),
    min: c.validator.format("Please enter a value greater than or equal to {0}.")*/


private boolean email;
private boolean number;
private boolean required;
private boolean url;

private boolean date;
private boolean dateIso;
private boolean digits;
private boolean creditCard;
private boolean equalTo;
private boolean accept;
private boolean maxLength;
private boolean minLength;
private boolean rangeLength;
private boolean range;
private boolean max;
private boolean min;


    public ValidType() {
    }

    public ValidType(boolean email, boolean number,  boolean url) {
        this.email = email;
        this.number = number;
      //  this.required = required;
        this.url = url;
    }

    public ValidType(boolean email, boolean number, boolean required, boolean url) {
        this.email = email;
        this.number = number;
        this.required = required;
        this.url = url;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isDate() {
        return date;
    }

    public void setDate(boolean date) {
        this.date = date;
    }

    public boolean isDateIso() {
        return dateIso;
    }

    public void setDateIso(boolean dateIso) {
        this.dateIso = dateIso;
    }

    public boolean isDigits() {
        return digits;
    }

    public void setDigits(boolean digits) {
        this.digits = digits;
    }

    public boolean isCreditCard() {
        return creditCard;
    }

    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isEqualTo() {
        return equalTo;
    }

    public void setEqualTo(boolean equalTo) {
        this.equalTo = equalTo;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public boolean isMaxLength() {
        return maxLength;
    }

    public void setMaxLength(boolean maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isMinLength() {
        return minLength;
    }

    public void setMinLength(boolean minLength) {
        this.minLength = minLength;
    }

    public boolean isRangeLength() {
        return rangeLength;
    }

    public void setRangeLength(boolean rangeLength) {
        this.rangeLength = rangeLength;
    }

    public boolean isRange() {
        return range;
    }

    public void setRange(boolean range) {
        this.range = range;
    }

    public boolean isMax() {
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public boolean isMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }



    public boolean isUrl() {
        return url;
    }

    public void setUrl(boolean url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ValidType{" +
                "email=" + email +
                ", number=" + number +
                ", url=" + url +
                ", date=" + date +
                ", dateIso=" + dateIso +
                ", digits=" + digits +
                ", creditCard=" + creditCard +
                ", equalTo=" + equalTo +
                ", accept=" + accept +
                ", maxLength=" + maxLength +
                ", minLength=" + minLength +
                ", rangeLength=" + rangeLength +
                ", range=" + range +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
