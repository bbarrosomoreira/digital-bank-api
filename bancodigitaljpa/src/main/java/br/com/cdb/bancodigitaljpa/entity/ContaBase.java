package br.com.cdb.bancodigitaljpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cdb.bancodigitaljpa.enums.Moeda;
import br.com.cdb.bancodigitaljpa.enums.TipoConta;
import br.com.cdb.bancodigitaljpa.exceptions.SaldoInsuficienteException;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //todas as contas na mesma tabela
//@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING)
@MappedSuperclass
public abstract class ContaBase implements Conta {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	protected String numeroConta;

	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal saldo = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 3)
	private Moeda moeda;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false, updatable = false)
	private Cliente cliente;
	
	@Column(name = "data_criacao", nullable = false, updatable = false)
	private LocalDate dataCriacao = LocalDate.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_conta", updatable = false, nullable = false)
	private TipoConta tipo;
	
	// Construtor protegido
	protected ContaBase(TipoConta tipo, Cliente cliente) {
		this.tipo = tipo;
		this.cliente = cliente;
		this.moeda = Moeda.BRL;
	}
	
	//Getters & Setters
	public Long getId() {
		return id;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	@Override
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Moeda getMoeda() {
		return moeda;
	}
	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	// Implementações comuns
	@Override
	public void depositar(BigDecimal valor) {
		this.saldo = this.saldo.add(valor);
	}

	@Override
	public void transferir(Conta destino, BigDecimal valor) throws SaldoInsuficienteException {
		this.sacar(valor);
		destino.depositar(valor);
	}
	
	@Override
	public void pix(Conta destino, BigDecimal valor) throws SaldoInsuficienteException {
		this.transferir(destino, valor);
	}
	
	protected abstract void gerarNumeroConta();
	
}
