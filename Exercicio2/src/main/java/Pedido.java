import java.util.*;

public class Pedido {
    private int numeroPedido;
    private String cliente;
    private String[] listaDePratos;
    private float total;

    public Pedido(int numeroPedido, String cliente, String[] listaDePratos, float total) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.listaDePratos = listaDePratos;
        this.total = total;

    }

    public int getNumeroPedido() { return numeroPedido; }

    public String getCliente() { return cliente; }

    public String[] getListaDePratos() { return listaDePratos; }

    public float getTotal() { return total; }


    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", cliente='" + cliente + '\'' +
                ", listaDePratos='" + Arrays.toString(listaDePratos) + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
