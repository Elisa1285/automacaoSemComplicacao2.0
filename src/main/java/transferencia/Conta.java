package transferencia;

public class Conta {
    //agencia, numeroConta, saldo, proprietario
        //quando não informo o private na frente, automaticamente ele é private

    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente proprietario; //cliente (classe) pode ser o tipo do objeto. Vai pegar todas as informações definidas dentro da classe cliente (nome, cpf, rg)


    public Conta(String agencia, String numeroConta, double saldo, Cliente proprietario) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.proprietario = proprietario;
    }

    public String getAgencia() { //se o método fosse public void, ele não retornaria nada. Por isso ele é uma string. Porque vai retornar uma string.
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void realizarDeposito(double valor){
        saldo = saldo + valor; //outra fora de escrever esse incremeto é saldo += valor;
    }

    public boolean realizarSaque(double valor){
        if(valor > saldo){
            return false;
        }
        saldo = saldo - valor; //outra forma de escrever saldo -= valor;
        return true;
    }

    public boolean realizarTransferencia(double valor, Conta destino){
       if (realizarSaque(valor)){
           destino.realizarDeposito(valor);
           return true;
       }
       return false;


    }



}
