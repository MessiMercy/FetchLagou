package com.model.inter;

import com.model.SimplePositionInfo;

public interface ISimplePositionInfoOperation {
	public SimplePositionInfo selectPositionByID(int companyId);

	public void addPosition(SimplePositionInfo simplePositionInfo);

	public void deleteSimplePositionInfo(int companyId);

}
