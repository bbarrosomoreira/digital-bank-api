package br.com.cdb.bancodigitaljpa.entity;

import br.com.cdb.bancodigitaljpa.enums.Status;

public interface Seguro {
	void setarStatusSeguro(Status statusNovo);
	void acionarSeguro();
	void aplicarPremio();
}
