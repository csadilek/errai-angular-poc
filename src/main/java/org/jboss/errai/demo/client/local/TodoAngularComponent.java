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

package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.ui.client.local.AngularComposite;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

@Templated
public class TodoAngularComponent extends AngularComposite {
  
  @Inject
  @DataField("new-todo")
  private TextBox newTodo;

  @Inject
  @DataField
  private Button test;
  
  @Override
  public String getDomElementId() {
    return "angular-app";
  }

  @Override
  public String getAngularModuleName() {
    return "todomvc";
  }
  
  @EventHandler("test")
  private void onClick(ClickEvent event) {
    Window.alert("Hello from Errai! Value of new-todo is:" + newTodo.getText());
  }
}