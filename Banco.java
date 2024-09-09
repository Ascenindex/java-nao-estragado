package com.estudosJava.projetosPessoas.contaBancaria;
public class Banco {
  private String nome;
  private Long cnpj;
  private int numeroDaConta;
  private double saldo;
  private boolean statusDaConta = false;
  private String tipoDaConta = null;

  public Banco(String nome, Long cnpj, int numeroDaConta, double saldo, boolean statusDaConta) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.numeroDaConta = numeroDaConta;
    this.saldo = saldo;
    this.statusDaConta = statusDaConta;
  }

  public Banco(String nome, Long cnpj, int numeroDaConta, double saldo, boolean statusDaConta, String tipoDaConta) {
    this(nome, cnpj, numeroDaConta, saldo, statusDaConta);
    this.tipoDaConta = tipoDaConta == null ? "CC" : tipoDaConta;
  }

  public void abrirConta() {
    if (statusDaConta) {
      System.out.println("Conta já está aberta!");
      if (tipoDaConta.equals("CP")) {
        System.out.println("Conta poupança não possui limite de saque!");
      }else if (tipoDaConta.equals("CC")) {
        System.out.println("Conta corrente não possui limite de saque!");
      }
      return;
    } else {
      setStatusDaConta(true);
      System.out.println("Conta aberta com sucesso!");
    }

  }

  public void fecharConta() {
    if (saldo > 0) {
      System.out.println("Conta não pode ser fechada pois ainda tem saldo!");
      System.out.println("Saldo atual: " + saldo);
    } else if (saldo < 0) {
      System.out.println("Conta não pode ser fechada pois está com saldo negativo!");
    } else if (statusDaConta == false) {
      System.out.println("Conta já está fechada!");
    } else {
      setStatusDaConta(false);
      System.out.println("Conta fechada com sucesso!");
    }
  }

  public void depositar(double valor) {
    if (!statusDaConta) {
      System.out.println("Não é possível depositar em uma conta fechada!");
    } else if (valor <= 0) {
      System.out.println("Valor inválido para depósito!");
    } else {
      setSaldo(getSaldo() + valor);
      System.out.println("Depósito realizado com sucesso! Valor atual: " + getSaldo());
    }
  }

  public boolean sacar(double valor) {
    if (!statusDaConta) {
      System.out.println("Conta está fechada!");
    } else if (valor <= 0) {
      System.out.println("Valor inválido para saque!");
    } else if (getSaldo() < valor) {
      System.out.println("Saldo insuficiente para realizar o saque!");
    } else {
      setSaldo(getSaldo() - valor);
      System.out.println("Saque realizado com sucesso! Valor atual: " + getSaldo());
    }
    return statusDaConta;
  }

  public void transferir(double valor, Banco contaDestino) {
    if (!statusDaConta) {
      System.out.println("Conta está fechada!");
    } else if (valor <= 0) {
      System.out.println("Valor inválido para transferência!");
    } else if (getSaldo() < valor) {
      System.out.println("Saldo insuficiente para realizar a transferência!");
    } else if (!contaDestino.isStatusDaConta()) {
      System.out.println("Conta de destino está fechada!");
    } else {
      setSaldo(getSaldo() - valor);
      contaDestino.setSaldo(contaDestino.getSaldo() + valor);
      System.out.println("Transferência realizada com sucesso! Valor atual: " + getSaldo());
      System.out.println("A " + contaDestino.getNome() + " agora tem " + contaDestino.getSaldo() + " reais");
    }
  }

  public void verificarSaldo() {
    if (!statusDaConta) {
      System.out.println("Conta está fechada!");
    } else {
      System.out.println("Saldo atual: " + getSaldo());
    }
  }

  // Getters públicos para acesso controlado
  public String getNome() {
    return nome;
  }

  public Long getCnpj() {
    return cnpj;
  }

  public int getNumeroDaConta() {
    return numeroDaConta;
  }

  public double getSaldo() {
    return saldo;
  }

  public boolean isStatusDaConta() {
    return statusDaConta;
  }

  public String getTipoDaConta() {
    return tipoDaConta;
  }

  // Setters privados ou protegidos para controle interno
  private void setNome(String nome) {
    this.nome = nome;
  }

  private void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }

  private void setNumeroDaConta(int numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  private void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  private void setStatusDaConta(boolean statusDaConta) {
    this.statusDaConta = statusDaConta;
  }

  private void setTipoDaConta(String tipoDaConta) {
    this.tipoDaConta = tipoDaConta;
  }

}