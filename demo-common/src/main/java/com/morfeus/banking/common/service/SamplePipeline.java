package com.morfeus.banking.common.service;

import com.morfeus.common.cmm.CMM;
import com.morfeus.common.cmm.response.CMMResponse;
import com.morfeus.common.cmm.response.ResponseMessageWrapper;
import com.morfeus.common.cmm.response.ResponseMessageWrapper.Status;
import com.morfeus.common.message.util.MessageUtil;
import com.morfeus.workflow.WorkflowRequest;
import com.morfeus.workflow.base.Pipeline;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("samplePipeline")
public class SamplePipeline implements Pipeline {

  @Override
  public ResponseMessageWrapper process(CMM cmm, WorkflowRequest workflowRequest) {
    CMMResponse textResponseEntity = MessageUtil.getTextResponseEntity("Please enter your registered mobile number to check your bookings");
    ResponseMessageWrapper responseMessageWrapper = new ResponseMessageWrapper(Arrays.asList(textResponseEntity));
    responseMessageWrapper.setStatus(Status.SUCCESS);
    return responseMessageWrapper;
  }

}
