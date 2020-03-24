package tr.com.tsmd.cengiz.payload.request;


import javax.validation.constraints.NotNull;

public class TrademarkPreRequest {
    //integer icin notnull kullanilmaktadir
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
