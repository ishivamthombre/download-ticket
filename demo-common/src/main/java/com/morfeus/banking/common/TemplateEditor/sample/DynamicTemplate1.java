package com.morfeus.banking.common.TemplateEditor.sample;

import com.morfeus.banking.common.TemplateEditor.service.PayloadService;
import com.morfeus.banking.common.TemplateEditor.util.TemplateUtil;
import com.morfeus.common.cmm.CMM;
import com.morfeus.common.cmm.response.CMMResponse;
import com.morfeus.common.cmm.response.ResponseMessageWrapper;
import com.morfeus.workflow.WorkflowRequest;
import com.morfeus.workflow.base.Pipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("dynamicTemplate1")
public class DynamicTemplate1 implements Pipeline {

  @Autowired
  private TemplateUtil templateUtil;
  @Autowired
  private PayloadService payloadService;

  @Override
  public ResponseMessageWrapper process(CMM cmm, WorkflowRequest workflowRequest) {
    List<CMMResponse> cmmResponses = new ArrayList<>();
    String payload = payloadService.getTransactions();
    templateUtil.createTemplateResponse(cmm, "Template1", payload,
        cmmResponses);
    return new ResponseMessageWrapper(ResponseMessageWrapper.EXPECTEDINPUT.NONE.toString(), cmmResponses,
        ResponseMessageWrapper.Status.SUCCESS, null);
  }

}
