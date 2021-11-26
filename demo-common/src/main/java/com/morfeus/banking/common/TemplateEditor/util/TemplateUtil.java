package com.morfeus.banking.common.TemplateEditor.util;

import com.morfeus.common.cmm.CMM;
import com.morfeus.common.cmm.response.CMMResponse;
import com.morfeus.common.cmm.response.MessageType;
import com.morfeus.common.log.MorfeusLogger;
import com.morfeus.common.model.template.TemplateConversion;
import com.morfeus.common.util.TemplateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateUtil {

  @Autowired
  TemplateConversionService templateConversionService;

  public void createTemplateResponse(final CMM cmm, final String templateId, final String payLoadJson, final List<CMMResponse>
      responseEntityList) {
    MorfeusLogger.logInfo("Template ==> " + payLoadJson, TemplateUtil.class);
    final TemplateConversion templateConversion = new TemplateConversion();
    templateConversion.setUserChannelId(cmm.getUser().getChannelUserId());
    templateConversion.setBotId(cmm.getBot().getBotCode());
    templateConversion.setChannelType(cmm.getBot().getChannelType().value());
    templateConversion.setIntent(cmm.getAiModel().getIntent().getName());
    templateConversion.setMessageType(MessageType.TEMPLATE.toString());
    templateConversion.setPayload(payLoadJson);
    templateConversion.setFetchType(TemplateConversion.FetchType.BY_NAME);
    templateConversion.setTemplateCode(templateId);
    templateConversion.setLangCode(cmm.getRequest().getLanguageCode());
    templateConversion.setTemplateCategory(TemplateConversion.TemplateCategory.DYNAMIC);
    templateConversion.setSid(cmm.getRequest().getSid());
    try {
      responseEntityList.add(templateConversionService.getResponse(templateConversion).get(0));
    } catch (Exception e) {
      MorfeusLogger.logError(e);
    }
  }
}
