package tr.com.tsmd.cengiz.payload.request;


import javax.validation.constraints.NotNull;

public class ServicesRequest {
    //integer icin notnull kullanilmaktadir
    @NotNull
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
