package com.morfeus.banking.common.service;

import com.morfeus.common.cmm.CMM;
import com.morfeus.common.workflow.model.GoTo;
import com.morfeus.common.workflow.model.GoTo.Type;
import com.morfeus.workflow.WorkflowRequest;
import com.morfeus.workflow.base.Connector;

public class SampleConnector implements Connector {

  @Override
  public GoTo moveTo(CMM cmm, WorkflowRequest workflowRequest) {
    GoTo goTo = new GoTo();
    goTo.setType(Type.NODE);
    if (cmm.getAiModel().getEntities().containsKey("banking.otp")
        && cmm.getAiModel().getEntities().get("banking.otp").stream().anyMatch(e -> e.getValue().length() == 6)) {
      goTo.setId("View_Bookings");
    } else {
      goTo.setId("error");
    }
    return goTo;
  }

}
