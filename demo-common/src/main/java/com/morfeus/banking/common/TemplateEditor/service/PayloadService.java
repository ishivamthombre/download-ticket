package com.morfeus.banking.common.TemplateEditor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morfeus.banking.common.TemplateEditor.domain.Transactions;
import com.morfeus.common.log.MorfeusLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PayloadService {


  @Autowired
  private ResourceLoader resourceLoader;

  @Autowired
  private ObjectMapper objectMapper;

  private static final String CLASSPATH = "classpath:";

  public String getTransactions() {
    try {
      InputStream resourceAsStream =
          resourceLoader.getResource(CLASSPATH + "data/" + "transactions" + ".json").getInputStream();
      List<Transactions> transactionsList = objectMapper.readValue(resourceAsStream, new TypeReference<List<Transactions>>(){});

      Map<String, Object> payload = new HashMap<>();
      payload.put("list", transactionsList);
      return objectMapper.writeValueAsString(payload);

    } catch (Exception e) {
      MorfeusLogger.logError("Error while gettings Transactions : ", e);
      return null;
    }
  }

}
