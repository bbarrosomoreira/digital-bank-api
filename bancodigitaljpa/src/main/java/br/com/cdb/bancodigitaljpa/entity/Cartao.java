package br.com.cdb.bancodigitaljpa.entity;

import java.math.BigDecimal;

import br.com.cdb.bancodigitaljpa.exceptions.LimiteInsuficienteException;

public interface Cartao {
	String getTipo();
	void realizarPagamento(BigDecimal valor) throws LimiteInsuficienteException;
	void alterarLimite();
	void alterarStatus();
	void alterarSenha();
	
}
