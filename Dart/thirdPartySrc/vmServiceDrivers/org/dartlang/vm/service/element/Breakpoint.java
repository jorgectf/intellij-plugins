/*
 * Copyright (c) 2015, the Dart project authors.
 *
 * Licensed under the Eclipse Public License v1.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dartlang.vm.service.element;

// This file is generated by the script: pkg/vm_service/tool/generate.dart in dart-lang/sdk.

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * A {@link Breakpoint} describes a debugger breakpoint.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Breakpoint extends Obj {

  public Breakpoint(JsonObject json) {
    super(json);
  }

  /**
   * A number identifying this breakpoint to the user.
   */
  public int getBreakpointNumber() {
    return getAsInt("breakpointNumber");
  }

  /**
   * Is this breakpoint enabled?
   */
  public boolean getEnabled() {
    return getAsBoolean("enabled");
  }

  /**
   * Is this a breakpoint that was added synthetically as part of a step OverAsyncSuspension resume
   * command?
   *
   * Can return <code>null</code>.
   */
  public boolean getIsSyntheticAsyncContinuation() {
    return getAsBoolean("isSyntheticAsyncContinuation");
  }

  /**
   * SourceLocation when breakpoint is resolved, UnresolvedSourceLocation when a breakpoint is not
   * resolved.
   *
   * @return one of <code>SourceLocation</code> or <code>UnresolvedSourceLocation</code>
   */
  public Object getLocation() {
    final JsonElement elem = json.get("location");
    if (elem == null) return null;

    if (elem.isJsonObject()) {
    final JsonObject o = (JsonObject) elem;
    if (o.get("type").getAsString().equals("SourceLocation")) return new SourceLocation(o);
    if (o.get("type").getAsString().equals("UnresolvedSourceLocation")) return new UnresolvedSourceLocation(o);
    }
    return null;
  }

  /**
   * Has this breakpoint been assigned to a specific program location?
   */
  public boolean getResolved() {
    return getAsBoolean("resolved");
  }
}
