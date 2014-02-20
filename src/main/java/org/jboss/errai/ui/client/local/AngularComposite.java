/*
 * Copyright 2014 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.ui.client.local;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;

public abstract class AngularComposite extends Composite {
  
  public abstract String getDomElementId();
  public abstract String getAngularModuleName();
  
  public AngularComposite() {
    this.addAttachHandler(new Handler() {
      @Override
      public void onAttachOrDetach(AttachEvent event) {
        bootstrap(getDomElementId(), getAngularModuleName());
      }
    });
    
  }
  
  private native void bootstrap(String id, String moduleName) /*-{
    $wnd.angular.bootstrap($doc.getElementById(id), [moduleName]);
  }-*/;

}
