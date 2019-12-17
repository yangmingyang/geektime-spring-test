package com.megoai.service;

import com.megoai.domain.Items;
import org.springframework.stereotype.Service;

public interface ItemsService {
    Items findById(Integer id);
}
