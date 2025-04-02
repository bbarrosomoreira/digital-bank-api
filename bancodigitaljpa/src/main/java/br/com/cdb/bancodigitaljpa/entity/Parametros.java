package br.com.cdb.bancodigitaljpa.entity;

import java.math.BigDecimal;

import br.com.cdb.bancodigitaljpa.enums.CategoriaCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parametros {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private CategoriaCliente categoria;
	
    private BigDecimal tarifaManutencaoMensalContaCorrente;
    
    @Column(precision = 5, scale = 4)
    private BigDecimal rendimentoPercentualMensalContaPoupanca;
    private BigDecimal limiteCartaoCredito;
    private BigDecimal limiteDiarioDebito;
    private BigDecimal tarifaSeguroViagem;
    
    //G&S
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CategoriaCliente getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaCliente categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getTarifaManutencaoMensalContaCorrente() {
		return tarifaManutencaoMensalContaCorrente;
	}
	public void setTarifaManutencaoMensalContaCorrente(BigDecimal tarifaManutencaoMensalContaCorrente) {
		this.tarifaManutencaoMensalContaCorrente = tarifaManutencaoMensalContaCorrente;
	}
	public BigDecimal getRendimentoPercentualMensalContaPoupanca() {
		return rendimentoPercentualMensalContaPoupanca;
	}
	public void setRendimentoPercentualMensalContaPoupanca(BigDecimal rendimentoPercentualMensalContaPoupanca) {
		this.rendimentoPercentualMensalContaPoupanca = rendimentoPercentualMensalContaPoupanca;
	}
	public BigDecimal getLimiteCartaoCredito() {
		return limiteCartaoCredito;
	}
	public void setLimiteCartaoCredito(BigDecimal limiteCartaoCredito) {
		this.limiteCartaoCredito = limiteCartaoCredito;
	}
	public BigDecimal getLimiteDiarioDebito() {
		return limiteDiarioDebito;
	}
	public void setLimiteDiarioDebito(BigDecimal limiteDiarioDebito) {
		this.limiteDiarioDebito = limiteDiarioDebito;
	}
	public BigDecimal getTarifaSeguroViagem() {
		return tarifaSeguroViagem;
	}
	public void setTarifaSeguroViagem(BigDecimal tarifaSeguroViagem) {
		this.tarifaSeguroViagem = tarifaSeguroViagem;
	}
	
 
	//C
	public Parametros() {
	}
	public Parametros(
			CategoriaCliente categoria, 
			BigDecimal tarifaManutencaoMensalContaCorrente,
			BigDecimal rendimentoPercentualMensalContaPoupanca, 
			BigDecimal limiteCartaoCredito, 
			BigDecimal limiteDiarioDebito,
			BigDecimal tarifaSeguroViagem) {
		super();
		this.categoria = categoria;
		this.tarifaManutencaoMensalContaCorrente = tarifaManutencaoMensalContaCorrente;
		this.rendimentoPercentualMensalContaPoupanca = rendimentoPercentualMensalContaPoupanca;
		this.limiteCartaoCredito = limiteCartaoCredito;
		this.limiteDiarioDebito = limiteDiarioDebito;
		this.tarifaSeguroViagem = tarifaSeguroViagem;
	}
    

}
