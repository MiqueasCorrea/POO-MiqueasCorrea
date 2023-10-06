package P6;

public class Expendedor {
    private String id;
    TipoExpendedor tipo_de_expendedor;

    public Expendedor(String id, TipoExpendedor tipo_de_expendedor) {
        this.id = id;
        this.tipo_de_expendedor = tipo_de_expendedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoExpendedor getTipo_de_expendedor() {
        return tipo_de_expendedor;
    }

    public void setTipo_de_expendedor(TipoExpendedor tipo_de_expendedor) {
        this.tipo_de_expendedor = tipo_de_expendedor;
    }
}
