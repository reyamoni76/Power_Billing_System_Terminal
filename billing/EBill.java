package billing;

public class EBill {

    private int no;
    private String name;
    private int prev;
    private int curr;
    private String type;

    private double energy;
    private double vat;
    private double total;

    private double meter = 40;
    private double demand = 50;

    public void setData(
            int no,
            String name,
            int prev,
            int curr,
            String type) {

        this.no = no;
        this.name = name;
        this.prev = prev;
        this.curr = curr;
        this.type = type;
    }

    public void calculate() {

        int unit = curr - prev;

        if (type.equalsIgnoreCase("Domestic")) {

            if (unit <= 50)
                energy = unit * 4.63;

            else if (unit <= 75)
                energy = 50 * 4.63 +
                        (unit - 50) * 5.26;

            else
                energy = unit * 7.20;

        } else {

            energy = unit * 11;
        }

        vat = energy * 0.05;

        total = energy +
                meter +
                demand +
                vat;
    }

    public int getNo() { return no; }
    public String getName() { return name; }
    public int getPrev() { return prev; }
    public int getCurr() { return curr; }
    public String getType() { return type; }

    public double getEnergy() { return energy; }
    public double getVat() { return vat; }
    public double getMeter() { return meter; }
    public double getDemand() { return demand; }
    public double getTotal() { return total; }
}
