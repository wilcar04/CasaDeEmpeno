import java.util.ArrayList;
import java.util.List;

public class Shop {
    public Integer NIT;
    public String name;
    private Storage store;
    private List<Contract> contracts;

    private ManagerLoanRequest loansRequest;

    Shop (Integer NIT, String name){
        this.NIT = NIT;
        this.name = name;
        this.store = new Storage("Store");
        this.contracts = new ArrayList<>();
        this.loansRequest = new ManagerLoanRequest();

    }
    public void getNewLoanRequest(){

        //HU1
        // Yo como tienda quiero ver la lista
        // de ofertas de prendas para evaluar
        // cada una.

        //RETURN LIST

    }
    public void getPawnedItems(){
        // HU2
        // Yo como tienda quiero ver las prendas empeñadas con detalles
        // para saber cuanto queda hasta que expire el contrato.



        //RETURN LIST
    }
    public void rejectLoanRequest(int idloanRequest){
        //HU3
        //Yo como tienda quiero ver las prendas empeñadas
        // con detalles para saber cuanto queda hasta que
        // expire el contrato.
    }
    public void counterofferLoanRequest(int price, int idloanRequest){
        //HU4
        //Yo como tienda quiero contraofertar
        // por una prenda ofreciendo un precio
        // diferente al del cliente.

    }
    public void acceptLoanRequest(int idloanRequest){
        //HU5
        //Yo como tienda quiero aceptar una oferta.
    }
    public void getMyItemsInteractions(){
        //HU6
        //Yo como tienda quiero ver la lista
        // de las prendas que he atendido para observar
        // su estado.

    }

    public void getItemsWithDeadlineDate() {
        // HU7
        // Yo como tienda quiero obtener las prendas con fecha vencida.
    }

    public void getItemsWithDeadlineInOneWeek(){
        // HU8
        // Yo como tienda quiero recibir las prendas que van a vencer en una semana.
    }


}
