/**
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.ui.client.local.DynamicAngularComposite;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;

//@EntryPoint
@Templated("App.html#body")
public class AppDynamic extends Composite {

  @Inject
  @DataField
  private NavigationBar navbar;

  @DataField
  private final DynamicAngularComposite dynamicAngularComponent = 
    new DynamicAngularComposite("/errai-angular-poc/angular-test.html", "template");
  
  @Inject
  @DataField
  private Footer footer;
  
}
