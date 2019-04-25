/*
 * Copyright 2018 Continuous Performance Test
 * 
 * 
 * This file is part of Continuous Performance Test.
 * https://github.com/continuousperftest/service-api
 * 
 * Continuous Performance Test is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 * 
 * Continuous Performance Test is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Continuous
 * Performance Test. If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.continuousperftest.storage;

public class Perfomance {

  private RequestAttribute requestAttribute;
  private ResponseAttribute responseAttribute;
  private int executionTimeInMillis;

  public RequestAttribute getRequestAttribute() {
    return requestAttribute;
  }

  public void setRequestAttribute(RequestAttribute requestAttribute) {
    this.requestAttribute = requestAttribute;
  }

  public ResponseAttribute getResponseAttribute() {
    return responseAttribute;
  }

  public void setResponseAttribute(ResponseAttribute responseAttribute) {
    this.responseAttribute = responseAttribute;
  }

  public int getExecutionTimeInMillis() {
    return executionTimeInMillis;
  }

  public void setExecutionTimeInMillis(int executionTimeInMillis) {
    this.executionTimeInMillis = executionTimeInMillis;
  }
}
