public class Moneda {
    private double peso;
    private int valor;
    
    public Moneda(double peso, int valor){
        this.valor=valor;
        this.peso=peso;
    }
    public int getValor(){
        return this.valor;
    }
    public void setValor(int valor){
        this.valor=valor;
    }
    public double getPeso(){
        return this.peso;
    }
    public void setPeso(double peso){
        this.peso=peso;
    }
}
