package co.lps.mockora.respository;

import co.lps.mockora.model.dao.Mock;

import java.util.List;

public interface MockDynamicQuery {

  List<Mock> query(String queryName, String queryValue);
}
