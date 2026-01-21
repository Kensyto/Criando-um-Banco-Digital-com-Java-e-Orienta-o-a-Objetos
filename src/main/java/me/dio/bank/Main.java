package me.dio.bank;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        Banco banco = new Banco();
        banco.setNome("DioBank");
        List<Conta> contas = new ArrayList<>();
        contas.add(cc);
        contas.add(poupanca);
        banco.setContas(contas);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        // Testing balance validation
        try {
            cc.sacar(50);
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
