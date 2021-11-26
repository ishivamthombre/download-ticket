package com.morfeus.banking.common.service;

import com.morfeus.common.cmm.CMM;
import com.morfeus.common.cmm.response.CMMResponse;
import com.morfeus.common.cmm.response.ResponseMessageWrapper;
import com.morfeus.common.cmm.response.ResponseMessageWrapper.Status;
import com.morfeus.common.message.util.MessageUtil;
import com.morfeus.workflow.WorkflowRequest;
import com.morfeus.workflow.base.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("sampleValidation")
public class SampleValidation implements Validator {

  @Override
  public ResponseMessageWrapper process(CMM cmm, WorkflowRequest workflowRequest) {
    List<CMMResponse> cmmResponses = new ArrayList<>();
    ResponseMessageWrapper responseMessageWrapper = new ResponseMessageWrapper(cmmResponses);
    String userInput= workflowRequest.getEntities().get("sys.person-phone-number").get(0).getValue();

    String test = cmm.getAiModel().getEntities().get("sys.person-phone-number").get(0).getValue();
    userInput = StringUtils.isNotEmpty(userInput) ? userInput : test;
    if (StringUtils.isNotEmpty(userInput) && userInput.length() == 10 && userInput.startsWith("98")) {
      responseMessageWrapper.setStatus(Status.SUCCESS);
    } else {
      CMMResponse textResponseEntity = MessageUtil.getTextResponseEntity("Entered phone number"
          + "is not registered with us. Please enter valid number");
      cmmResponses.add(textResponseEntity);
      responseMessageWrapper.setStatus(Status.FAILED);
    }
    return responseMessageWrapper;
  }

}

