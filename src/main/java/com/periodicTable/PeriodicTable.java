package com.periodicTable;

import com.orasi.api.soapServices.core.SoapService;

public class PeriodicTable extends SoapService {

	public PeriodicTable() {
		setServiceName("PeriodicTableService");
		setServiceURL("http://www.webservicex.net/periodictable.asmx?WSDL");
	}

}
