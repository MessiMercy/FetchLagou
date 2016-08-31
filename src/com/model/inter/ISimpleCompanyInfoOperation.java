package com.model.inter;

import com.model.SimpleCompanyInfo;

public interface ISimpleCompanyInfoOperation {
	public SimpleCompanyInfo selectCompanyByID(int companyId);

	public void addCompany(SimpleCompanyInfo simpleCompanyInfo);

	public void deleteSimpleCompanyInfo(int companyId);

}
