package com.machineCode.HighLevelSearchFunctionality.service;

import com.machineCode.HighLevelSearchFunctionality.dto.Product;
import com.machineCode.HighLevelSearchFunctionality.dto.SearchOptions;

import java.util.List;

/**
 * @author anju
 * @created on 04/04/25 and 11:36 AM
 */
public interface ProductSearchService {
    List<Product> search(String rawQuery, SearchOptions options);
}
