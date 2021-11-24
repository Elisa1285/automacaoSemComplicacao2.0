package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    //para transformar o método em um executável de teste, a gente usa a notação @test

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "12345678900", "11111888");
        silvioSantos = new Cliente("SilvioSantos", "88899988800", "87888999");

        contaXuxa = new Conta("5267","1234567", 2500.00, xuxa);
        contaSilvio = new Conta("7687","345625", 3500.00, silvioSantos);
    }

    // teste positivo. para fazer o teste negativo, é necessário criar outro método.
    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000,contaSilvio);

        //está esperando que na conta da xuxa tenha 1500. Depois (no get saldo) vai validar se na conta da xuxa realmente tem 1500
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());

    }

        //método do teste falso
    @Test

    public void validarTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);

        assertFalse(resultado);
        //outra forma de fazer: assertEquals(false, resultado);

    }

    @Test
    public void validarProprietario(){
        assertEquals(xuxa, contaXuxa.getProprietario());
        assertEquals(silvioSantos, contaSilvio.getProprietario());
    }

    @Test
    public void validarAgencia(){
        assertEquals("5267", contaXuxa.getAgencia());
        assertEquals("7687", contaSilvio.getAgencia());

    }

    @Test
    public void validarNumeroConta(){
        assertEquals("1234567", contaXuxa.getNumeroConta());
        assertEquals("345625", contaSilvio.getNumeroConta());
    }

    @Test
    public void validarSaldo(){
        assertEquals(2500.00, contaXuxa.getSaldo());
        assertEquals(3500.00, contaSilvio.getSaldo());

    }

    @Test
    public void ValidarNome(){
        assertEquals("Xuxa", xuxa.getNome());
        assertEquals("SilvioSantos", silvioSantos.getNome());
    }

    @Test
    public void ValidarCPF(){
        assertEquals("12345678900", xuxa.getCpf());
        assertEquals("88899988800", silvioSantos.getCpf());
    }

    @Test
    public void ValidarRG(){
        assertEquals("11111888", xuxa.getRg());
        assertEquals("87888999", silvioSantos.getRg());
    }
}